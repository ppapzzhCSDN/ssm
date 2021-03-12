package com.zzh.filters;

import com.zzh.constants.SysConstant;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author zzh
 * @description
 * @date
 */
@WebFilter("/*")
public class MyFilter extends HttpFilter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        //字符集
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String uri = request.getRequestURI();

        if (!(uri.endsWith("index.jsp") ||
                uri.endsWith("login/login") ||
                uri.endsWith("getCode") ||
                uri.contains("/css") ||
                uri.contains("/js")
        )) {
            HttpSession session = request.getSession();
            Object obj = session.getAttribute(SysConstant.SESSION_LOGIN);

            if (obj == null) {
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
        }
        chain.doFilter(request, response);
    }

}
