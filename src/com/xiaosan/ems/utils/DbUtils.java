package com.xiaosan.ems.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 编写顺序——database.properties 配置文件
 *      ——utils中的 DbUtils 工具类
 *
 */
public class DbUtils {
    /**
     * 负责   数据库连接池的创建、数据连接的获取、事务的控制
     */

    private static DruidDataSource ds ;
    private static final ThreadLocal<Connection>THREAD_LOCAL = new ThreadLocal<>() ;

    //同步代码块
    static {
        Properties properties = new Properties() ;
        //获取DbUtils 自身的流   ——字节输入流
        InputStream is = DbUtils.class.getResourceAsStream("/database.properties");
        try {
            //加载
            properties.load(is);
            ds=(DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取数据库连接对象的方法
    public static Connection getConnection(){
        Connection connection = THREAD_LOCAL.get() ;
        try {
            //判断是否为空
            if( connection == null ){
                //若空，则创建连接
                connection = ds.getConnection() ;
                //存储
                THREAD_LOCAL.set(connection);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection ;
    }

    //事务开启 方法
    public static void begin(){
        Connection connection = null ;
        try {
            connection = getConnection() ;
            connection.setAutoCommit(false) ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //事务提交 方法
    public static void commit(){
        Connection connection = null ;
        try {
            connection = getConnection() ;
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(connection , null , null);
        }
    }

    //事务回滚
    public static void rollback(){
        Connection connection = null ;
        try {
            connection = getConnection() ;
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(connection , null , null);
        }
    }

    //关闭所有事务
     public static void closeAll(Connection connection , Statement statement , ResultSet resultSet){
         try {
             if(resultSet != null){
                 resultSet.close();
             }
             if(statement != null){
                 statement.close();
             }
             if(connection != null){
                 connection.close();
                 THREAD_LOCAL.remove();
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }

}
