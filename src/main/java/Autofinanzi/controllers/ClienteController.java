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

import Autofinanzi.dtos.ClienteDto;
import Autofinanzi.models.Cliente;
import Autofinanzi.services.ClienteService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired 
	ClienteService clienteService;
	
	
	@GetMapping("/{id}")
	@Operation(description = "Busca o cliente pelo ID")
	public ResponseEntity<Cliente> findById(@PathVariable(name = "id") UUID id){
		
		
		var cliente = clienteService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(cliente);
		
	}
	
	@PostMapping
	@Operation(description = "Cria um cliente")
	public ResponseEntity<Cliente> createCliente(@RequestBody ClienteDto clienteDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.createCliente(clienteDto));
	
	}
	
	@DeleteMapping("{id}")
	@Operation(description = "Deleta o cliente pelo ID passado")
	public ResponseEntity<Cliente> deleteCliente(@PathVariable(name = "id")UUID id){
		clienteService.deleteCliente(id);
		return ResponseEntity.noContent().build();
	}
	@GetMapping
	@Operation(description = "Mostra todos os clientes cadastrados")
	public ResponseEntity<List<Cliente>> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll());
	}
	@PutMapping("/{id}")
	@Operation(description = "Atualiza total ou parcialmente os dados do cliente passado pelo ID")
	public ResponseEntity<Cliente> updateCliente(@PathVariable(name = "id") UUID id,
			@RequestBody ClienteDto clienteDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.updateCliente(id, clienteDto));
	}
	
}
