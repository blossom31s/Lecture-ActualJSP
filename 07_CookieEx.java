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
	Cookie[] cookies = request.getCookies();
	System.out.println("cookies : " + cookies);

	if(cookies != null) {
		for(Cookie c : cookies) {
			if(c.getName().equals("cookieMemberID")) {
				response.sendRedirect("loginOK.jsp");
			}
		}
	}
%>
<form action="lc" method="post">
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
	Cookie[] cookies = request.getCookies();
	for(Cookie c : cookies) {
		out.print("name : " + c.getName() + "<br>");
		out.print("value : " + c.getValue() + "<br>");
		out.print("------------------------------<br>");
	}
%>
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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lc")
public class LoginConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String mID = request.getParameter("memberID");
		String mPW = request.getParameter("memberPW");
		PrintWriter out = response.getWriter();

		out.print("mID : " + mID);
		out.print("mPW : " + mPW);

		Cookie[] cookies = request.getCookies();
		Cookie cookie = null;

		for(Cookie c : cookies) {
			System.out.println("c.getName() : " + c.getName() + " / c.getValue() : " + c.getValue());

			if(c.getName().equals("cookieMemberID")) cookie = c;
		}

		if(cookie == null) {
			System.out.println("Cookie is null");
			cookie = new Cookie("cookieMemberID", mID);
		}

		response.addCookie(cookie);
		cookie.setMaxAge(60 * 60);

		response.sendRedirect("loginOK.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

*/
