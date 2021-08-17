package com.xiaosan.ems.controller;

import com.xiaosan.ems.entity.Emp;
import com.xiaosan.ems.service.EmpService;
import com.xiaosan.ems.service.impl.EmpServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ShowEmpController", value = "/manager/safe/showEmp")
public class ShowEmpController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取　id 的数据
        Integer id = Integer.valueOf(request.getParameter("id")) ;

        EmpService empService = new EmpServiceImpl() ;
        Emp emp = empService.selectEmpById( id ) ;

        //把 emp 存储在request作用域中， 用于临时的数据传递
        request.setAttribute("emp",emp);

        //转发到 updateEmp.jsp 页面
        request.getRequestDispatcher("/updateEmp.jsp").forward(request,response);
    }
}
/*
————》》编写updateEmp.jsp
 */