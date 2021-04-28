package matt.restmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;

import org.modelmapper.ModelMapper;

@SpringBootApplication
public class RestmicroserviceApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(RestmicroserviceApplication.class, args);
	}

}
