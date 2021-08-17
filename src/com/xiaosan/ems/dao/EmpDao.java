package com.xiaosan.ems.dao;

import com.xiaosan.ems.entity.Emp;
import com.xiaosan.ems.entity.Page;

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
 *      补充方法——delete
 */
public interface EmpDao {
    //查询所有
    public List<Emp>selectAll(Page page) ;
    //查询员工的总数量
    public long selectCount() ;

    //删除员工_8.17 10:16
    public int delete(int id) ;

    //添加员工_8.17 10:52
    public int insert(Emp emp) ;

    //查询单个员工        _8.17 13:04
    public Emp select(int id) ;

    //修改员工数据
    public int update(Emp emp) ;
/*
   ——》实现类   dao.impl.EmpDaoImpl
 */
 }
