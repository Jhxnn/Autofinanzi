package Autofinanzi.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import Autofinanzi.models.Financiamento;

public interface FinanciamentoRepository extends JpaRepository<Financiamento, UUID>{

}
