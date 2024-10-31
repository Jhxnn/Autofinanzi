package Autofinanzi.services;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Autofinanzi.dtos.FinanciamentoDto;
import Autofinanzi.models.Financiamento;
import Autofinanzi.repositories.ClienteRepository;
import Autofinanzi.repositories.FinanciamentoRepository;
import Autofinanzi.repositories.VeiculoRepository;

@Service
public class FinanciamentoService {

	
	@Autowired
	FinanciamentoRepository financiamentoRepository;
	
	@Autowired
	ClienteService clienteService;
	
	@Autowired
	VeiculoService veiculoService;
	
	public Financiamento createFin(FinanciamentoDto finDto) {
		
		var fin = new Financiamento();
		BeanUtils.copyProperties(finDto, fin);
		
		return financiamentoRepository.save(fin);
	}
	
	public Financiamento findByID(UUID id) {
		
		return financiamentoRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Id de financiamento incorreto"));
	
	}
	
	public double calculoFin(UUID veiculoId, double taxa, int qntdParcelas, boolean simulacao) {
		var veiculo = veiculoService.findById(veiculoId);
		double pv = veiculo.getValor();
		double pmt = (pv * taxa) / 1 - Math.pow(1 + taxa, -qntdParcelas);
		
		if(simulacao == false) {
			Financiamento financiamento = new Financiamento(pv, qntdParcelas, taxa, pmt);
			financiamentoRepository.save(financiamento);
			return pmt;

		}
		return pmt;
		
	}
	public Financiamento pagarParcela(UUID idFin, int qntParcelasPagas) {
		
		Financiamento financiamento = financiamentoRepository.findById(idFin)
				.orElseThrow(()-> new RuntimeException("Id de financiamento incorreto"));
		
		financiamento.setNumeroParcelas(financiamento.getNumeroParcelas() - qntParcelasPagas);
		financiamento.setValorTotal(financiamento.getValorTotal() - qntParcelasPagas * financiamento.getValorParcela());
		return financiamentoRepository.save(financiamento);
	}
	
	
}
