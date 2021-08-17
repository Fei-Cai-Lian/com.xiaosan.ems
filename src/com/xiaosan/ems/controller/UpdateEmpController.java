package com.xiaosan.ems.controller;

import com.xiaosan.ems.entity.Emp;
import com.xiaosan.ems.service.EmpService;
import com.xiaosan.ems.service.impl.EmpServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateEmpController", value = "/manager/safe/updateEmp")
public class UpdateEmpController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //通过 Integer 类型的 id 接收 request容器中的 id
        Integer id = Integer.valueOf(request.getParameter("id")) ;
        //通过 String 类型的 name 接收 request容器中的 name
        String name = request.getParameter("name") ;
        //通过 Double 类型的 salary 接收 request容器中的 salary
        Double salary = Double.valueOf(request.getParameter("salary")) ;
        //通过 Integer 类型中的 age 接收 request容器中的 age
        Integer age = Integer.valueOf(request.getParameter("age")) ;

        //把 id name salary age 封装进 Emp 对象中;赋值给 Emp 类型中的 emp 中
        Emp emp = new Emp(id,name,salary,age);

        EmpService empService = new EmpServiceImpl() ;
        empService.modifyEmp( emp ) ;

        response.sendRedirect(request.getContextPath()+"/manager/safe/showAllEmp");

    }
}
