<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><fmt:message key="index.bar"/></title>
</head>
<body>
	<h1 align="center"><fmt:message key="cliente.register"/></h1>
	<div align="center">
		<form action="insere" method="POST">
			<fieldset>
				<label><fmt:message key="cliente.name"/></label>&nbsp;&nbsp;
				<input type="text" name="nome"/><br><br>
				<label><fmt:message key="cadastro.email"/></label>&nbsp;&nbsp;
				<input type="text" name="email" /><br><br>
				<label><fmt:message key="cadastro.pass"/></label>&nbsp;&nbsp;
				<input type="text" name="senha" /><br><br>
				<label>CPF:</label>&nbsp;&nbsp;
				<input type="text" name="CPF" /><br><br>
				<label><fmt:message key="cliente.tel"/></label>&nbsp;&nbsp;
				<input type="text" name="telefone" /><br><br>
				<label><fmt:message key="cliente.sex"/></label>&nbsp;&nbsp;
				<input type="text" name="sexo" /><br><br>
				<label><fmt:message key="cliente.date"/></label>&nbsp;&nbsp;
				<input type="text" name="dataNascimento" /><br><br>
				<label><fmt:message key="admin.function"/></label>&nbsp;&nbsp;
				<input type="text" name="papel" /><br><br><br>
				<input type="submit" name="cadastrar" value="<fmt:message key="cadastro.go"/>"/>
				
			</fieldset>
		</form>
	
	</div>
	
</body>
</html>