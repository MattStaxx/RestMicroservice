package matt.RestMicroservice;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.modelmapper.ModelMapper;

@SpringBootApplication
public class RestMicroserviceApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(RestMicroserviceApplication.class, args);
	}

}
