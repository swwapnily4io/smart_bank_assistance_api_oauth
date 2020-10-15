
package com.example.OauthExample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfiguration extends GlobalAuthenticationConfigurerAdapter {

  PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
  
  @Override
  public void init(AuthenticationManagerBuilder auth) throws Exception {
    // TODO Auto-generated method stub
    super.init(auth);
    auth.inMemoryAuthentication().withUser("swwapnil").password(encoder.encode("swwapnilpass")).roles("USER", "ADMIN", "MANAGER")
            .authorities("CAN_READ", "CAN_WRITE", "CAN_DELETE").and().withUser("swwapnilyadav")
            .password(encoder.encode("swwapnilpass1")).roles("USER", "ADMIN")
            .authorities("CAN_READ", "CAN_WRITE");
  }
}
