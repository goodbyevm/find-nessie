package pj.nessie.integration;


import com.jayway.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pj.nessie.Application;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:8082")
public class TestNessieSimulation {

	private static final String BASE_PATH = "/api/v1/nessie/find";
	private static final int LAKE_NBR_ONE = 1;
	private static final boolean CHANGE_LAKE = true;
	private static final int NBR_OF_CALLS = 1000;
	private double MIN_FACTOR = 0.9;
	private double MAX_FACTOR= 1.1;

	@Value("${local.server.port}")
	int port;

	@Before
	public void setUp() {
		RestAssured.port = port;
	}

	/**
	 * This test is based on the statement that the change lake route will succeed 2/3 of the times with a certain significance.
	 */
	@Test
	public void testChangeLakeProbability() {
		int foundNessieCount = 0;
		boolean l_foundNessie;
		for (int i = 0; i < NBR_OF_CALLS; i++) {
			l_foundNessie = callFindNessieRestMethod();
			if (l_foundNessie) {
				foundNessieCount++;
			}
		}
		double expectedFinds = (double)NBR_OF_CALLS * 2/3;
		double minFindings =  expectedFinds * MIN_FACTOR;
		double maxFindings = expectedFinds * MAX_FACTOR;
		assertTrue(foundNessieCount>minFindings);
		assertTrue(foundNessieCount<maxFindings);
	}

	/**
	 * Help method to construct a rest call to trigger a simulation.
	 */
	private boolean callFindNessieRestMethod() {
		return given().
				contentType("application/json").
				when().
				param("StartLake", LAKE_NBR_ONE).
				param("ChangeLake", CHANGE_LAKE).
				get(BASE_PATH).
				then().
				statusCode(200).
				extract().body().jsonPath().getBoolean("foundNessie");
	}


}
