<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%request.setAttribute("theex", new Exception("My message")); %>
<c:catch var="theex">
<%int i= 1; %>
<%=100/(i-1) %> 
<!-- if no exception is catch here, "My message"
 will be printed out. but here we have a divide by zero 
 exception. so the message printed is "/by zero"-->
</c:catch>
${ theex.message }
</body>
</html>