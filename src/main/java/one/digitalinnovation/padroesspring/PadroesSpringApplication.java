package one.digitalinnovation.padroesspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class PadroesSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(PadroesSpringApplication.class, args);
	}

}
