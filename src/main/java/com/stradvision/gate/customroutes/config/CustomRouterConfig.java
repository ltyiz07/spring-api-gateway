package com.stradvision.gate.customroutes.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomRouterConfig {

//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder, TokenRoutePredicateFactory tokenRoutePredicateFactory) {
//        /**
//         * have to Add custom predicator to route with token
//         * Document about Spring Could Gateway please check :
//         *      https://cloud.spring.io/spring-cloud-gateway/2.1.x/multi/multi_gateway-starter.html
//         *
//         * to implement circuit breaker check reference :
//         *      https://spring.io/guides/gs/gateway/
//         */
//        System.out.println("this is it!");
//        ArrayList<String> services = new ArrayList<String>(Arrays.asList("this", "is", "test"));
//        LoginInfo info = new LoginInfo("this", "is", services);
//        this.loginInfoRepository.save(info);

//        return builder.routes()
//                .route("cookie_route", r -> r
//                        .path("/test/**")
//                        .filters(f -> f
//                                .addRequestHeader("role", "tester_role")
//                                .rewritePath("/tester/", "/test/")
//                        )
//                        .uri("http://10.10.10.180:3031")
//                )
//                .build();
//    }

}
