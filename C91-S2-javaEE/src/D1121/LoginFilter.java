package D1121;

import javaServlet.HelloServlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * urlPatterns 定义该过滤器 要过滤的资源
 * URL 格式
 * 1. 精确配置 "/main.html","/main.html"
 * 2. 文件 后缀配置 *.html
 * 3.
 */
//@WebFilter(urlPatterns = {"*.html"})
public class LoginFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        String path = request.getServletPath();
        if (!path.endsWith("login.html")) {
            if (session.getAttribute("loginedAccount") == null) {
                request.getRequestDispatcher("/AJAX/简单的企业MIS/login.html").forward(request, response);
                return;
            }
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
