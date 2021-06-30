package br.ufscar.dc.dsw.domain;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("serial")
@JsonIgnoreProperties(value = { "cliente", "profissional" })
@Entity
@Table(name = "Consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "{NotNull.consulta.data}")
    @Column(nullable = false, length = 19)
    private String data;

    @NotNull(message = "{NotNull.consulta.horario}")
    @Column(nullable = false, length = 15)
    private String horario;

    @Column(nullable = false, length = 500)
    private String url;

    @NotNull(message = "{NotNull.consulta.cliente}")
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @NotNull(message = "{NotNull.consulta.profissional}")
    @ManyToOne
    @JoinColumn(name = "profissional_id")
    private Profissional profissional;

    @Column(length = 50)
    private String nomeProfissional;

    @Column(length = 50)
    private String nomeCliente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.nomeCliente = cliente.getNome();
        this.cliente = cliente;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.nomeProfissional = profissional.getNome();
        this.profissional = profissional;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNomeProfissional() {
        return nomeProfissional;
    }

    public void setNomeProfissional(String nomeProfissional) {
        this.nomeProfissional = nomeProfissional;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        sb.append("data: " + data + ", ");
        sb.append("horario: " + horario + ", ");
        sb.append("url: " + url + ", ");
        sb.append("cliente: " + cliente + ", ");
        sb.append("profissional: " + profissional + ", ");
        sb.append("]");
        return sb.toString(); 
    }

}
