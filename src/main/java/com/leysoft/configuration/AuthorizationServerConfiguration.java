
package com.leysoft.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

import com.leysoft.util.Concession;
import com.leysoft.util.Scope;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Value(
            value = "${oaut2.token.access}")
    private int accessTokenValiditySeconds;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory().withClient("clientapp").secret("{noop}123456")
                .redirectUris("http://localhost:9000/callback")
                .authorizedGrantTypes(Concession.AUTHORIZATION_CODE.getValue(),
                        Concession.IMPLICIT.getValue(), Concession.REFRESH_TOKEN.getValue())
                .accessTokenValiditySeconds(accessTokenValiditySeconds)
                .scopes(Scope.READ.getValue());
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);
    }
}
