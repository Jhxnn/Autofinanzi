package Autofinanzi.services;


import Autofinanzi.dtos.EstoqueDto;
import Autofinanzi.models.Estoque;
import Autofinanzi.repositories.EstoqueRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EstoqueService {


    @Autowired
    EstoqueRepository estoqueRepository;

    @Autowired
    VeiculoService veiculoService;

    public Estoque findById(UUID id){
        return estoqueRepository.findById(id).orElseThrow(()-> new RuntimeException("Cannot be found"));
    }

    public List<Estoque> findAll(){
        return estoqueRepository.findAll();
    }

    public  Estoque createEstoque(EstoqueDto estoqueDto){
        var estoque = new Estoque();
        var veiculo = veiculoService.findById(estoqueDto.veiculoId());
        estoque.setVeiculo(veiculo);
        return estoqueRepository.save(estoque);
    }

    public  Estoque updateEstoque(UUID id, EstoqueDto estoqueDto){
        var estoque = findById(id);
        var veiculo = veiculoService.findById(estoqueDto.veiculoId());
        estoque.setVeiculo(veiculo);
        return estoqueRepository.save(estoque);
    }

    public void deleteEstoque(UUID id){
        var estoque = findById(id);
        estoqueRepository.delete(estoque);
    }




}
