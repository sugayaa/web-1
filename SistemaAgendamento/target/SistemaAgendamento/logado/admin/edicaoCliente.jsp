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
	<h1 align="center">Edição Cliente</h1>
	<div align="center">
		<form action="atualiza" method="POST">
			<fieldset>
				<label>Nome:</label>&nbsp;&nbsp;
				<input type="text" name="nome" value="${cliente.nome}"/><br><br>
				<label>E-mail:</label>&nbsp;&nbsp;
				<input type="text" name="email" value="${cliente.email}"/><br><br>
				<label>Senha:</label>&nbsp;&nbsp;
				<input type="text" name="senha" value="${cliente.senha}"/><br><br>
				<label>CPF</label>&nbsp;&nbsp;
				<input type="text" name="CPF" value="${cliente.CPF}"/><br><br>
				<label>Telefone:</label>&nbsp;&nbsp;
				<input type="text" name="telefone" value="${cliente.telefone}"/><br><br>
				<label>Sexo:</label>&nbsp;&nbsp;
				<input type="text" name="sexo" value="${cliente.sexo}"/><br><br>
				<label>Data Nascimento:</label>&nbsp;&nbsp;
				<input type="text" name="dataNascimento" value="${cliente.dataNascimento}"/><br><br>
				<label>Papel:</label>&nbsp;&nbsp;
				<input type="text" name="papel" value="${cliente.papel}"/><br><br><br>
				<input type="submit" name="editar" value="Salvar"/>
				
				<input type="hidden" name="id", value="${cliente.id}"/>
			</fieldset>
		</form>
	
	</div>
	
</body>
</html>