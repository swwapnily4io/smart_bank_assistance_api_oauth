
package com.example.OauthExample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

  @Override
  public void configure(ResourceServerSecurityConfigurer resources) {
    resources.resourceId("api");
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {
    http
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .antMatcher("/api/**")
            .authorizeRequests()
            .antMatchers("/api/getAccounts**").permitAll()
            .antMatchers("/api/getAccounts/**").permitAll()
            .antMatchers("/api/getTransactionHistory/**").permitAll()
            .antMatchers("/api/login/**").permitAll()
            .antMatchers("/api/**").authenticated()
            .anyRequest().authenticated();
  }

}
