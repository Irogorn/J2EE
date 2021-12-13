package fr.doranco.ecommerce.model.dao;

//import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.doranco.ecommerce.entities.pojo.User;
import fr.doranco.ecommerce.model.dao.impl.MarketingDao;
import fr.doranco.ecommerce.model.dao.interfaces.IMarketingDao;

class MarketingDaoTest {
	IMarketingDao marketingdao = new MarketingDao();
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
	//	assertEquals( users, marketingdao.getUsersByVille("Paris"));
	}

}
