
package com.example.OauthExample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class OAuthServerConfiguration extends WebSecurityConfigurerAdapter implements AuthorizationServerConfigurer {

  PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

  @Bean
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManager();
  }

  @Autowired
  AuthenticationManager authenticationManager;

  public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
    // TODO Auto-generated method stub
    security.checkTokenAccess("permitAll");
  }

  public void configure(ClientDetailsServiceConfigurer client) throws Exception {
    // TODO Auto-generated method stub
    client.inMemory().withClient("web").secret(encoder.encode("webpass")).scopes("READ", "WRITE")
            .authorizedGrantTypes("password", "authorization_code").resourceIds("api").authorities("ADMIN", "USER")
            .accessTokenValiditySeconds(60);

  }

  public void configure(AuthorizationServerEndpointsConfigurer endpoint) throws Exception {
    // TODO Auto-generated method stub
    endpoint.authenticationManager(authenticationManager);
  }

  @Bean
  public JwtAccessTokenConverter defaultAccessTokenConverter() {
    JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
    // converter.setSigningKey("123");
    return converter;
  }

}
