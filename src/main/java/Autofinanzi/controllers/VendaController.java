package Autofinanzi.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Autofinanzi.dtos.VendaDto;
import Autofinanzi.models.Venda;
import Autofinanzi.services.VendaService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/venda")
public class VendaController {
	
	@Autowired
	VendaService vendaService;
	
	@GetMapping
	@Operation(description = "Retorna todas as vendas")
	public ResponseEntity<List<Venda>> allVendas(){
		return ResponseEntity.status(HttpStatus.OK).body(vendaService.allVendas());
	}
	@GetMapping("/{id}")
	@Operation(description = "Retorna a venda pelo ID passado na URL")
	public ResponseEntity<Venda> findById(@PathVariable(name = "id")UUID id){
		return ResponseEntity.status(HttpStatus.OK).body(vendaService.findByid(id));
	}
	@GetMapping("/maior")
	@Operation(description = "Retorna as vendas com os valores do maior ao menor")
	public ResponseEntity<List<Venda>> maioresVendas(){
		return ResponseEntity.status(HttpStatus.OK).body(vendaService.maioresVendas());
	}
	@GetMapping("/menor")
	@Operation(description = "Retorna as vendas com os valores do menor ao maior")
	public ResponseEntity<List<Venda>> menoresVendas(){
		return ResponseEntity.status(HttpStatus.OK).body(vendaService.menoresVendas());
	}
	@GetMapping("/data/{inicio}/{fim}")
	@Operation(description = "Retorna todas as vendas que ocorrram da data 'inicio' ate a data 'fim'")
	public ResponseEntity<List<Venda>> vendaByData(@PathVariable(name = "inicio")LocalDate startDate, 
			@PathVariable(name = "fim")LocalDate endDate){
		return ResponseEntity.status(HttpStatus.OK).body(vendaService.vendaData(startDate, endDate));
	}
	@PostMapping
	@Operation(description = "Cria uma venda")
	public ResponseEntity<Venda> createVenda(@RequestBody VendaDto vendaDto){ 
		return ResponseEntity.status(HttpStatus.CREATED).body(vendaService.createVenda(vendaDto));
	}
	
	@PutMapping("/finalizar/{id}")
	@Operation(description = "Altera o status da venda passada na URL para 'CONCLUIDA'")
	public ResponseEntity<Venda> finalizarVenda(@PathVariable(name = "id")UUID id){
		return ResponseEntity.status(HttpStatus.CREATED).body(vendaService.finalizarVenda(id));
	}
	@PutMapping("/{id}")
	@Operation(description = "Atualiza total ou parcialmente a venda passada na URL")
	public ResponseEntity<Venda> updateVenda(@PathVariable(name = "id")UUID id, @RequestBody VendaDto vendaDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(vendaService.updateVenda(id, vendaDto));
	}
	
	@DeleteMapping("/{id}")
	@Operation(description = "Deleta a venda passada na URL")
	public ResponseEntity<Venda> deleteVenda(@PathVariable(name = "id")UUID id){
		return ResponseEntity.noContent().build();
	}
}
