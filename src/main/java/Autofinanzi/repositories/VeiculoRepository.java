package Autofinanzi.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import Autofinanzi.models.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, UUID>{

}
