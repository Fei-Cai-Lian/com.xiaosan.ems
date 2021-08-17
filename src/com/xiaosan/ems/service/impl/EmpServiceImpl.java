package com.xiaosan.ems.service.impl;

import com.xiaosan.ems.dao.EmpDao;
import com.xiaosan.ems.dao.impl.EmpDaoImpl;
import com.xiaosan.ems.entity.Emp;
import com.xiaosan.ems.entity.Page;
import com.xiaosan.ems.service.EmpService;
import com.xiaosan.ems.utils.DbUtils;

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
 *      16—— service 下的 EmpService 接口
 *      17—— service 下的 EmpService 接口的实现类 EmpServiceImpl
 *
 */
public class EmpServiceImpl implements EmpService {
    private EmpDao empDao = new EmpDaoImpl() ;

    @Override
    public List<Emp> showAllEmpByPage(Page page) {
        List<Emp> emps = null ;
        try {
            DbUtils.begin() ;
            //获取总条数数据
            long count = empDao.selectCount() ;
            //赋值总条数，计算总页数
            page.setTotalCounts((int)count) ;
            emps = empDao.selectAll(page) ;
            DbUtils.commit() ;
        } catch (Exception e) {
            //日常回滚
            DbUtils.rollback();
            e.printStackTrace();
        }
        return emps ;
    }

    @Override
    public int deleteEmp(int id) {
        int result = 0 ;
        try {
            DbUtils.begin();
            result = empDao.delete(id) ;
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int addEmp(Emp emp) {
        int result = 0 ;
        try {
            DbUtils.begin();
            result = empDao.insert(emp) ;
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    //查询单个
    @Override
    public Emp selectEmpById(int id) {
        Emp emp = null ;
        try {
            DbUtils.begin();
            emp = empDao.select(id);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return emp;
    }

    @Override
    public int modifyEmp(Emp emp) {
        int result = 0 ;
        try {
            DbUtils.begin();
            result = empDao.update(emp);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }
}
/*
————》 补充    登录成功    controller.ShowAllEmpController
           controller.DeleteEmpController
           controller.insertEmpController
           controller.ShowEmpController

 */