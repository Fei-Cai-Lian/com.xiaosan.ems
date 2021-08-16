package com.xiaosan.ems.filter;

import com.xiaosan.ems.entity.EmpManager;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
 *      12—— entity 实体类下的 Emp
 *      13—— entity 实体类下的 Page  （分页）
 *      14—— dao 下的EmpDao 接口
 *      15—— dao 下的EmpDao 接口的实现类 EmpDaoImpl
 *      16—— service 下的 EmpService 接口
 *      17—— service 下的 EmpService 接口的实现类 EmpServiceImpl
 *      18—— filter 下的 CheckFilter  （权限验证的过滤器）
 */
@WebFilter(filterName = "CheckFilter" , value = "/manager/safe/*")
public class CheckFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    //权限验证
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //强转
        HttpServletRequest request = (HttpServletRequest) req ;
        HttpServletResponse response = (HttpServletResponse) resp ;
        HttpSession session = request.getSession() ;
        //接收
        EmpManager empManager = (EmpManager) session.getAttribute("empManager") ;
        //非空判断——验证是否是第一次登录
        if( empManager != null ){
            chain.doFilter(req, resp);
        }else {
            //通过重定向 跳转到 登录页面
            response.sendRedirect(request.getContextPath()+"/login.jsp");

        }
/*
 ————》controller. ShowAllEmpController
*/

    }
}
