package com.java2.web.filter;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.java2.web.service.UserService;

public class AuthentacationFilter implements Filter {

	WebApplicationContext context;

	FilterConfig fc;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		fc = filterConfig;
		context = WebApplicationContextUtils.getWebApplicationContext(fc.getServletContext());
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// getUser info by userName.
		// compare userPasswoed in HttpRequest is equals password in DB

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		String basicCreditial = httpRequest.getHeader("Authorization");
		String[] array = basicCreditial.split(" ");
		String creditial = new String(Base64.getDecoder().decode(array[1]));
		String[] creditialArry = creditial.split(":");
		String userName = creditialArry[0];
		String password = creditialArry[1];

		UserService us = (UserService) context.getBean("userServiceImpl");

		// String str = new String(Base64)
		 boolean passAuth = us.isUserCreditialValid(userName, password);
		if (passAuth) {
			chain.doFilter(request, response);
		} else {
			// response.getOutputStream().
			// HttpServletResponse httpResponse = (HttpServletResponse)
			// response;
			httpResponse.sendError(401, "username or password is not right");
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
