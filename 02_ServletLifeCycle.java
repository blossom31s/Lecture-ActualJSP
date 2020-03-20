package com.servlet;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/slc")
public class ServletLifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("-- doGet() --");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	@PostConstruct
	public void postConstruct() throws ServletException {
		System.out.println("-- postConstruct() --");
	}

	// servlet 생성
	@Override
	public void init() throws ServletException {
		System.out.println("-- init() --");
	}

	// servlet 소멸
	@Override
	public void destroy() {
		System.out.println("-- destroy() --");
	}

	@PreDestroy
	public void preDestroy() throws ServletException {
		System.out.println("-- preDestroy() --");
	}

}
