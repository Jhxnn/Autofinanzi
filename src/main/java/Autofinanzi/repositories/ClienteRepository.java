package Autofinanzi.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import Autofinanzi.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, UUID> {

}
