package com.xiaosan.ems.service;

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
 *      15—— dao 下的EmpDao 接口的实现类 EmpDaoImpl
 *      16—— service 下的 EmpService 接口
 *          补充 删除操作
 */
public interface EmpService {
    public List<Emp> showAllEmpByPage(Page page) ;

    //删除
    public int deleteEmp(int id) ;

    //添加
    public int addEmp(Emp emp) ;

    //查询
    public Emp selectEmpById(int id) ;

    //修改
    public int modifyEmp(Emp emp) ;

}
/*
——》 service 下的impl 下的Service.impl.EmpServiceImpl
 */