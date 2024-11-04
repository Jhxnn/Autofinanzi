package Autofinanzi.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Autofinanzi.models.Veiculo;
import Autofinanzi.models.enums.StatusVeiculo;


public interface VeiculoRepository extends JpaRepository<Veiculo, UUID>{
	
    @Query("SELECT v FROM Veiculo v ORDER BY v.valor DESC")
    List<Veiculo> findAllVeiculosMaiorValor();
    
	List<Veiculo> findByStatusVeiculo(StatusVeiculo statusVeiculo);
	
    @Query("SELECT v FROM Veiculo v ORDER BY v.valor ASC")
	List<Veiculo> findAllVeiculosMenorValor();
    
    @Query("SELECT v FROM Veiculo v WHERE v.valor BETWEEN :min AND :max")
    List<Veiculo> findByPriceRange(@Param("min") double min, @Param("max") double max);

} 
