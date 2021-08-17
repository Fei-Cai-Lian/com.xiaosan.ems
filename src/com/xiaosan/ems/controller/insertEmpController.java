package com.xiaosan.ems.controller;

import com.xiaosan.ems.entity.Emp;
import com.xiaosan.ems.service.EmpService;
import com.xiaosan.ems.service.impl.EmpServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "insertEmpController", value = "/manager/safe/insertEmp")
public class insertEmpController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取前端页面的数据
        String name = request.getParameter("name") ;
        Double salary = Double.valueOf(request.getParameter("salary")) ;
        Integer age = Integer.valueOf(request.getParameter("age")) ;

        //把请求过来的数据，封装在 Emp 对象中  参数为 name salary age
        Emp emp = new Emp(name ,salary , age);

        //调用EmpService 把封装好的emp 传递过去
        EmpService empService = new EmpServiceImpl() ;
        empService.addEmp(emp) ;

        //新增成功后，跳转回查询所有
        response.sendRedirect(request.getContextPath()+"/manager/safe/showAllEmp");
    }
}
/*
————》》修改 addEmp.jsp
 */