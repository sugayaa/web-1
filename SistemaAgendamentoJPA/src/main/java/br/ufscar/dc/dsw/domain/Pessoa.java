package br.ufscar.dc.dsw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@SuppressWarnings("serial")
@Entity
@Table(name = "Pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa extends AbstractEntity<Long> {

    @NotBlank
    @Column(nullable = false, unique = false, length = 60)
    private String nome;

    @NotBlank
    @Column(nullable = false, unique = true, length = 60)
    private String email;

    @NotBlank
    @Column(nullable = false, unique = false, length = 60)
    private String senha;

    @NotBlank
    @Column(nullable = false, unique = true, length = 15)
    private String CPF;

    @NotBlank
    @Column(nullable = false, unique = false, length = 10)
    private String sexo;

    @NotBlank
    @Column(nullable = false, unique = false, length = 60)
    private String papel;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        sb.append("Nome: " + nome + ", ");
        sb.append("email: " + email + ", ");
        sb.append("cpf: " + CPF + ", ");
        sb.append("sexo: " + sexo + ", ");
        sb.append("papel: " + papel + ", ");
        sb.append("]");
        return sb.toString(); 
    }
}
