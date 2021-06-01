package br.ufscar.dc.dsw.domain;

import java.sql.Date;
import java.sql.Time;

public class Consulta {
	
	private String nome;
	private Date data;
	private Time horario;
	private String url;
	
	public Consulta(String nome, Date data, Time horario, String url) {
		this.nome = nome;
		this.data = data;
		this.horario = horario;
		this.url = url;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public Date getData() {
		return this.data;
	}
	
	public Time getHorario() {
		return this.horario;
	}
	
	public String getUrl() {
		return this.url;
	}
}
