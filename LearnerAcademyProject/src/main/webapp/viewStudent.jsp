<%@page import="com.pojo.Subject"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.pojo.Student"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.util.HibernateUtil"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>view Student</title>
</head>
<body>

<h4>Available Student:</h4>
<%
  SessionFactory sf=HibernateUtil.getSessionFactory();
  Session hibernatesession=sf.openSession();
  List<Student> student = hibernatesession.createQuery("from Student").list();
  
  
%>
<table>
<%
    for(Student stud : student)
      {
	   out.print("<tr>");	
	   out.print("<td>" + stud.getFname() + "\n" +stud.getLname()+"</td>");
      }
    hibernatesession.close();
%>

</table>
<br><br>
<a href="index.html">Back To Main Menu</a><br><br>
<a href="addStudent.html">Add Student</a><br>
</body>
</html>