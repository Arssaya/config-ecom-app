package net.aya.customerservice;

import net.aya.customerservice.config.CustomerConfigParams;
import net.aya.customerservice.entities.Customer;
import net.aya.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@EnableConfigurationProperties(CustomerConfigParams.class)
@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
		return args -> {
			customerRepository.save(Customer.builder()
							.name("Aya").email("aya@gmail.com")
					.build());
			customerRepository.save(Customer.builder()
					.name("Imane").email("imane@gmail.com")
					.build());
			customerRepository.save(Customer.builder()
					.name("Yassine").email("yassine@gmail.com")
					.build());
			customerRepository.findAll().forEach(c->{
				System.out.println("====================");
				System.out.println(c.getId());
				System.out.println(c.getName());
				System.out.println(c.getEmail());
				System.out.println("====================");
			});

		};
	}

}
