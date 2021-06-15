package br.ufscar.dc.dsw.SistemaAgendamento;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.ufscar.dc.dsw.dao.IClienteDAO;
import br.ufscar.dc.dsw.dao.IProfissionalDAO;
import br.ufscar.dc.dsw.dao.IConsultaDAO;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Profissional;
import br.ufscar.dc.dsw.domain.Consulta;

@SpringBootApplication
public class SistemaAgendamentoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SistemaAgendamentoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(IClienteDAO clienteDAO, BCryptPasswordEncoder encoder, IProfissionalDAO profissionalDAO, IConsultaDAO consultaDAO) {
        return (args) -> {

            Cliente c1 = new Cliente();
            c1.setEmail("admin@admin.com");
            c1.setSenha(encoder.encode("admin"));
            c1.setCPF("012.345.678-90");
            c1.setNome("Administrador");
            c1.setTelefone("1103948291");
            c1.setDataNascimento("01/01/1990");
            c1.setPapel("ROLE_ADMIN");
            clienteDAO.save(c1);

            Cliente c2 = new Cliente();
            c2.setEmail("beltrano@gmail.com");
            c2.setSenha(encoder.encode("123"));
            c2.setCPF("985.849.614-10");
            c2.setNome("Beltrano Andrade");
            c2.setTelefone("1133948291");
            c2.setDataNascimento("02/01/1990");
            c2.setPapel("ROLE_USER");
            clienteDAO.save(c2);

            Cliente c3 = new Cliente();
            c3.setEmail("fulano@email.com");
            c3.setSenha(encoder.encode("123"));
            c3.setCPF("367.318.380-04");
            c3.setTelefone("1173948291");
            c3.setDataNascimento("03/01/1990");
            c3.setNome("Fulano Silva");
            c3.setPapel("ROLE_USER");
            clienteDAO.save(c3);

            Profissional p1 = new Profissional();
            p1.setCPF("55.789.390-39");
            p1.setEmail("letras@editora.com");
            p1.setEspecialidade("Membros superiores");
            p1.setCurriculo("/dev/null");
            profissionalDAO.save(p1);

            Profissional p2 = new Profissional();
            p2.setEmail("record.editora@email.com");
            p2.setEspecialidade("Membros inferiores");
            p2.setCurriculo("/proc/shm1");
            profissionalDAO.save(p2);

            Profissional p3 = new Profissional();
            p3.setEmail("objetiva@email.com");
            p3.setEspecialidade("Membros medianos");
            p3.setCurriculo("/proc/shm2");
            profissionalDAO.save(p3);

            Consulta con1 = new Consulta();
            con1.setCliente(c1);
            con1.setProfissional(p1);
            consultaDAO.save(con1);

            Consulta con2 = new Consulta();
            con2.setCliente(c2);
            con2.setProfissional(p2);
            consultaDAO.save(con2);

            Consulta con3 = new Consulta();
            con3.setCliente(c3);
            con3.setProfissional(p3);
            consultaDAO.save(con3);
        };
    }
}
