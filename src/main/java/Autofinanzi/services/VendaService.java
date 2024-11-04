package Autofinanzi.services;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Autofinanzi.dtos.VendaDto;
import Autofinanzi.models.Venda;
import Autofinanzi.models.enums.StatusVeiculo;
import Autofinanzi.models.enums.StatusVenda;
import Autofinanzi.repositories.VendaRepository;
@Service
public class VendaService {
	
	@Autowired
	VendaRepository vendaRepository;
	
	@Autowired
	ClienteService clienteService;
	
	@Autowired
	VeiculoService veiculoService;
	
	@Autowired
	FinanciamentoService finService;
	
	
	
	public Venda createVenda(VendaDto vendaDto) {
		
		Venda venda = new Venda();
		var veiculo = veiculoService.findById(vendaDto.idVeiculo());
		if(veiculo.getStatusVeiculo() == StatusVeiculo.VENDIDO) {
			   throw new IllegalStateException("O veículo já foi vendido e não pode ser processado.");
		}
		if(veiculo.getStatusVeiculo() == StatusVeiculo.RESERVADO) {
			throw new IllegalStateException("Veiculo já esta reservado");
		}
		
		veiculo.setStatusVeiculo(StatusVeiculo.VENDIDO);
		venda.setCliente(clienteService.findById(vendaDto.idCliente()));
		venda.setVeiculo(veiculo);
		venda.setFinanciamento(finService.findByID(vendaDto.idFinanciamento()));
		venda.setData(vendaDto.data());
		venda.setStatusVenda(vendaDto.statusVenda());
		
		return vendaRepository.save(venda);
		
	}
	public List<Venda> allVendas(){
		return vendaRepository.findAll();
	}
	public void deleteVenda(UUID id) {
		var venda = findByid(id);
		vendaRepository.delete(venda);
	}
	public Venda findByid(UUID id) {
		return vendaRepository.findById(id).orElseThrow(()-> new RuntimeException("Venda não encontrada"));
	}
	public List<Venda> maioresVendas(){
		return vendaRepository.findMaioresVendas();
	}
	public List<Venda> menoresVendas(){
		return vendaRepository.findMenoresVendas();
	}
	public Venda updateVenda(UUID id, VendaDto vendaDto) {
		
		Venda venda = findByid(id);
		
		if(vendaDto.statusVenda() != null) {
			venda.setStatusVenda(vendaDto.statusVenda());
		}
		if(vendaDto.idCliente() != null) {
			venda.setCliente(clienteService.findById(vendaDto.idCliente()));
		}
		if(vendaDto.idVeiculo() != null) {
			venda.setVeiculo(veiculoService.findById(vendaDto.idVeiculo()));
			
		}
		if(vendaDto.idFinanciamento() != null) {
			venda.setFinanciamento(finService.findByID(vendaDto.idFinanciamento()));
		}
		if(vendaDto.data() != null) {
			venda.setData(vendaDto.data());
		}
		
		return vendaRepository.save(venda);
	}
	
	public Venda finalizarVenda(UUID id) {
	    Venda venda = findByid(id);
	    venda.setStatusVenda(StatusVenda.CONCLUIDA);
	    return vendaRepository.save(venda);
	}
	public List<Venda> vendaData(LocalDate startDate, LocalDate endDate){
		return vendaRepository.findByDateRange(startDate, endDate);
		
	}
}
