package tn.bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.bank.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long> {

}
