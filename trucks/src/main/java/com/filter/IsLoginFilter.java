package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class IsLoginFilter implements Filter {

	public IsLoginFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("开始检查");
		try {
			if (request.getParameter("isLogin").isEmpty()) {
				System.out.println("未登录");
			} else {
				System.out.println("已登录");
			}
		} catch (Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}

		System.out.println("检查结束");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("初始化");
	}

}
