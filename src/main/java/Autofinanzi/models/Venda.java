package Autofinanzi.models;

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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "vendas")
public class Venda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID venda;
	
	 @ManyToOne
	 @JoinColumn(name = "id_cliente", referencedColumnName = "id")
	 private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "veiculo_id", referencedColumnName = "id")	
	private Veiculo veiculo;
	
	@ManyToOne
    @JoinColumn(name = "id_financiamento", referencedColumnName = "id")
    private Financiamento financiamento;
	
    @Enumerated(EnumType.STRING)
	private StatusVenda statusVenda;
    private LocalDate data;
    
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public Financiamento getFinanciamento() {
		return financiamento;
	}
	public void setFinanciamento(Financiamento financiamento) {
		this.financiamento = financiamento;
	}
	public StatusVenda getStatusVenda() {
		return statusVenda;
	}
	public void setStatusVenda(StatusVenda statusVenda) {
		this.statusVenda = statusVenda;
	}
	

}
