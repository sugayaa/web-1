function altera(){
	var tipo = document.getElementById("tipo");
	var valor = tipo.value;
	console.log(valor);
	var divContainer = document.getElementById("formCadastro");
	divContainer.innerHTML = "";
	var h1 = document.createElement('h1');
	var form = document.createElement('form');
	form.method = "POST";
	if(valor === "1"){
		h1.innerHTML = "Cadastro Profissional";
		form.enctype="multipart/form-data";
		form.action = "cadastroProfissional";
		form.insertAdjacentHTML('beforeend', '<fieldset>'+
											'<input type="hidden" name="papel" value="profi"/>'+
											'<label>Nome:</label>&nbsp;&nbsp;'+
											'<input type="text" name="nome" /><br><br>'+
											'<label>E-mail:</label>&nbsp;&nbsp;'+
											'<input type="text" name="email" /><br><br>'+
											'<label>Senha:</label>&nbsp;&nbsp;'+
											'<input type="password" name="senha" /><br><br>'+
											'<label>CPF</label>&nbsp;&nbsp;'+
											'<input type="text" name="CPF" /><br><br>'+
											'<label>Especialidade:</label>&nbsp;&nbsp;'+
											'<input type="text" name="especialidade" /><br><br>'+
											'<label>Currículo:</label>&nbsp;&nbsp;'+
											'<input type="file" name="curriculo" accept=".pdf"/><br><br><br><br><br>'+
											'<input type="submit" name="cadastrar" value="Cadastrar"/>'+
										    '</fieldset>');
	}
	else{
		h1.innerHTML = "Cadastro Cliente";
		form.action = "cadastroCliente";
		form.insertAdjacentHTML('beforeend', '<fieldset>'+
											'<input type="hidden" name="papel" value="user"/>'+
											'<label>Nome:</label>&nbsp;&nbsp;'+
											'<input type="text" name="nome" /><br><br>'+
											'<label>E-mail:</label>&nbsp;&nbsp;'+
											'<input type="text" name="email" /><br><br>'+
											'<label>Senha:</label>&nbsp;&nbsp;'+
											'<input type="password" name="senha" /><br><br>'+
											'<label>CPF</label>&nbsp;&nbsp;'+
											'<input type="text" name="CPF" /><br><br>'+
											'<label>Telefone:</label>&nbsp;&nbsp;'+
											'<input type="text" name="telefone" /><br><br>'+
											'<label>Sexo:</label>&nbsp;&nbsp;'+
											'<input type="text" name="sexo" /><br><br>'+
											'<label>Data Nascimento:</label>&nbsp;&nbsp;'+
											'<input type="text" name="dataNascimento" /><br><br>'+
											'<input type="submit" name="cadastrar" value="Cadastrar"/>'+
										    '</fieldset>');
	}
	
	divContainer.appendChild(h1);
	divContainer.appendChild(form);
}