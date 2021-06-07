package br.ufscar.dc.dsw.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.ufscar.dc.dsw.domain.Profissional;
import br.ufscar.dc.dsw.domain.Consulta;

public interface IProfissionalDAO extends CrudRepository<Profissional, Long> {
    Profissional findByConsulta(Consulta consulta);
    Profissional findById(Long id);
    List<Profissional> findByEspecialidade(String especialidade);
}
