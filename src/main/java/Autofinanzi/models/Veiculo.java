package Autofinanzi.models;

import java.util.UUID;

import Autofinanzi.models.enums.StatusVeiculo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "veiculos")
public class Veiculo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private UUID carId;

	private String marca;

	private String modelo;

	private double valor;

    @Enumerated(EnumType.STRING)
	private StatusVeiculo statusVeiculo;
    
    
    
    
    
	
	public UUID getCarId() {
		return carId;
	}
	public void setCarId(UUID carId) {
		this.carId = carId;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public StatusVeiculo getStatusVeiculo() {
		return statusVeiculo;
	}
	public void setStatusVeiculo(StatusVeiculo statusVeiculo) {
		this.statusVeiculo = statusVeiculo;
	}
	
	
	

}
