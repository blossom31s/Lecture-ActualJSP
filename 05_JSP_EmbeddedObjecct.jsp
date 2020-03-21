<!--
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
	<context-param>
		<param-name>realServerIP</param-name>
		<param-value>72.0.143.1</param-value>
	</context-param>

	<servlet>
		<servlet-name>je</servlet-name>
		<jsp-file>/jspEx.jsp</jsp-file>
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
		<servlet-name>je</servlet-name>
		<url-pattern>/jspEx.jsp</url-pattern>
	</servlet-mapping>

</web-app>

-->

<!--
// jspEx.jsp

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="errorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%!
		String adminID;
		String adminPW;
		String imgDir;
		String testServerIP;
		String realServerIP;
		String str; // errorPage 호출을 테스트하기 위한 변수
	%>
	
	<!-- config 객체 -->
	<%
		adminID = config.getInitParameter("adminID");
		adminPW = config.getInitParameter("adminPW");
	%>
	<p>adminID : <%= adminID %></p>
	<p>adminPW : <%= adminPW %></p>
	
	<!-- application 객체 -->
	<%
		imgDir = application.getInitParameter("imgDir");
		testServerIP = application.getInitParameter("testServerIP");
		realServerIP = application.getInitParameter("realServerIP");
	%>
	<p>imgDir : <%= imgDir %></p>
	<p>testServerIP : <%= testServerIP %></p>
	<p>realServerIP : <%= realServerIP %></p>
	<%
		application.setAttribute("connectedIP", "128.5.68.2");
		application.setAttribute("connectedUser", "hong");
	%>
	
	<!-- out 객체 -->
	<%
		out.print("<h1>Hello Java World!</h1>");
		out.print("<h2>Hello JSP World!</h2>");
		out.print("<h3>Hello Servlet World!</h3>");
	%>
	
	<!-- exception 객체 -->
	<%
		// out.print(str.toString()); // 초기화되지 않은 상태에서 toString()을 사용해서 error발생, errorPage를 호출하게 됨
	%>

</body>
</html>

-->

<!--
// jspExGet.jsp

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%! // jspEx.jsp에서 application객체에 setAttribute한 값을 담기 위한 변수들
		String connectedIP;
		String connectedUser;
	%>
	
	<!-- application 객체 -->
	<%
		connectedIP = (String)application.getAttribute("connectedIP");
		connectedUser = (String)application.getAttribute("connectedUser");
	%>
	<p>connectedIP : <%= connectedIP %></p>
	<p>connectedUser : <%= connectedUser %></p>

</body>
</html>

-->

<!--
// errorPage.jsp

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		response.setStatus(200); // 200error가 발생했을 경우
		String msg = exception.getMessage();
	%>

	<h1>error message : <%= msg %></h1>

</body>
</html>

-->
