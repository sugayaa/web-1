package br.ufscar.dc.dsw.domain;

public abstract class Pessoa {
	protected String nome;
	protected String email;
	protected String senha;
	protected String CPF;
	protected Long id;
	protected String papel;
	
	public Pessoa(String nome, String email, String senha, String CPF, String papel) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.CPF = CPF;
		this.papel = papel;
	}
	
	public Pessoa(Long id, String nome, String email, String senha, String CPF, String papel) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.CPF = CPF;
		this.id = id;
		this.papel = papel;
	}
	
	public Long getId() {
		return this.id;
	}
	
	protected void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	protected void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	protected void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return this.senha;
	}
	
	protected void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getCPF() {
		return this.CPF;
	}
	
	protected void setCPF(String CPF) {
		this.CPF = CPF;
	}
	
	public String getPapel() {
		return this.papel;
	}
	
	protected void setPapel(String papel) {
		this.papel = papel;
	}
}
