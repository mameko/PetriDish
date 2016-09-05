<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% ArrayList alist = new ArrayList();
	alist.add("A");
	pageContext.setAttribute("list", alist);
	alist.add("b");
		alist.add("c");
%>
<c:forEach items="${list }" var="counter">
${ counter }
</c:forEach>
</body>
</html>