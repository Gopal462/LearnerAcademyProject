<%@page import="com.pojo.Subject"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.pojo.Subject"%>
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
<title>view Subject</title>
</head>
<body>

<h4>Available Subject:</h4>

<%
  SessionFactory sf=HibernateUtil.getSessionFactory();
  Session hibernatesession=sf.openSession();
  List<Subject> subject= hibernatesession.createQuery("from Subject").list();
   
  
%>
<table>
<%
    for(Subject sub : subject)
      {
	   out.print("<tr>");	
	   out.print("<td>" + sub.getName() + "</td>");
      }
    hibernatesession.close();
%>
</table>
<br><br>
<a href="index.html">Back To Main Menu</a><br><br>
<a href="addSubject.html">Add Subject</a><br>
</body>
</html>