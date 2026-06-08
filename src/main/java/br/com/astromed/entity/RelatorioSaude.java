package br.com.astromed.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_RELATORIO_SAUDE")
public class RelatorioSaude {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "missao_id")
    private Missao missao;

    @Column(name = "vl_frequencia_cardiaca")
    private Double frequenciaCardiaca;

    @Column(name = "vl_pressao_arterial")
    private Double pressaoArterial;

    @Column(name = "tx_observacoes")
    private String observacoes;

    // Getters e Setters Completos
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Missao getMissao() {
        return missao;
    }

    public void setMissao(Missao missao) {
        this.missao = missao;
    }

    public Double getFrequenciaCardiaca() {
        return frequenciaCardiaca;
    }

    public void setFrequenciaCardiaca(Double frequenciaCardiaca) {
        this.frequenciaCardiaca = frequenciaCardiaca;
    }

    public Double getPressaoArterial() {
        return pressaoArterial;
    }

    public void setPressaoArterial(Double pressaoArterial) {
        this.pressaoArterial = pressaoArterial;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}