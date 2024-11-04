package Autofinanzi.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Autofinanzi.dtos.VeiculoDto;
import Autofinanzi.models.Veiculo;
import Autofinanzi.models.enums.StatusVeiculo;
import Autofinanzi.repositories.VeiculoRepository;
import Autofinanzi.models.enums.StatusVeiculo;
@Service
public class VeiculoService {

	@Autowired
	VeiculoRepository veiculoRepository;
	
	
	public Veiculo findById(UUID id) {
		
		return veiculoRepository.findById(id).orElseThrow(()-> new RuntimeException("Veiculo não encontrado"));
		
	}
	
	public List<Veiculo> findByStatus(StatusVeiculo status){
		return veiculoRepository.findByStatusVeiculo(status);
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
		
		var veiculo = veiculoRepository.findById(id).orElseThrow(()-> new RuntimeException("Veiculo não encontrado"));
		veiculoRepository.delete(veiculo);
	}
	public List<Veiculo> veiculoByValor(){
		return veiculoRepository.findAllVeiculosMenorValor();
	}
	public List<Veiculo> veiculoByValorMaior(){
		return veiculoRepository.findAllVeiculosMaiorValor();
	}
	
	public Veiculo atualizarVeiculo(UUID id, VeiculoDto veiculoDto) {
		
		var veiculo = veiculoRepository.findById(id).orElseThrow(()-> new RuntimeException("Veiculo não encontrado"));
		if(veiculoDto.marca() != null) {
			veiculo.setMarca(veiculoDto.marca());
		}
		if(veiculoDto.statusVeiculo() != null) {
			veiculo.setStatusVeiculo(veiculoDto.statusVeiculo());
		}
		if(veiculoDto.modelo() != null) {
			veiculo.setModelo(veiculoDto.modelo());
		}
		if(veiculoDto.valor() >= 0) {
			veiculo.setValor(veiculoDto.valor());
		}
		
		return veiculoRepository.save(veiculo);

	}
	public List<Veiculo> rangeValor(double min, double max){
		return veiculoRepository.findByPriceRange(min, max);
	}

}
