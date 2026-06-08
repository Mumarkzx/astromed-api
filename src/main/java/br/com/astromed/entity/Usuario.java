package br.com.astromed.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "usuario")
    private List<Missao> missoes;

    @Column(name = "nm_usuario")
    private String nome;

    @Column(name = "ds_email")
    private String email;

    @Column(name = "ds_funcao")
    private String funcao;

    // Getters e Setters Completos
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Missao> getMissoes() {
        return missoes;
    }

    public void setMissoes(List<Missao> missoes) {
        this.missoes = missoes;
    }

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

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}