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

@RestController
@RequestMapping("/venda")
public class VendaController {
	
	@Autowired
	VendaService vendaService;
	
	@GetMapping
	public ResponseEntity<List<Venda>> allVendas(){
		return ResponseEntity.status(HttpStatus.OK).body(vendaService.allVendas());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Venda> findById(@PathVariable(name = "id")UUID id){
		return ResponseEntity.status(HttpStatus.OK).body(vendaService.findByid(id));
	}
	@GetMapping("/maior")
	public ResponseEntity<List<Venda>> maioresVendas(){
		return ResponseEntity.status(HttpStatus.OK).body(vendaService.maioresVendas());
	}
	@GetMapping("/menor")
	public ResponseEntity<List<Venda>> menoresVendas(){
		return ResponseEntity.status(HttpStatus.OK).body(vendaService.menoresVendas());
	}
	@GetMapping("/data/{inicio}/{fim}")
	public ResponseEntity<List<Venda>> vendaByData(@PathVariable(name = "inicio")LocalDate startDate, 
			@PathVariable(name = "fim")LocalDate endDate){
		return ResponseEntity.status(HttpStatus.OK).body(vendaService.vendaData(startDate, endDate));
	}
	@PostMapping
	public ResponseEntity<Venda> createVenda(@RequestBody VendaDto vendaDto){ 
		return ResponseEntity.status(HttpStatus.CREATED).body(vendaService.createVenda(vendaDto));
	}
	@PutMapping("/{id}")
	public ResponseEntity<Venda> finalizarVenda(@PathVariable(name = "id")UUID id){
		return ResponseEntity.status(HttpStatus.CREATED).body(vendaService.finalizarVenda(id));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Venda> deleteVenda(@PathVariable(name = "id")UUID id){
		return ResponseEntity.noContent().build();
	}
}
