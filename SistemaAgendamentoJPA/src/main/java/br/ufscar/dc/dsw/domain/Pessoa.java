package br.ufscar.dc.dsw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "Pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = false, length = 60)
    private String nome;

    @Column(nullable = false, unique = true, length = 60)
    private String email;

    @Column(nullable = false, unique = false, length = 60)
    private String senha;

    @Column(nullable = false, unique = true, length = 15)
    private String CPF;

    @Column(nullable = false, unique = false, length = 10)
    private String sexo;

    @Column(nullable = false, unique = false, length = 60)
    private String papel;

    public Pessoa() {
    }

    public Pessoa(String nome, String email, String senha, String CPF, String papel) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.CPF = CPF;
        this.papel = papel;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public long getCPF() {
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

    public long getPapel() {
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
        sb.append("cpf: " + cpf + ", ");
        sb.append("sexo: " + sexo + ", ");
        sb.append("papel: " + papel + ", ");
        sb.append("]");
        return sb.toString(); 
    }
}
