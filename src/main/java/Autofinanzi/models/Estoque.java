package Autofinanzi.models;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "estoque")
public class Estoque {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID estoqueId;

    @JoinColumn(referencedColumnName = "id", name = "veiculo_id")
    private Veiculo veiculo;

    public UUID getEstoqueId() {
        return estoqueId;
    }

    public void setEstoqueId(UUID estoqueId) {
        this.estoqueId = estoqueId;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
}
