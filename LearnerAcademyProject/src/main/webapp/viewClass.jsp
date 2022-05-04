<%@page import="org.hibernate.Transaction"%>
<%@page import="com.pojo.Subject"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.pojo.Classes"%>
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
<title>View Classes</title>
</head>
<body>

<h4>Available Classes:</h4>
<%
  SessionFactory sf=HibernateUtil.getSessionFactory();
  Session hibernatesession=sf.openSession();
  List<Classes> classes=hibernatesession.createQuery("from Classes").list(); 
  
		 
 
  
%>
<table>
<%
for(Classes clas : classes)
    {
	out.print("<tr>");	
	out.print("<td>" + clas.getName() + "</td>");
    }
    hibernatesession.close();
%>

</table>
<br><br>
<a href="index.html">Back To Main Menu</a><br><br>
<a href="addClasses.html">Add Classes</a><br><br>
</body>
</html>