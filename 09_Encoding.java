/*
// web.xml

<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://xmlns.jcp.org/xml/ns/javaee" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd" id="WebApp_ID" version="3.1">
  <display-name>ActualJSP</display-name>
  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.htm</welcome-file>
    <welcome-file>index.jsp</welcome-file>
    <welcome-file>default.html</welcome-file>
    <welcome-file>default.htm</welcome-file>
    <welcome-file>default.jsp</welcome-file>
  </welcome-file-list>

	<!-- filter -->
	<filter>
		<filter-name>encodingFilter</filter-name>
		<filter-class>com.servlet.encoFilter</filter-class>
	</filter>
	<filter-mapping>
		<filter-name>encodingFilter</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>

</web-app>

*/

/*
// formEx.jsp

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	[ Servlet을 이용한 경우 ]
	<form action="su" method="post">
		이름 : <input type="text" name="m_name"><br>
		별명 : <input type="text" name="m_nickname"><br>
		<input type="submit" value="sign up">
	</form>

	<br>

	[ JSP를 이용한 경우 ]
	<form action="signUp.jsp" method="post">
		이름 : <input type="text" name="m_name"><br>
		별명 : <input type="text" name="m_nickname"><br>
		<input type="submit" value="sign up">
	</form>
</body>
</html>

*/

/*
// SignUp.java

package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/su")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String mName = request.getParameter("m_name");
		String mNickname = request.getParameter("m_nickname");
		PrintWriter out = response.getWriter();

		out.print("<p> mName : " + mName + "</p>");
		out.print("<p> mNickname : " + mNickname + "</p>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

*/

/*
// signUp.jsp

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
	String mName;
	String mNickname;
%>
<%
	mName = request.getParameter("m_name");
	mNickname = request.getParameter("m_nickname");
%>
	이름 : <%= mName %><br>
	별명 : <%= mNickname %>
</body>
</html>

*/

/*
// encoFilter.java

package com.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class encoFilter implements Filter {

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("-- filter init() --");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("-- filter doFilter() --");

		// request filter
		request.setCharacterEncoding("UTF-8");

		chain.doFilter(request, response);

		// response filter
	}

	@Override
	public void destroy() {
		System.out.println("-- filter destroy() --");
	}

}

*/
