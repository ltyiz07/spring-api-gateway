package com.stradvision.gate.custompredicates.config;

import com.stradvision.gate.custompredicates.factories.TokenRoutePredicateFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomPredicatesConfig {

    @Bean
    public TokenRoutePredicateFactory getTokenRoutePredicateFactory() {
        return new TokenRoutePredicateFactory();
    }

}
