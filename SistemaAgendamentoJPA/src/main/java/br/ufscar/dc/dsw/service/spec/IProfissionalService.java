package br.ufscar.dc.dsw.service.spec;

import java.util.List;

import br.ufscar.dc.dsw.domain.Profissional;

public class IProfissionalService {

    public void salvar(Profissional profissional);

    public void excluir(Long id);

    public Profissional buscarPorId(Long id);

    public List<Profissional> buscarTodos();

}
