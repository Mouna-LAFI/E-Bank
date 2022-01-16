package tn.bank.tests;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.bank.entities.Client;
import tn.bank.entities.Compte;
import tn.bank.entities.CompteCourant;
import tn.bank.entities.CompteEpargne;
import tn.bank.repositories.ClientRepository;
import tn.bank.repositories.CompteRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompteTest {
	@Autowired
	CompteRepository cpr ;
	@Autowired
	ClientRepository cr;
	private static final Logger L = LogManager.getLogger(CompteTest.class);
	@Test
	public void addCompteCourant(){
	Client c2 = cr.save(new Client("Courant", "Courant@gmail.com"));
	Long CodeClientCourant = c2.getCode();
    L.info("Client: "+ c2.getNom()+" with code :" + CodeClientCourant + " added successfully");
    assertTrue("Oops!!" ,cr.findById(CodeClientCourant).isPresent());
	Compte cp1 = cpr.save(new CompteCourant(null,new Date(), 10000, c2, 600));
	Long CodeCompteCourant = cp1.getCodeCompte();
	L.info("Your account of type CompteCourant and with code : " +CodeCompteCourant + " is created successfully for the client "+c2.getNom()+" with code: " +CodeClientCourant);
	assertTrue("there is wrong in the creation process",cpr.findById(CodeCompteCourant).isPresent());
	}
	
	@Test
	public void addCompteEpargne(){
	Client c3 = cr.save(new Client("Epargne", "Epargne@gmail.com"));
	Long CodeClientEpargne = c3.getCode();
    L.info("Client: "+ c3.getNom()+" with code :" + CodeClientEpargne + " added successfully");
    assertTrue("Oops!!" ,cr.findById(CodeClientEpargne).isPresent());
	Compte cp2 = cpr.save(new CompteEpargne(null,new Date(), 10000, c3, 5.5));
	Long CodeCompteEpargne = cp2.getCodeCompte();
	L.info("Your account of type CompteEpargne and with code : " +CodeCompteEpargne + " is created successfully for the client "+c3.getNom()+" with code: " +CodeClientEpargne);
	assertTrue("there is wrong in the creation process",cpr.findById(CodeCompteEpargne).isPresent());
	}


}
