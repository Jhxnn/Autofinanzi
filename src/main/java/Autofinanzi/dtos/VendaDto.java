package Autofinanzi.dtos;

import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

import Autofinanzi.models.enums.StatusVenda;

public record VendaDto(UUID idCliente, UUID idVeiculo,UUID idFinanciamento, StatusVenda statusVenda, LocalDate data) {

}
