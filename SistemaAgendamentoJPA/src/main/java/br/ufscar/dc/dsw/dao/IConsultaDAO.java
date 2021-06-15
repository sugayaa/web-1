package br.ufscar.dc.dsw.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.ufscar.dc.dsw.domain.Consulta;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Profissional;

@SuppressWarnings("unchecked")
public interface IConsultaDAO extends CrudRepository<Consulta, Long> {

    List<Consulta> findAllByCliente(Cliente cliente);
    List<Consulta> findAllByProfissional(Profissional profissional);
    Consulta findById(long id);
    Consulta save(Consulta consulta);
    void deleteById(long id);

}
