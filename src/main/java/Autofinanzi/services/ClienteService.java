package Autofinanzi.services;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Autofinanzi.dtos.ClienteDto;
import Autofinanzi.models.Cliente;
import Autofinanzi.repositories.ClienteRepository;



@Service
public class ClienteService {
	@Autowired
	ClienteRepository clienteRepository;
	
	public Cliente createCliente(ClienteDto clienteDto) {
		
		Cliente cliente = new Cliente();
		BeanUtils.copyProperties(clienteDto, cliente);
		return clienteRepository.save(cliente);
		
	}
	public Cliente findById(UUID id) {
		
		return clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));
	}
	
	public void deleteCliente(UUID id) {
		
		var cliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
		clienteRepository.delete(cliente);
		
		
	}
}
