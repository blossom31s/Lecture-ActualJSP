<!--
// memberSignUp.html

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="script.jsp" method="post">
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
-->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	String m_name;
	String m_pass;
	String m_gender;
	String[] m_hobby;
	String m_residence;
%>

<!-- 스크립트릿 -->
<%
	m_name = request.getParameter("m_name");
	m_pass = request.getParameter("m_pass");
	m_gender = request.getParameter("m_gender");
	m_hobby = request.getParameterValues("m_hobby");
	m_residence = request.getParameter("m_residence");
%>

	<!-- 표현식 -->
	m_name : <%= m_name %><br>
	m_pass : <%= m_pass %><br>
	m_gender : <%= m_gender %><br>
	m_hobby :
	<%
		for(int i=0 ; i<m_hobby.length ; i++) {
	%>
		<%= m_hobby[i] %>
	<%
		}
	%><br>
	m_residence : <%= m_residence %><br>

<!-- footer.jsp : <p>FOOTER</p> -->
<%@ include file="footer.jsp" %>
</body>
</html>
