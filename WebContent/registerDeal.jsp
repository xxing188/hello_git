<%@page import="com.xiang.registration.service.impl.UserManagerImpl"%>
<%@page import="com.xiang.registration.model.User"%>
<%@page import="com.xiang.registration.service.UserManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String username = request.getParameter("username");
String password = request.getParameter("password");
String psssword2 = request.getParameter("password2");
String url = "jdbc:mysql://localhost/spring";

User u = new User();
u.setUsername(username);
u.setPassword(password);

Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection(url,"root","root");

UserManager um = new UserManagerImpl();
boolean exist = um.exists(u);
if(exist){
	response.sendRedirect("registerFail.jsp");
	return;
}

um.add(u);

response.sendRedirect("registerSuccess.jsp");
%>