package Autofinanzi.controllers;

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

import Autofinanzi.dtos.VeiculoDto;
import Autofinanzi.models.Veiculo;
import Autofinanzi.models.enums.StatusVeiculo;
import Autofinanzi.services.VeiculoService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {
	
	@Autowired
	VeiculoService veiculoService;

	
	
	@PostMapping
	@Operation(description = "Cria um veiculo")
	public ResponseEntity<Veiculo> createVeiculo(@RequestBody VeiculoDto veiculoDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(veiculoService.createVeiculo(veiculoDto));
	}
	@GetMapping
	@Operation(description = "Retorna todos os veiculos cadastrados")
	public ResponseEntity<List<Veiculo>> allVeiculos(){
		return ResponseEntity.status(HttpStatus.OK).body(veiculoService.findAll());
	}
	
	
	@GetMapping("/status/{status}")
	@Operation(description = "Retorna todos os veiculos que correspondem ao status passado na URL")
	public ResponseEntity<List<Veiculo>> findByStatus(@PathVariable(name = "status") StatusVeiculo status){
		return ResponseEntity.status(HttpStatus.OK).body(veiculoService.findByStatus(status));
	}
	
	@GetMapping("/menor-valor") 
	@Operation(description = "Retorna os veiculos com os valores do menor ao maior")
	public ResponseEntity<List<Veiculo>> menorValor(){
		return ResponseEntity.status(HttpStatus.OK).body(veiculoService.veiculoByValor());
	}
	
	
	@GetMapping("/maior-valor")
	@Operation(description = "Retorna os veiculos com os valores do maior ao menor")
	public ResponseEntity<List<Veiculo>> maiorValor(){
		return ResponseEntity.status(HttpStatus.OK).body(veiculoService.veiculoByValorMaior());
	}	
	
	@GetMapping("/{id}")
	@Operation(description = "Retorna o veiculo pelo ID passado na URL")
	public ResponseEntity<Veiculo> findById(@PathVariable(name = "id")UUID id){
		return ResponseEntity.status(HttpStatus.OK).body(veiculoService.findById(id));
	}
	
	@GetMapping("/valor/{min}/{max}")
	@Operation(description = "Retorna todos os veiculos que estão entre o valor 'min' e o valor 'max'")
	public ResponseEntity<List<Veiculo>> rangeValor(@PathVariable(name = "min") double min,
			@PathVariable(name = "max") double max){
		return ResponseEntity.status(HttpStatus.OK).body(veiculoService.rangeValor(min, max));
			
	}
	@PutMapping("/{id}")
	@Operation(description = "Atualiza total ou parcialmente o veiculo passado na URL")
	public ResponseEntity<Veiculo> atualizarVeiculo(@RequestBody VeiculoDto veiculoDto,
													@PathVariable(name = "id") UUID id){
		return ResponseEntity.status(HttpStatus.CREATED).body(veiculoService.atualizarVeiculo(id, veiculoDto));
		
	}
	@DeleteMapping("/{id}")
	@Operation(description = "Deleta o veiculo passado pela URL")
	public ResponseEntity<Veiculo> deleteVeiculo(@PathVariable(name = "id") UUID id){
		veiculoService.deleteVeiculo(id);
		return ResponseEntity.noContent().build();
	}
}
