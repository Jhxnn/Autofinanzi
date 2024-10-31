
package Autofinanzi.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Autofinanzi.dtos.FinanciamentoDto;
import Autofinanzi.models.Financiamento;
import Autofinanzi.services.FinanciamentoService;

@RestController
@RequestMapping("/financiamento")
public class FinanciamentoController {

	
	@Autowired
	FinanciamentoService finService;
	
	
	@PostMapping("/{id}")
	public ResponseEntity<Double> valorParcela(@RequestBody FinanciamentoDto finDto,
								@PathVariable(name = "id")UUID id) {
		double parcela = finService.calculoFin(id, finDto.taxaJuros(), finDto.numeroParcelas(), finDto.simulacao());
		return ResponseEntity.status(HttpStatus.OK).body(parcela);
	}
	
	@PostMapping("/{id}/{qntdparcela}")
	public ResponseEntity<Financiamento> pagarParcela(@PathVariable(name = "qntdparcela") int qntdParcelas, 
													 @PathVariable(name = "id")UUID id){
		return ResponseEntity.status(HttpStatus.OK).body(finService.pagarParcela(id, qntdParcelas));
	}
	
	
							
			
}