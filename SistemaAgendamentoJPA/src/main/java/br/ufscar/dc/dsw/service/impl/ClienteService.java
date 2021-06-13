package br.ufscar.dc.dsw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.service.spec.IClienteService;

@Service
@Transactional(readOnly = false)
public class ClienteService implements IClienteService {

    @Autowired
    IClienteDAO dao;

    public void salvar(Cliente cliente) {
        dao.save(cliente);
    }

    public void excluir(Long id) {
        dao.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Usuario buscarPorId(Long id) {
        return dao.findById(id.longValue());
    }

    @Transactional(readOnly = true)
    public List<Cliente> buscarTodos() {
        return dao.findAll();
    }

}
