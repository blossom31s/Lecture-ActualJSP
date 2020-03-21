/*
// login.jsp

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	if(session.getAttribute("sessionMemberID") != null)
		response.sendRedirect("loginOK.jsp");
%>
<form action="lic" method="post">
	ID : <input type="text" name="memberID"><br>
	PW : <input type="password" name="memberPW"><br>
	<input type="submit" value="login">
</form>
</body>
</html>

*/

/*
// loginOK.jsp

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	session = request.getSession();
	out.print("memberID : " + session.getAttribute("sessionMemberID") + "<br>");
%>
<form action="loc" method="post">
	<input type="submit" value="logout">
</form>
</body>
</html>

*/

/*
// LoginConfirm.java

package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/lic")
public class LoginConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String mID = request.getParameter("memberID");
		String mPW = request.getParameter("memberPW");
		PrintWriter out = response.getWriter();

		out.print("mID : " + mID);
		out.print("mPW : " + mPW);

		HttpSession session = request.getSession();
		session.setAttribute("sessionMemberID", mID);

		response.sendRedirect("loginOK.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

*/

/*
// LogoutConfirm.java

package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loc")
public class LogoutConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.invalidate();

		response.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

*/
