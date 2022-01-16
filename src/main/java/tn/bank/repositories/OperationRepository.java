package tn.bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.bank.entities.Operation;
import tn.bank.entities.Versement;

public interface OperationRepository extends JpaRepository<Operation, Long> {

	

}
