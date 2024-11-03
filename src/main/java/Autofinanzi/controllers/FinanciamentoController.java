
package Autofinanzi.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Autofinanzi.dtos.FinanciamentoDto;
import Autofinanzi.models.Financiamento;
import Autofinanzi.services.FinanciamentoService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/financiamento")
public class FinanciamentoController {

	
	@Autowired
	FinanciamentoService finService;
	
	@PostMapping
	@Operation(description = "Cria financiamento passando os dados ja prontos")
	public ResponseEntity<Financiamento> createFin(@RequestBody FinanciamentoDto finDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(finService.createFin(finDto));
	}
	
	@GetMapping("/simulacao/{idVeiculo}")
	@Operation(description = "Faz uma simualação de qual valor da parcela com base na taxa e na quantidade de parcelas")
	public ResponseEntity<Financiamento> valorParcelaSimulacao(@RequestBody FinanciamentoDto finDto,
								@PathVariable(name = "idVeiculo")UUID id) {
		
		Financiamento parcela = finService.calculoFin(id, finDto.taxaJuros(), finDto.numeroParcelas());
		return ResponseEntity.status(HttpStatus.OK).body(parcela);
	}
	
	@PostMapping("/{idVeiculo}")
	@Operation(description = "Calcula o valor da parcela e salva todos os dados no financiamento")
	public ResponseEntity<Financiamento> valorParcela(@RequestBody FinanciamentoDto finDto,
								@PathVariable(name = "idVeiculo")UUID id) {
		Financiamento fin = finService.criarFin(id, finDto.taxaJuros(), finDto.numeroParcelas());
		return ResponseEntity.status(HttpStatus.OK).body(fin);
	}
	
	
	@GetMapping("/{id}")
	@Operation(description = "Busca o financiamento pelo ID passado na URL")
	public ResponseEntity<Financiamento> findById(@PathVariable(name = "id")UUID id){
		return ResponseEntity.status(HttpStatus.OK).body(finService.findByID(id));
	}
	@GetMapping
	@Operation(description = "Retorna todos os financiamentos")
	public ResponseEntity<List<Financiamento>> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(finService.findAll());
	}
	
	
	@PostMapping("/{id}/{qntdparcela}")
	@Operation(description = "Com o Id do financiamento e quantidade de parcela pagas, é salvo na tabela o novo valor total e quantas parcela ainda faltam")
	public ResponseEntity<Financiamento> pagarParcela(@PathVariable(name = "qntdparcela") int qntdParcelas, 
													 @PathVariable(name = "id")UUID id){
		return ResponseEntity.status(HttpStatus.OK).body(finService.pagarParcela(id, qntdParcelas));
	}
	
	
							
			
}