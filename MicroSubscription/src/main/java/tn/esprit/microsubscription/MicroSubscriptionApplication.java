package tn.esprit.microsubscription;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroSubscriptionApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroSubscriptionApplication.class, args);
    }

}
