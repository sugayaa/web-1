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
	<h1 align="center"><fmt:message key="cliente.edit"/></h1>
	<div align="center">
		<form action="atualiza" method="POST">
			<fieldset>
				<label><fmt:message key="cliente.name"/></label>&nbsp;&nbsp;
				<input type="text" name="nome" value="${cliente.nome}"/><br><br>
				<label><fmt:message key="cadastro.email"/></label>&nbsp;&nbsp;
				<input type="text" name="email" value="${cliente.email}"/><br><br>
				<label><fmt:message key="cadastro.pass"/></label>&nbsp;&nbsp;
				<input type="text" name="senha" value="${cliente.senha}"/><br><br>
				<label>CPF:</label>&nbsp;&nbsp;
				<input type="text" name="CPF" value="${cliente.CPF}"/><br><br>
				<label><fmt:message key="cliente.tel"/></label>&nbsp;&nbsp;
				<input type="text" name="telefone" value="${cliente.telefone}"/><br><br>
				<label><fmt:message key="cliente.sex"/></label>&nbsp;&nbsp;
				<input type="text" name="sexo" value="${cliente.sexo}"/><br><br>
				<label><fmt:message key="cliente.date"/></label>&nbsp;&nbsp;
				<input type="text" name="dataNascimento" value="${cliente.dataNascimento}"/><br><br>
				<label><fmt:message key="admin.function"/></label>&nbsp;&nbsp;
				<input type="text" name="papel" value="${cliente.papel}"/><br><br><br>
				<input type="submit" name="editar" value="<fmt:message key="cadastro.save"/>"/>
				
				<input type="hidden" name="id" value="${cliente.id}"/>
			</fieldset>
		</form>
	
	</div>
	
</body>
</html>