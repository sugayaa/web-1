package br.ufscar.dc.dsw.utill;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public final class Erros implements Serializable{
	private final List<String> erros;
	
	public Erros() {
		this.erros = new ArrayList<String>();
	}
	
	public void add(String msg) {
		this.erros.add(msg);
	}
	
	public boolean isExisteErro() {
		return !this.erros.isEmpty();
	}
	
	public List<String> getErros(){
		return this.erros;
	}

}
