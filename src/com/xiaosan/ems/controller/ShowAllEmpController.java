package com.xiaosan.ems.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
/**
 * 编写顺序——database.properties 配置文件
 *      ——utils中的 DbUtils 工具类
 *      ——entity 实体类中的 EmpManager
 *      ——dao 中的 EmpManagerDao接口
 *      ——dao 中的 EmpManagerDao接口 的实现类 EmpManagerDaoImpl
 *      ——service 中的 EmpManagerService 接口
 *      ——service 中的 EmpManagerService 接口的实现类 EmpManagerServiceImpl
 *      ——web 下的login.jsp
 *      ——controller 中的 EmpManagerLoginController
 *      ——controller 中的 ShowAllEmpController
 *
 */
@WebServlet(name = "ShowAllEmpController", value = "/manager/showAllEmp")
public class ShowAllEmpController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("登录成功");
    }
}
