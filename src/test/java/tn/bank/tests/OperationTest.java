package tn.bank.tests;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.bank.entities.Client;
import tn.bank.entities.Compte;
import tn.bank.entities.CompteCourant;
import tn.bank.entities.CompteEpargne;
import tn.bank.entities.Operation;
import tn.bank.entities.Retrait;
import tn.bank.entities.Versement;
import tn.bank.repositories.ClientRepository;
import tn.bank.repositories.CompteRepository;
import tn.bank.repositories.OperationRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OperationTest {
	@Autowired
	CompteRepository cpr ;
	@Autowired
	ClientRepository clr;
	@Autowired
	OperationRepository opr;
	private static final Logger L = LogManager.getLogger(OperationTest.class);
	
	@Test
	public void OperationCompteCourantTest(){
	Client c2 = clr.save(new Client("Courant", "Courant@gmail.com"));
	Long CodeClientCourant = c2.getCode();
    L.info("Client: "+ c2.getNom()+" with code :" + CodeClientCourant + " added successfully");
    assertTrue("Oops!!" ,clr.findById(CodeClientCourant).isPresent());
	Compte cp1 = cpr.save(new CompteCourant(null,new Date(), 10000, c2, 600));
	Long CodeCompteCourant = cp1.getCodeCompte();
	L.info("Your account of type CompteCourant and with code : " +CodeCompteCourant + " is created successfully for the client "+c2.getNom()+" with code: " +CodeClientCourant);
	assertTrue("there is wrong in the creation process",cpr.findById(CodeCompteCourant).isPresent());
    Operation op1 = opr.save(new Versement(new Date(), 5000 , cp1));
    Operation op2 = opr.save(new Versement(new Date(), 1000 , cp1));
    Operation op3 = opr.save(new Versement(new Date(), 9000 , cp1));
    Operation op4 = opr.save(new Retrait(new Date(), 2000 , cp1));
    Operation op5 = opr.save(new Retrait(new Date(), 3000 , cp1));
	}
	
	@Test
	public void OperationCompteEpargneTest()
	{
		Client c3 = clr.save(new Client("Epargne", "Epargne@gmail.com"));
		Long CodeClientEpargne = c3.getCode();
	    L.info("Client: "+ c3.getNom()+" with code :" + CodeClientEpargne + " added successfully");
	    assertTrue("Oops!!" ,clr.findById(CodeClientEpargne).isPresent());
		Compte cp2 = cpr.save(new CompteEpargne(null,new Date(), 10000, c3, 5.5));
		Long CodeCompteEpargne = cp2.getCodeCompte();
		L.info("Your account of type CompteEpargne and with code : " +CodeCompteEpargne + " is created successfully for the client "+c3.getNom()+" with code: " +CodeClientEpargne);
		assertTrue("there is wrong in the creation process",cpr.findById(CodeCompteEpargne).isPresent());	
	    Operation op1 = opr.save(new Versement(new Date(), 5000 , cp2));
        Operation op2 = opr.save(new Versement(new Date(), 1000 , cp2));
        Operation op3 = opr.save(new Versement(new Date(), 9000 , cp2));
        Operation op4 = opr.save(new Retrait(new Date(), 2000 , cp2));
        Operation op5 = opr.save(new Retrait(new Date(), 3000 , cp2));
	}

}
