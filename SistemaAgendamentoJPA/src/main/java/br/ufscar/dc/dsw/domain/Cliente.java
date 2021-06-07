package br.ufscar.dc.dsw.domain;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table(name = "Cliente")
public class Cliente extends Pessoa{

    // Change to number and format ?
    @Column(nullable = false, unique = false, length = 12)
    private String dataNascimento;

    // Change to number and format ?
    @Column(nullable = false, unique = true, length = 20)
    private String telefone;

    @OneToMany(mappedBy = "cliente")
    private List<Consulta> consultas;

    public Cliente(
            String nome,
            String email,
            String senha,
            String CPF,
            String sexo,
            String papel,
            String dataNascimento,
            String telefone
            )
    {
        super(nome, email, senha, CPF, sexo, papel); 
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.consultas = new List<Consulta>;
    }

    public Cliente(
            String nome,
            String email,
            String senha,
            String CPF,
            String sexo,
            String papel,
            String dataNascimento,
            String telefone,
            List<Consulta> consultas
            )
    {
        super(nome, email, senha, CPF, sexo, papel); 
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.consultas = consultas;
    }

    public Long getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        sb.append("Nome: " + this.getNome() + ", ");
        sb.append("data nascimento: " + dataNascimento + ", ");
        sb.append("telefone: " + telefone + ", ");
        sb.append("sexo: " + sexo + ", ");
        sb.append("]");
        return sb.toString(); 
    }
}
