package com.xiaosan.ems.controller;

import com.xiaosan.ems.service.EmpService;
import com.xiaosan.ems.service.impl.EmpServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
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
 *
 *      18—— filter 下的 CheckFilter  （权限验证的过滤器）
 *      19—— 补充 controller 中的 ShowAllEmpController 中的 dopost
 *      20+—— 补充 controller 中的 DeleteEmpController
 */
@WebServlet(name = "DeleteEmpController", value = "/manager/safe/deleteEmp")
public class DeleteEmpController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));

        EmpService empService = new EmpServiceImpl() ;
        empService.deleteEmp(id);
        //删除成功，再一个执行查询所有，显示查询页面
        response.sendRedirect(request.getContextPath()+"/manager/safe/showAllEmp");

    }
}
/*
————》》emplist.jsp
 */