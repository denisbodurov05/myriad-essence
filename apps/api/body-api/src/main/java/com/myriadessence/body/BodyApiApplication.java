package com.myriadessence.body;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BodyApiApplication {

	public static void main(String[] args) {

		Dotenv.configure()
			.directory("../../../")
			.ignoreIfMissing()
			.filename(".env")
			.systemProperties()
			.load();

		SpringApplication.run(BodyApiApplication.class, args);
	}

}
