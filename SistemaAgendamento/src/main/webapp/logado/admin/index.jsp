<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><fmt:message key="index.bar"/></title>
</head>
<body>
	<%String contextPath = request.getContextPath().replace("/", ""); %>
	
	<a href="/<%=contextPath%>/admin/CRUD/cliente/listaCliente"><fmt:message key="index.cclient"/></a> &nbsp;&nbsp;&nbsp;
	<a href="/<%=contextPath%>/admin/CRUD/profissional/listaProfissional"><fmt:message key="index.cprofessional"/></a>
</body>
</html>