/*

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="msu" method="post">
		name : <input type="text" name="m_name"><br>
		password : <input type="password" name="m_pass"><br>
		gender : Man<input type="radio" name="m_gender" value="M" checked="checked">,
				 Woman<input type="radio" name="m_gender" value="W"><br>
		hobby : Sport<input type="checkbox" name="m_hobby" value="sport">,
				Cooking<input type="checkbox" name="m_hobby" value="cooking">,
				Reading<input type="checkbox" name="m_hobby" value="reading">,
				Travel<input type="checkbox" name="m_hobby" value="travel"><br>
		residence : <select name="m_residence">
				<option value="seoul" selected="selected">Seoul</option>
				<option value="gyeonggi">Gyeonggi</option>
				<option value="gyeongsang">Gyeongsang</option>
				<option value="chungcheong">Chungcheong</option>
				<option value="jeonra">Jeonra</option>
				<option value="gangwon">Gangwon</option>
				<option value="jeju">Jeju</option>
			</select><br>
		<input type="submit" value="sign up">
	</form>
</body>
</html>

*/

package com.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/msu")
public class GetVsPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-- doGet() --");

		String m_name = request.getParameter("m_name");
		String m_pass = request.getParameter("m_pass");
		String m_gender = request.getParameter("m_gender");
		String[] m_hobby = request.getParameterValues("m_hobby");
		String m_residence = request.getParameter("m_residence");

		System.out.println("m_name : " + m_name);
		System.out.println("m_pass : " + m_pass);
		System.out.println("m_gender : " + m_gender);
		System.out.println("m_hobby : " + Arrays.toString(m_hobby));
		System.out.println("m_residence : " + m_residence);

		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()) {
			String name = (String)names.nextElement();
			System.out.println("name : " + name);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-- doPost() --");
		doGet(request, response);
	}

}
