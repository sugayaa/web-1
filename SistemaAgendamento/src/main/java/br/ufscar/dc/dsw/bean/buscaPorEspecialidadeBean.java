package br.ufscar.dc.dsw.bean;

import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.dao.ProfissionalDAO;
import br.ufscar.dc.dsw.domain.Profissional;

public class buscaPorEspecialidadeBean {
	
	public List<Profissional> getEspecialidades(){
		ProfissionalDAO dao = new ProfissionalDAO();
		return dao.getAll();
	}
	
	public List<Profissional> getEspecialidades(String especialidade){
		ProfissionalDAO dao = new ProfissionalDAO();
		List<Profissional> listaEspecialidades;
		if(especialidade.length() > 0) {
			listaEspecialidades = dao.getAll(especialidade);
		}
		else {
			listaEspecialidades = dao.getAll();
		}
		
		return listaEspecialidades;
	}
}