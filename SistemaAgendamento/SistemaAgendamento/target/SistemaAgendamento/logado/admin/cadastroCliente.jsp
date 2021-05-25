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
	<h1 align="center">Cadastro Cliente</h1>
	<div align="center">
		<form action="insere" method="POST">
			<fieldset>
				<label>Nome:</label>&nbsp;&nbsp;
				<input type="text" name="nome"/><br><br>
				<label>E-mail:</label>&nbsp;&nbsp;
				<input type="text" name="email" /><br><br>
				<label>Senha:</label>&nbsp;&nbsp;
				<input type="text" name="senha" /><br><br>
				<label>CPF</label>&nbsp;&nbsp;
				<input type="text" name="CPF" /><br><br>
				<label>Telefone:</label>&nbsp;&nbsp;
				<input type="text" name="telefone" /><br><br>
				<label>Sexo:</label>&nbsp;&nbsp;
				<input type="text" name="sexo" /><br><br>
				<label>Data Nascimento:</label>&nbsp;&nbsp;
				<input type="text" name="dataNascimento" /><br><br>
				<label>Papel:</label>&nbsp;&nbsp;
				<input type="text" name="papel" /><br><br><br>
				<input type="submit" name="cadastrar" value="Cadastrar"/>
				
			</fieldset>
		</form>
	
	</div>
	
</body>
</html>