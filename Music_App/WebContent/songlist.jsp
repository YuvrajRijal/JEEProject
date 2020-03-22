<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Map p=(Map)request.getAttribute("song_values");
Set s=p.keySet();
Collection c=p.values();
Iterator itr1=c.iterator();
Iterator itr=s.iterator();
out.println("<table border=2>");
out.println("<tr>");
out.println("<td><b>Song Name</b></td>");
out.println("<td><b>Song Link</b></td>");
out.println("</tr>");

while(itr.hasNext())
{	
	out.println("<tr>");
	out.println("<td>"+ itr.next()+"</td>");
	out.println("<td><a href= "+itr1.next()+">"+"Click here"+"</td>");
	out.println("</tr>");
	
}
out.println("<table>");
%>
</body>
</html>