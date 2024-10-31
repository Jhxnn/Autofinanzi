package Autofinanzi.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Autofinanzi.models.Venda;

public interface VendaRepository extends JpaRepository<Venda, UUID>{
	
    @Query("SELECT v FROM Venda v JOIN v.veiculo veiculo ORDER BY veiculo.valor DESC")
		List<Venda> findMaioresVendas ();
    

    @Query("SELECT v FROM Venda v JOIN v.veiculo veiculo ORDER BY veiculo.valor ASC")
		List<Venda> findMenoresVendas();
    
    @Query("SELECT v FROM Venda v WHERE v.dataVenda BETWEEN :startDate AND :endDate")
    List<Venda> findByDateRange(@Param("startDate") LocalDate startDate, 
                                 @Param("endDate") LocalDate endDate);
}
