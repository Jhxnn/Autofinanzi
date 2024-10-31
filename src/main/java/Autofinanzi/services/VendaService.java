package Autofinanzi.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Autofinanzi.dtos.VendaDto;
import Autofinanzi.models.Venda;
import Autofinanzi.repositories.VendaRepository;

@Service
public class VendaService {

	
	@Autowired
	VendaRepository vendaRepository;
	
	
	
	public Venda createVenda(VendaDto vendaDto) {
		
		Venda venda = new Venda();
		BeanUtils.copyProperties(vendaDto, venda);
		return vendaRepository.save(venda);
		
	}
	public List<Venda> allVendas(){
		return vendaRepository.findAll();
	}
}
