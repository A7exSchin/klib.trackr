package klib.trackr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class GetRest {

	private static final Logger log = LoggerFactory.getLogger(GetRest.class);

	public static void main(String args[]) {
		SpringApplication.run(GetRest.class);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Response response = restTemplate.getForObject(
					"https://route.api.here.com/routing/7.2/calculateroute.json?app_id=xjipTEag66SG6fNwgEQm&app_code=0eiHle7fs2IZsXChP2sWKQ&waypoint0=geo!52.5,13.4&waypoint1=geo!52.5,13.45&mode=fastest;car;traffic:disabled", Response.class);
			log.info(response.toString());
		};
	}
}
/*
https://gturnquist-quoters.cfapps.io/api/random
https://route.api.here.com/routing/7.2/calculateroute.json?app_id=xjipTEag66SG6fNwgEQm&app_code=0eiHle7fs2IZsXChP2sWKQ&waypoint0=geo!52.5,13.4&waypoint1=geo!52.5,13.45&mode=fastest;car;traffic:disabled
*/