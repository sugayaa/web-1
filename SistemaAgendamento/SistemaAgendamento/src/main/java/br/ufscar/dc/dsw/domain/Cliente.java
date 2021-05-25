package br.ufscar.dc.dsw.domain;

import java.sql.Date;

public class Cliente extends Pessoa{
	private String telefone;
    private String sexo;
    private Date dataNascimento;
    
	public Cliente(String nome, String email, String senha, String CPF, String telefone, String sexo, 
			Date dataNascimento, String papel) {
		super(nome, email, senha, CPF, papel);
		this.telefone = telefone;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
	}
	
	public Cliente(Long id, String nome, String email, String senha, String CPF, String telefone, String sexo, 
			Date dataNascimento, String papel) {
		super(id, nome, email, senha, CPF, papel);
		this.telefone = telefone;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
	}
	
	
	public String getTelefone() {
		return this.telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
    
	public String getSexo() {
		return this.sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public Date getDataNascimento() {
		return this.dataNascimento;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
