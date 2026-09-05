package pl.mikolaj.springdemoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringdemoappApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringdemoappApplication.class, args);


		Dev dev = context.getBean(Dev.class);
		dev.build();
	}

}
