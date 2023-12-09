package tn.esprit.api_gateway_server;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringClassConfig {
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()

                //Reclamation
                .route(r -> r.path("/Relamation/**").uri("http://Reclamation:8082/"))

                //Review
                .route(r -> r.path("/Review/**").uri("http://Review:8084/"))

                //Category
                .route(r -> r.path("/Category/**").uri("http://Category:8085/"))

                //Service
                .route(r -> r.path("/Service/**").uri("http://Service:8083/"))

                //Commande
                .route(r -> r.path("/Commande_micro/**").uri("http://Commande:8088/"))

                //Subscription
                .route(r -> r.path("/MicroSubscription/**").uri("http://Subscription:8086/"))

                .build();
    }

}
