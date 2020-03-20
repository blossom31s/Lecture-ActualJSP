<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- header.jsp : <p>HEADER</p> -->
<%@ include file="header.jsp" %>

<!-- 선언부 -->
<%!
	int num = 10;
	String str = "jsp";
	ArrayList<String> list = new ArrayList<String>();

	public void jspMethod() {
		System.out.println("-- jspMethod() --");
	}
%>

<!-- 스크립트릿 -->
<%
	if(num > 0) {
%>
	<p> num > 0 </p>
<%
	} else {
%>
	<p> num <= 0 </p>
<%
	}
%>

<!-- 표현식 -->
num is <%= num %>

<!-- footer.jsp : <p>FOOTER</p> -->
<%@ include file="footer.jsp" %>

</body>
</html>
