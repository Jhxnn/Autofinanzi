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

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {
	
	@Autowired
	VeiculoService veiculoService;

	
	
	@PostMapping
	public ResponseEntity<Veiculo> createVeiculo(@RequestBody VeiculoDto veiculoDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(veiculoService.createVeiculo(veiculoDto));
	}
	@GetMapping
	public ResponseEntity<List<Veiculo>> allVeiculos(){
		return ResponseEntity.status(HttpStatus.OK).body(veiculoService.findAll());
	}
	
	@GetMapping("/status/{status}")
	public ResponseEntity<List<Veiculo>> findByStatus(@PathVariable(name = "status") StatusVeiculo status){
		return ResponseEntity.status(HttpStatus.OK).body(veiculoService.findByStatus(status));
	}
	
	@GetMapping("/menor-valor") 
	public ResponseEntity<List<Veiculo>> menorValor(){
		return ResponseEntity.status(HttpStatus.OK).body(veiculoService.veiculoByValor());
	}
	
	
	@GetMapping("/maior-valor")
	public ResponseEntity<List<Veiculo>> maiorValor(){
		return ResponseEntity.status(HttpStatus.OK).body(veiculoService.veiculoByValorMaior());
	}	
	
	@GetMapping("/valor/{min}/{max}")
	public ResponseEntity<List<Veiculo>> rangeValor(@PathVariable(name = "min") double min,
			@PathVariable(name = "max") double max){
		return ResponseEntity.status(HttpStatus.OK).body(veiculoService.rangeValor(min, max));
			
	}
	@PutMapping("/{id}")
	public ResponseEntity<Veiculo> atualizarVeiculo(@RequestBody VeiculoDto veiculoDto,
													@PathVariable(name = "id") UUID id){
		return ResponseEntity.status(HttpStatus.CREATED).body(veiculoService.atualizarVeiculo(id, veiculoDto));
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Veiculo> deleteVeiculo(@PathVariable(name = "id") UUID id){
		veiculoService.deleteVeiculo(id);
		return ResponseEntity.noContent().build();
	}
}
