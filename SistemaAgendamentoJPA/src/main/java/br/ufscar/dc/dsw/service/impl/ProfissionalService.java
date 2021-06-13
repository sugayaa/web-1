package br.ufscar.dc.dsw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import br.ufscar.dc.dsw.domain.Profissional;
import br.ufscar.dc.dsw.service.spec.IProfissionalService;

@Service
@Transactional(readOnly = false)
public class ProfissionalService implements IProfissionalService {

    @Autowired
    IProfissionalDAO dao;

    public void salvar(Profissional profissional) {
        dao.save(profissional);
    }

    public void excluir(Long id) {
        dao.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Usuario buscarPorId(Long id) {
        return dao.findById(id.longValue());
    }

    @Transactional(readOnly = true)
    public List<Profissional> buscarTodos() {
        return dao.findAll();
    }

}
