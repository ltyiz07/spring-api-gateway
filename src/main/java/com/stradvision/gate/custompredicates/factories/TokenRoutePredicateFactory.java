package com.stradvision.gate.custompredicates.factories;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.http.HttpCookie;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.function.Predicate;

public class TokenRoutePredicateFactory extends AbstractRoutePredicateFactory<TokenRoutePredicateFactory.Config> {

    public TokenRoutePredicateFactory() {
        super(Config.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {

        return (ServerWebExchange t) -> {

            List<HttpCookie> cookies = t.getRequest()
                    .getCookies()
                    .get(config.getTokenName());

            boolean isAuthorized;
            if ( cookies == null || cookies.isEmpty()) {
                isAuthorized = false;
            }
            else {
                String cookieValue = cookies.get(0).getValue();
                isAuthorized = cookieValue.equals("this_is_it");
            }

            // TODO: delete print
            System.out.println(t.getRequest().getPath());
            System.out.print("isAuthorized: ");
            System.out.println(isAuthorized);

            return isAuthorized == config.isAuthorized;
        };

    }


    @Validated
    public static class Config {
        private boolean isAuthorized = true;

        @NotEmpty
        private String tokenName = "AuthToken";


        public Config() {}

        public Config(boolean isAuthorized) {
            this.isAuthorized = isAuthorized;
        }

        public Config( boolean isAuthorized, String tokenName) {
            this.isAuthorized = isAuthorized;
            this.tokenName = tokenName;
        }

        public boolean getIsAuthorized() {
            return this.isAuthorized;
        }

        public void setIsAuthorized(boolean value) {
            this.isAuthorized = value;
        }

        /**
         * @return the customerIdCookie
         */
        public String getTokenName() {
            return tokenName;
        }

        /**
         * @param customerIdCookie the customerIdCookie to set
         */
        public void setTokenName(String tokenName) {
            this.tokenName = tokenName;
        }



    }
}
