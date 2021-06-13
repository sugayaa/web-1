package br.ufscar.dc.dsw.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.ufscar.dc.dsw.domain.Consulta;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Profissional;

@SuppressWarnings("unchecked")
public interface IConsultaDAO extends CrudRepository<Consulta, Long> {

    List<Consulta> findByCliente(Cliente cliente);
    List<Consulta> findByProfissional(Profissional profissional);
    Consulta findById(Long id);
    void save(Consulta consulta);
    void deleteById(Long id);

}
