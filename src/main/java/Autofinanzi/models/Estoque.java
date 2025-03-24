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


}
