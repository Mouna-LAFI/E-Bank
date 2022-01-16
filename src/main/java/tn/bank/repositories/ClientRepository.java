package tn.bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.bank.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
