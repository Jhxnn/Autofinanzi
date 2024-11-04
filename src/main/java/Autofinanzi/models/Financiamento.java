package Autofinanzi.models;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "financimentos")
public class Financiamento {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private UUID finId;
	private double valorTotal;
	private int numeroParcelas;
	private double taxaJuros;
	private double valorParcela;
	private double entrada;
	
	public Financiamento( double valorTotal, int numeroParcelas, double taxaJuros, double valorParcela, double entrada) {
		this.valorTotal = valorTotal;
		this.numeroParcelas = numeroParcelas;
		this.taxaJuros = taxaJuros;	
		this.valorParcela = valorParcela;
		this.entrada = entrada;
	}
	
	public Financiamento() {
		
	}
	

	public UUID getFinId() {
		return finId;
	}

	public void setFinId(UUID finId) {
		this.finId = finId;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public int getNumeroParcelas() {
		return numeroParcelas;
	}

	public void setNumeroParcelas(int numeroParcelas) {
		this.numeroParcelas = numeroParcelas;
	}

	public double getTaxaJuros() {
		return taxaJuros;
	}

	public void setTaxaJuros(double taxaJuros) {
		this.taxaJuros = taxaJuros;
	}

	public double getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(double valorParcela) {
		this.valorParcela = valorParcela;
	}

	public double getEntrada() {
		return entrada;
	}

	public void setEntrada(double entrada) {
		this.entrada = entrada;
	}
	
	
	
	

}
