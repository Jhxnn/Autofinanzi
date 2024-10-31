package Autofinanzi.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Autofinanzi.dtos.VeiculoDto;
import Autofinanzi.models.Veiculo;
import Autofinanzi.repositories.VeiculoRepository;

@Service
public class VeiculoService {

	@Autowired
	VeiculoRepository veiculoRepository;
	
	
	public Veiculo findById(UUID id) {
		
		return veiculoRepository.findById(id).orElseThrow(()-> new RuntimeException("Cliente não encontrado"));
		
	}
	
	
	public List<Veiculo> findAll(){
		return veiculoRepository.findAll();
	}
	
	public Veiculo createVeiculo(VeiculoDto veiculoDto) {
		
		var veiculo = new Veiculo();
		BeanUtils.copyProperties(veiculoDto, veiculo);
		return veiculoRepository.save(veiculo);
		
	}
	public void deleteVeiculo(UUID id) {
		
		var veiculo = veiculoRepository.findById(id).orElseThrow(()-> new RuntimeException("Cliente não encontrado"));
		veiculoRepository.delete(veiculo);
	}
}
