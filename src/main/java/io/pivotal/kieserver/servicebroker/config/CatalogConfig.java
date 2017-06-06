package io.pivotal.kieserver.servicebroker.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.cloud.servicebroker.model.Catalog;
import org.springframework.cloud.servicebroker.model.Plan;
import org.springframework.cloud.servicebroker.model.ServiceDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CatalogConfig {

	@Bean
	public Catalog catalog() {
		return new Catalog(Collections.singletonList(new ServiceDefinition("kie-server-service-broker", "kieserver",
				"KIE Execution Server as a Service", true, false,
				Collections.singletonList(new Plan("kieserver-plan", "default",
						"This is a default kie execution server plan.  All services are created equally.",
						getPlanMetadata())),
				Arrays.asList("kieserver", "document"), getServiceDefinitionMetadata(), null, null)));
	}

	private Map<String, Object> getServiceDefinitionMetadata() {
		Map<String, Object> sdMetadata = new HashMap<>();
		sdMetadata.put("displayName", "KIE Execution Server");
		sdMetadata.put("imageUrl", "http://workshop-content.cfapps.io/static/resources/images/jBPM_icon.png");
		sdMetadata.put("longDescription", "KIE Execution Server");
		sdMetadata.put("providerDisplayName", "Pivotal");
		sdMetadata.put("documentationUrl", "https://github.com/decelc-pivotal/kie-execution-server");
		sdMetadata.put("supportUrl", "https://github.com/decelc-pivotal/kie-execution-server");
		return sdMetadata;
	}

	private Map<String, Object> getPlanMetadata() {
		Map<String, Object> planMetadata = new HashMap<>();
		planMetadata.put("costs", getCosts());
		planMetadata.put("bullets", getBullets());
		return planMetadata;
	}

	private List<Map<String, Object>> getCosts() {
		Map<String, Object> costsMap = new HashMap<>();

		Map<String, Object> amount = new HashMap<>();
		amount.put("usd", 0.0);

		costsMap.put("amount", amount);
		costsMap.put("unit", "MONTHLY");

		return Collections.singletonList(costsMap);
	}

	private List<String> getBullets() {
		return Arrays.asList("Bullet 1", "Bullet 2", "Bullet 3");
	}

}
