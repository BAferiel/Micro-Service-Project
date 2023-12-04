package tn.esprit.microservices.commande_micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CommandeMicroApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommandeMicroApplication.class, args);
    }

}
