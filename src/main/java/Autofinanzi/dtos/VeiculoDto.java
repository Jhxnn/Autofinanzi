package Autofinanzi.dtos;

import Autofinanzi.models.enums.StatusVeiculo;

public record VeiculoDto(String marca, String modelo, double valor, StatusVeiculo statusVeiculo) {

}
