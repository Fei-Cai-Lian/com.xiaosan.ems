package com.xiaosan.ems.dao.impl;

import com.xiaosan.ems.dao.EmpManagerDao;
import com.xiaosan.ems.entity.EmpManager;
import com.xiaosan.ems.utils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;


/**
 * 编写顺序——database.properties 配置文件
 *      ——utils中的 DbUtils 工具类
 *      ——entity 实体类中的 EmpManager
 *      ——dao 中的 EmpManagerDao接口
 *      ——dao 中的 EmpManagerDao接口 的实现类 EmpManagerDaoImpl
 *
 */
public class EmpManagerDaoImpl implements EmpManagerDao {
    private QueryRunner queryRunner = new QueryRunner() ;

    @Override
    public EmpManager select(String username) {
        //获取数据
        try {
            EmpManager empManager = queryRunner.query(DbUtils.getConnection(),"select * from empManager where username=?;" , new BeanHandler<EmpManager>(EmpManager.class),username) ;
            return empManager ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}//——》service.EmpManagerService
