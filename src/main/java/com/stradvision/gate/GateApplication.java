package com.stradvision.gate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GateApplication {

    public static void main(String[] args) {
        SpringApplication.run(GateApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        /**
         * have to Add custom predicator to route with token
         * Document about Spring Could Gateway please check :
         *      https://cloud.spring.io/spring-cloud-gateway/2.1.x/multi/multi_gateway-starter.html
         *
         * to implement circuit breaker check reference :
         *      https://spring.io/guides/gs/gateway/
         */
        return builder.routes()
                .route("path_route", r -> r
                        .path("/**")
                        .filters(f -> f
                                .addRequestHeader("role", "tester_role")
                                .rewritePath("/tester/", "/test/")
                        )
                        .uri("http://10.10.10.180:3031")
                )
                .build();
    }

}
