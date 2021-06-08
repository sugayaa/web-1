package br.ufscar.dc.dsw.SistemaAgendamento;

import java.util.List;
import jav.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.ufscar.dc.dsw.dao.IProfissionalDAO;
import br.ufscar.dc.dsw.dao.IConsultaDAO;
import br.ufscar.dc.dsw.dao.IPessoaDAO;
import br.ufscar.dc.dsw.domain.Pessoa;
import br.ufscar.dc.dsw.domain.Consulta;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Profissional;

@SpringBootApplication
public class SpringDataJpaApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(IPessoaDAO pessoaDAO, IProfissionalDAO profissionalDAO, IConsultaDAO consultaDAO) {
        return (args) -> {

            Cliente cliente = new Cliente("Vitor", "vitor@dc", "1234", "CPF", "Masc", "user", "01/01/1990", "12telefone");

            log.info("Salvando cliente Vitor, vitor@dc");

            pessoaDAO.save(cliente);

            Profissional profissional = new Profissional("Vitor Medico", "vitor.medico@dc", "1234", "CPF", "Masc", "user", "medicina em medicina", "/some/path/to/curriculum");

            log.info("Salvando Profissional 1");

            pessoaDAO.save(profissional);

            Consulta consulta = new Consulta("Consulta Vitor -> Vitor", "01/01/1990", "meiodia", "someurl", cliente, profissional);

            log.info("Salvando Consulta");

            consultaDAO.save(consulta);

            Cliente another_cliente = new Cliente("Another Vitor", "another_vitor@dc", "1234", "CPF2", "Masc", "user", "01/01/1990", "12telefone");

            pessoaDAO.save(another_cliente);

            List<Pessoa> pessoas = pessoaDAO.findAll();

            log.info("Imprimindo pessoas - findAll()");

            for (Pessoa p : pessoas) {
                log.info(p.toString());
            }

        };
    }
}
