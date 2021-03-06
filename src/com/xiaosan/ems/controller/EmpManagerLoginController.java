package com.xiaosan.ems.controller;

import com.xiaosan.ems.entity.EmpManager;
import com.xiaosan.ems.service.EmpManagerService;
import com.xiaosan.ems.service.impl.EmpManagerServiceImpl;

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
 */
@WebServlet(name = "EmpManagerLoginController", value = "/manager/empManagerLogin")
public class EmpManagerLoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//  ——》过滤器
        //收参
        String username = request.getParameter("username") ;
        String password = request.getParameter("password") ;
        //收参——验证码
        String inputVcode = request.getParameter("inputVcode") ;

        String codes = (String) request.getSession().getAttribute("codes");
        /*
        对验证码进行判断
         */
        //非空 且 验证码正确（不区分大小写）
        if( ! inputVcode.isEmpty() && inputVcode.equalsIgnoreCase(codes) ){

            //调用业务逻辑
            EmpManagerService empManagerService = new EmpManagerServiceImpl() ;
            EmpManager empManager = empManagerService.login(username,password) ;
            //对登录进行判断
            if(empManager != null ){
                //获取session 权限存储
                HttpSession session = request.getSession() ;
                session.setAttribute("empManager",empManager);

                //通过重定向，跳转到 查询所有的controller

                response.sendRedirect(request.getContextPath()+"/manager/safe/showAllEmp");

/*
————》controller.ShowAllEmpController
 */

            }else {
                //为空，重定向到登陆页面——login.jsp
                response.sendRedirect(request.getContextPath()+ "/login.jsp");
            }

        }else {
            //为空 或者 验证码不正确——重定向到登录页面
            response.sendRedirect(request.getContextPath()+ "/login.jsp");
        }
/*
————》测试 登录页面 是否有验证码————结果：能出现验证码，且能验证成功，控制台显示登录成功
————》分页查询 ——entity 实体类下的 Emp
*/
    }
}
