<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Espaço ADMIN</title>
</head>
<body>
	<%String contextPath = request.getContextPath().replace("/", ""); %>
	
	<a href="/<%=contextPath%>/admin/CRUD/cliente/listaCliente">CRUD Clientes</a> &nbsp;&nbsp;&nbsp;
	<a href="/<%=contextPath%>/admin/CRUD/profissional/listaProfissional">CRUD Profissionais</a>
</body>
</html>