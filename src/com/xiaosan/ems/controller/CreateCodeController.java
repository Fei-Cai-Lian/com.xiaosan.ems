package com.xiaosan.ems.controller;

import cn.dsna.util.images.ValidateCode;

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
 *      11—— controller 中的 CreateCodeController ——生成验证码
 */
@WebServlet(name = "CreateCodeController", value = "/createCode")
public class CreateCodeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response) ;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //四参创建 验证码
        ValidateCode validateCode = new ValidateCode( 200,30,4,10) ;
        //获取输入内容
        String codes = validateCode.getCode() ;
        //在session 作用域中存储 验证码
        HttpSession session = request.getSession() ;
        session.setAttribute("codes" , codes);

        //响应给客户端页面
        validateCode.write(response.getOutputStream());
//      ————》》去 login.jsp 中添加 validateCode 即验证码框 ;去 controller 下的 EmpManagerLoginController 收参

    }
}
