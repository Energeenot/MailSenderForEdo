package Energeenot.MailSenderForEdo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class MailSenderForEdoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailSenderForEdoApplication.class, args);
	}

}
