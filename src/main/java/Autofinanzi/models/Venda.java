package Autofinanzi.models;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vendas")
public class Venda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID venda;
	@Column(name = "id_cliente")
	private UUID idCliente;
	@Column(name = "id_veiculo")
	private UUID idVeiculo;
	@Column(name = "id_financiamento")
	private UUID idFinanciamento;
	private String formaPagamento;
	
	

}
