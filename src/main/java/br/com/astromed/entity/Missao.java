package br.com.astromed.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_MISSAO")
public class Missao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "missao")
    private List<RelatorioSaude> relatorios;

    @Column(name = "nm_missao")
    private String nomeMissao;

    @Column(name = "ds_destino")
    private String destino;

    @Column(name = "tx_status")
    private String status;

    // Getters e Setters Completos
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<RelatorioSaude> getRelatorios() {
        return relatorios;
    }

    public void setRelatorios(List<RelatorioSaude> relatorios) {
        this.relatorios = relatorios;
    }

    public String getNomeMissao() {
        return nomeMissao;
    }

    public void setNomeMissao(String nomeMissao) {
        this.nomeMissao = nomeMissao;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}