<%@page import="com.pojo.Subject"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.pojo.Teacher"%>
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
<title>View Teacher</title>
</head>
<body>

<h4>Available Teacher:</h4>
<%
  SessionFactory sf=HibernateUtil.getSessionFactory();
  Session hibernatesession=sf.openSession();
  List<Teacher> teacher=hibernatesession.createQuery("from Teacher").list();
 
  
%>
<table>
<%
    for(Teacher teach :teacher )
      {
	   out.print("<tr>");	
	   out.print("<td>" + teach.getFname()+"\n"+teach.getLname()+"</td>");
      }
    hibernatesession.close();
%>

</table>
<br><br>
<a href="index.html">Back To Main Menu</a><br><br>
<a href="addTeacher.html">Add Teacher</a><br>
</body>
</html>