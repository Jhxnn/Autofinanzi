package Autofinanzi.models;

import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

import Autofinanzi.models.enums.StatusVenda;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
    @Enumerated(EnumType.STRING)
	private StatusVenda statusVenda;
    private LocalDate data;
    
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public UUID getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(UUID idCliente) {
		this.idCliente = idCliente;
	}
	public UUID getIdVeiculo() {
		return idVeiculo;
	}
	public void setIdVeiculo(UUID idVeiculo) {
		this.idVeiculo = idVeiculo;
	}
	public UUID getIdFinanciamento() {
		return idFinanciamento;
	}
	public void setIdFinanciamento(UUID idFinanciamento) {
		this.idFinanciamento = idFinanciamento;
	}
	public StatusVenda getStatusVenda() {
		return statusVenda;
	}
	public void setStatusVenda(StatusVenda statusVenda) {
		this.statusVenda = statusVenda;
	}
	

}
