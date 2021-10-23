package co.usa.recursohumano.recursohumano;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"co.usa.recursohumano.recursohumano.model"})
@SpringBootApplication
public class RecursohumanoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecursohumanoApplication.class, args);
	}

}
