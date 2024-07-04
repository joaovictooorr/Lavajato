package domain;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_CARRO")
public class Carro implements Persistente{

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="carro_seq")
    @SequenceGenerator(name="carro_seq", sequenceName="sq_carro", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "NOMEPROPRIETARIO", nullable = false, length = 100)
    private String nomeProprietario;

    @Column(name = "MODELOVEICULO", nullable = false, length = 100)
    private String modeloVeiculo;

    @Column(name = "PLACAVEICULO", nullable = false, length = 100)
    private String placaVeiculo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeProprietario() {
        return nomeProprietario;
    }

    public void setNomeProprietario(String nomeProprietario) {
        this.nomeProprietario = nomeProprietario;
    }

    public String getModeloVeiculo() {
        return modeloVeiculo;
    }

    public void setModeloVeiculo(String modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }
}
