package fr.doranco.ecommerce.metier;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.doranco.ecommerce.entities.pojo.User;

class MarketingMetierTest {

	MarkatingMetier marketingmetier = new MarkatingMetier();
	List<User> users;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		users = new ArrayList<User>();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetUsersByVille() throws Exception {
		assertEquals( users, marketingmetier.getUsersByVille("Paris"));
	}

}
