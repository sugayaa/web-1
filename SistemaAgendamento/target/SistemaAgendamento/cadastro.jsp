<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Cadastro</title>
	<script type="text/javascript" src="js/alteraForms.js"></script>
</head>
<body>
	<div align="center" id="cadastro">
		<p>Cadastrar como: </p>
		<select name="tipo" id="tipo" onchange="altera()">
			<option value="1">Profissional</option>
			<option value="2">Cliente</option>
		</select><br>
		<div id="formCadastro">
			<h1 >Cadastro Profissional</h1>
			<form action="cadastroProfissional" method="POST" enctype="multipart/form-data">
				<fieldset>
					<input type="hidden" name="papel" value="profi"/>
					<label>Nome:</label>&nbsp;&nbsp;
					<input type="text" name="nome" /><br><br>
					<label>E-mail:</label>&nbsp;&nbsp;
					<input type="text" name="email" /><br><br>
					<label>Senha:</label>&nbsp;&nbsp;
					<input type="password" name="senha" /><br><br>
					<label>CPF</label>&nbsp;&nbsp;
					<input type="text" name="CPF" /><br><br>
					<label>Especialidade:</label>&nbsp;&nbsp;
					<input type="text" name="especialidade" /><br><br>
					<label>Currículo:</label>&nbsp;&nbsp;
					<input type="file" name="curriculo" accept=".pdf"/><br><br><br><br><br>
					<input type="submit" name="cadastrar" value="Cadastrar"/>	
	
				</fieldset>
			</form>
		</div>
	</div>
</body>
</html>