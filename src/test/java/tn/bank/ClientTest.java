package tn.bank;
import static org.junit.Assert.assertTrue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.bank.entities.Client;
import tn.bank.repositories.ClientRepository;
	@RunWith(SpringRunner.class)
	@SpringBootTest
	public class ClientTest {
		@Autowired
		private ClientRepository cr;
		private static final Logger l = LogManager.getLogger(ClientTest.class);
		@Test
		public void addClientTest() throws Exception {
			Client c1 = cr.save(new Client("mouna", "mouna@gmail.com"))	;	
			Long code = c1.getCode();
		    l.info("Client: "+ c1.getNom()+" with code :" + code + " added successfully");
		    assertTrue("Oops!!" ,cr.findById(code).isPresent());}

	}

