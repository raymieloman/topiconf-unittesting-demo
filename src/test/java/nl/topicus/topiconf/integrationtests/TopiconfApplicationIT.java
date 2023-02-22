package nl.topicus.topiconf.integrationtests;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("integrationtest")
class TopiconfApplicationIT {

	// This test does nothing, just that the context loads which means
	// that spelling errors in application.properties file(s) are detected
	@Test
	void contextLoads() {
	}
}
