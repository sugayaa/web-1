package br.ufscar.dc.dsw.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Consulta;

@SupressWarnings("unchecked")
public interface IClienteDAO extends CrudRepository<Cliente, Long> {
    Cliente findByConsulta(Consulta consulta);
    Cliente findById(Long id);
    Cliente save(Cliente cliente);
    void deleteById(Long id);

    @Query("SELECT c FROM Cliente c WHERE c.username = :username")
    public Cliente getUserByUsername(@Param("username") String username);
}
