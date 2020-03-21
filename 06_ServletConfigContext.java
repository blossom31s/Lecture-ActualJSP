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

	<context-param>
		<param-name>imgDir</param-name>
		<param-value>/upload/img</param-value>
	</context-param>
	<context-param>
		<param-name>testServerIP</param-name>
		<param-value>127.0.0.1</param-value>
	</context-param>

	<servlet>
		<servlet-name>ServletEx1</servlet-name>
		<servlet-class>com.servlet.ServletEx1</servlet-class>
		<init-param>
			<param-name>adminID</param-name>
			<param-value>admin</param-value>
		</init-param>
		<init-param>
			<param-name>adminPW</param-name>
			<param-value>123</param-value>
		</init-param>
	</servlet>
	<servlet-mapping>
		<servlet-name>ServletEx1</servlet-name>
		<url-pattern>/se1</url-pattern>
	</servlet-mapping>

	<servlet>
		<servlet-name>ServletEx2</servlet-name>
		<servlet-class>com.servlet.ServletEx2</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>ServletEx2</servlet-name>
		<url-pattern>/se2</url-pattern>
	</servlet-mapping>
</web-app>

*/

/*
// ServletEx1.java

package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletEx1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("-- doGet() --");

		String adminID = getServletConfig().getInitParameter("adminID");
		String adminPW = getServletConfig().getInitParameter("adminPW");

		PrintWriter out = response.getWriter();

		out.print("<p>adminID : " + adminID + "</p>");
		out.print("<p>adminPW : " + adminPW + "</p>");

		String imgDir = getServletContext().getInitParameter("imgDir");
		String testServerIP = getServletContext().getInitParameter("testServerIP");

		out.print("<p>imgDir : " + imgDir + "</p>");
		out.print("<p>testServerIP : " + testServerIP + "</p>");

		getServletContext().setAttribute("connectedIP", "134.62.57.31");
		getServletContext().setAttribute("connectedUser", "hong");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

*/

/*
// ServletEx2.java

package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletEx2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("-- doGet() --");

		PrintWriter out = response.getWriter();

		String connectedIP = (String)getServletContext().getAttribute("connectedIP");
		String connectedUser = (String)getServletContext().getAttribute("connectedUser");

		out.print("<p>connectedIP : " + connectedIP + "</p>");
		out.print("<p>connectedUser : " + connectedUser + "</p>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

*/
