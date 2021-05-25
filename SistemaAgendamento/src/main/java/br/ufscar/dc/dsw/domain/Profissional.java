package br.ufscar.dc.dsw.domain;

public class Profissional extends Pessoa{
	private String especialidade;
	private String curriculo;
	
	public Profissional(String nome, String email, String senha, String CPF, String especialidade, String curriculo, String papel) {
		super(nome, email, senha, CPF, papel);
		this.especialidade = especialidade;
		this.curriculo = curriculo;
	}
	
	public Profissional(Long id, String nome, String email, String senha, String CPF, String especialidade, String curriculo, String papel) {
		super(id, nome, email, senha, CPF, papel);
		this.especialidade = especialidade;
		this.curriculo = curriculo;
	}
	
	public String getEspecialidade() {
		return this.especialidade;
	}
	
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
	public String getCurriculo() {
		return this.curriculo;
	}
	
	public void setCurriculo(String curriculo) {
		this.curriculo = curriculo;
	}
}
