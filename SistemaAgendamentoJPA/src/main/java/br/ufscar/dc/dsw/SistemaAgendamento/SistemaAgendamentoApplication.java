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
            c1.setUsername("admin");
            c1.setPassword(encoder.encode("admin"));
            c1.setCPF("012.345.678-90");
            c1.setName("Administrador");
            c1.setTelefone("1103948291");
            c1.setDataNascimento("01/01/1990");
            c1.setRole("ROLE_ADMIN");
            c1.setEnabled(true);
            clienteDAO.save(c1);

            Cliente c2 = new Cliente();
            c2.setUsername("beltrano");
            c2.setPassword(encoder.encode("123"));
            c2.setCPF("985.849.614-10");
            c2.setName("Beltrano Andrade");
            c2.setTelefone("1133948291");
            c2.setDataNascimento("02/01/1990");
            c2.setRole("ROLE_USER");
            c2.setEnabled(true);
            clienteDAO.save(c2);

            Cliente c3 = new Cliente();
            c3.setUsername("fulano");
            c3.setPassword(encoder.encode("123"));
            c3.setCPF("367.318.380-04");
            c3.setTelefone("1173948291");
            c3.setDataNascimento("03/01/1990");
            c3.setName("Fulano Silva");
            c3.setRole("ROLE_USER");
            c3.setEnabled(true);
            clienteDAO.save(c3);

            Profissional p1 = new Profissional();
            p1.setCPF("55.789.390-39");
            p1.setNome("Companhia das Letras");
            p1.setEspecialidade("Membros superiores");
            p1.setCurriculo("/dev/null");
            profissionalDAO.save(p1);

            Profissional p2 = new Profissional();
            p2.setCNPJ("71.150.470/0001-40");
            p2.setNome("Record");
            p2.setEspecialidade("Membros inferiores");
            p2.setCurriculo("/proc/shm1");
            profissionalDAO.save(p2);

            Profissional p3 = new Profissional();
            p3.setCNPJ("32.106.536/0001-82");
            p3.setNome("Objetiva");
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
