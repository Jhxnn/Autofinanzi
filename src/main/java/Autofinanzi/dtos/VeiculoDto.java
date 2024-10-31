package Autofinanzi.dtos;

import Autofinanzi.models.enums.StatusVeiculo;

public record VeiculoDto(String marca, String modelo, int valor, StatusVeiculo statusVeiculo) {

}
