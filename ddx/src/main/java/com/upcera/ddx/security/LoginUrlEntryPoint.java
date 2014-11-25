package com.upcera.ddx.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

public class LoginUrlEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		String targetUrl = null;
		String url = request.getRequestURI();

		if (url.indexOf("lab") != -1) {
			// 未登录而访问后台受控资源时，跳转到技工间登录页面
			targetUrl = "/userAction/login.do?error=sessionOut";
		} else {
			// 未登录而访问前台受控资源时，跳转到诊所登录页面
			targetUrl = "/userAction/login.do?error=sessionOut";
		}

		targetUrl = request.getContextPath() + targetUrl;
		response.sendRedirect(targetUrl);
	}
}
