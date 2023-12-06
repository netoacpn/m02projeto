package tech.devinhouse.devinpharmacy;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DevinpharmacyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevinpharmacyApplication.class, args);
	}

	@Bean
	public ModelMapper obterModelMapper() {
		return new ModelMapper();
	}

}
