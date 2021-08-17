package com.xiaosan.ems.dao.impl;

import com.xiaosan.ems.dao.EmpDao;
import com.xiaosan.ems.entity.Emp;
import com.xiaosan.ems.entity.Page;
import com.xiaosan.ems.utils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * 编写顺序
 *      1——database.properties 配置文件
 *      2——utils中的 DbUtils 工具类
 *      3——entity 实体类中的 EmpManager
 *      4——dao 中的 EmpManagerDao接口
 *      5——dao 中的 EmpManagerDao接口 的实现类 EmpManagerDaoImpl
 *      6——service 中的 EmpManagerService 接口
 *      7——service 中的 EmpManagerService 接口的实现类 EmpManagerServiceImpl
 *      8——web 下的login.jsp
 *      9——controller 中的 EmpManagerLoginController
 *      10——controller 中的 ShowAllEmpController
 *      11—— controller 中的 CreateCodeController ——生成验证码
 *      12—— entity 实体类下的 Emp
 *      13—— entity 实体类下的 Page  （分页）
 *      14—— dao 下的EmpDao 接口
 *      15—— dao 下的EmpDao 接口的实现类 EmpDaoImpl
 *      补充方法——delete
 */
public class EmpDaoImpl implements EmpDao {
    private QueryRunner queryRunner = new QueryRunner() ;

    //通过分页来查询到的数据
    @Override
    public List<Emp> selectAll(Page page) {
        try {
            List<Emp> emps = queryRunner.query(DbUtils.getConnection(),"select * from emp limit ?,?",new BeanListHandler<Emp>(Emp.class),page.getStartRows(),page.getPageSize());
            return emps;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public long selectCount() {
        try {
            long count = queryRunner.query(DbUtils.getConnection(),"select count(*) from emp;",new ScalarHandler<>());
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(int id) {
        try {
            int result = queryRunner.update(DbUtils.getConnection(),"delete from emp where id = ?",id);
            return result ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int insert(Emp emp) {
        try {
            int result = queryRunner.update(DbUtils.getConnection(),"insert into emp(name, salary, age) values (?, ?, ?) ",emp.getName() ,emp.getSalary() ,emp.getAge() ) ;
            return result ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Emp select(int id) {
        try {
            //通过数据库连接，把获取到的数据封装进    BeanHandler 中
            Emp emp = queryRunner.query(DbUtils.getConnection(),"select * from emp where id = ? ",new BeanHandler<Emp>(Emp.class));
            return emp ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int update(Emp emp) {
        try {
            int result = queryRunner.update(DbUtils.getConnection(),"update emp set name=?, salary=?, age=? where id=?", emp.getName(), emp.getSalary(), emp.getAge(), emp.getId());
            return result ;   //返回受影响行数
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

/*
——》 service 下的 EmpService 接口
 */

}

