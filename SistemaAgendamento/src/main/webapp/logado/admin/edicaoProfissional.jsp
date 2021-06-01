<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Espaço ADMIN</title>
</head>
<body>
	<h1 align="center">Edição Profissional</h1>
	<div align="center">
		<form action="atualiza" method="POST" enctype="multipart/form-data">
			<fieldset>
				<input type="hidden" name="id" value="${profissional.id}"/>
				<label>Nome:</label>&nbsp;&nbsp;
				<input type="text" name="nome" value="${profissional.nome}"/><br><br>
				<label>E-mail:</label>&nbsp;&nbsp;
				<input type="email" name="email" value="${profissional.email}"/><br><br>
				<label>Senha:</label>&nbsp;&nbsp;
				<input type="text" name="senha" value="${profissional.senha}"/><br><br>
				<label>CPF</label>&nbsp;&nbsp;
				<input type="text" name="CPF" value="${profissional.CPF}"/><br><br>
				<label>Especialidade:</label>&nbsp;&nbsp;
				<input type="text" name="especialidade" value="${profissional.especialidade}"/><br><br>
				<label>Currículo:</label>&nbsp;&nbsp;
				<input type="file" name="curriculo" accept=".pdf"/><br><br><br><br><br>
				<input type="submit" name="editar" value="Salvar"/>
				
				
			</fieldset>
		</form>
	
	</div>
	
</body>
</html>