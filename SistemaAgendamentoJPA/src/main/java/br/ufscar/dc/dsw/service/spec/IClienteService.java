package br.ufscar.dc.dsw.service.spec;

import java.util.List;

import br.ufscar.dc.dsw.domain.Cliente;

public class IClienteService {

    void salvar(Cliente cliente);

    void excluir(Long id);

    Cliente buscarPorId(Long id);

    List<Cliente> buscarTodos();

}
