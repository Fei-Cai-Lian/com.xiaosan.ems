package com.xiaosan.ems.controller;

import com.xiaosan.ems.entity.Emp;
import com.xiaosan.ems.entity.Page;
import com.xiaosan.ems.service.EmpService;
import com.xiaosan.ems.service.impl.EmpServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
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
 *
 *      18—— filter 下的 CheckFilter  （权限验证的过滤器）
 *      19—— 补充 controller 中的 ShowAllEmpController 中的 dopost
 */
@WebServlet(name = "ShowAllEmpController", value = "/manager/safe/showAllEmp")
public class ShowAllEmpController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //权限验证————写到了过滤器里面  filter 下的 CheckFilter
/*
    》》 EmpManagerLoginController 跳转到这里
 */
        String pageIndex = request.getParameter("pageIndex") ;
        //判断 当前页码是否为空
        if( pageIndex == null ){
            pageIndex="1" ;
        }
        Page page = new Page(Integer.valueOf(pageIndex)) ;

        //获取集合
        EmpService empService = new EmpServiceImpl() ;
        List<Emp> emps = empService.showAllEmpByPage(page) ;

        //在 request 作用域中存储  emps 、page
        request.setAttribute("emps",emps);
        request.setAttribute("page",page);

        //通过转发——》跳转到 emplist.jsp 页面
        request.getRequestDispatcher("/emplist.jsp").forward(request,response);
/*
——》 编写页面 emplist.jsp
 */
    }
}
//——》 验证登录是否成功 ——》controller.CreateCodeController——————》doPost—— System.out.println("登录成功");
