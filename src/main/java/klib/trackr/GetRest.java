package klib.trackr;

import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import java.util.LinkedHashMap;
import java.util.Map;

@SpringBootApplication
public class GetRest {

	private static final Logger log = LoggerFactory.getLogger(GetRest.class);

	public static String start;
	public static String end;

	public static void main(String args[]) {
		Map<String, String> arguments = new LinkedHashMap<String, String>();
		for (int i = 0; i < args.length; i++) {
			String key = args[i].split("=")[0];
			String value = args[i].split("=")[1];
			arguments.put(key, value);
		}
		start = arguments.get("start");
		System.out.format("start coordinates: %s\n", start);
		end = arguments.get("end");
		System.out.format("end coordinates  : %s\n", end);

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
					"https://route.api.here.com/routing/7.2/calculateroute.json?app_id=xjipTEag66SG6fNwgEQm&app_code=0eiHle7fs2IZsXChP2sWKQ&waypoint0=geo!"
							+ start + "&waypoint1=geo!" + end + "&mode=fastest;car;traffic:disabled",
					Response.class);
			response.getResponse().getRoute().get(0).getLeg().get(0).getManeuver().forEach(u -> log.info(u.toString()));
		};
	}
}