package Autofinanzi.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import Autofinanzi.models.Venda;

public interface VendaRepository extends JpaRepository<Venda, UUID>{

}
