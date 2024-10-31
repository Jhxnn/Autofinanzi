package Autofinanzi.services;

import java.util.List;
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
	public List<Cliente> findAll(){
		return clienteRepository.findAll();
	}
	public Cliente updateCliente(UUID id, ClienteDto clienteDto) {
		
		var cliente = clienteRepository.findById(id).orElseThrow(()-> new RuntimeException("Veiculo não encontrado"));
		if(clienteDto.cpf() != null) {
			cliente.setCpf(clienteDto.cpf());
		}
		if(clienteDto.email() != null) {
			cliente.setEmail(clienteDto.email());
		}
		if(clienteDto.name() != null) {
			cliente.setName(clienteDto.name());
		}
		
		return clienteRepository.save(cliente);
	}
}
