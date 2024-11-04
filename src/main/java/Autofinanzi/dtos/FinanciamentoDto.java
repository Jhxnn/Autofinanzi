package Autofinanzi.dtos;

import java.util.UUID;

public record FinanciamentoDto(
		int numeroParcelas,
		double taxaJuros,
		double entrada
		) {

}
