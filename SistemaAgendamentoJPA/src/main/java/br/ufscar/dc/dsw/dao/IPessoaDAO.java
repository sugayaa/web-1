package br.ufscar.dc.dsw.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.ufscar.dc.dsw.domain.Pessoa;

@SuppressWarnings("unchecked")
public interface IPessoaDAO extends CrudRepository<Pessoa, Long> {

    Pessoa findById(Long id);
    List<Pessoa> findAll();
    Pessoa save(Pessoa pessoa);
    void deleteById(Long id);

}
