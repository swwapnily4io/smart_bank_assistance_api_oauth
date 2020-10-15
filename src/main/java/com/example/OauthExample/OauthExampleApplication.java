package com.example.OauthExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableAuthorizationServer
public class OauthExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthExampleApplication.class, args);
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    String password = "swwapnilyadav";
    String encodedPassword = passwordEncoder.encode(password);
    System.out.println();
    System.out.println("Password is         : " + password);
    System.out.println("Encoded Password is : " + encodedPassword);
    
    boolean isPasswordMatch = passwordEncoder.matches(password, encodedPassword);
    System.out.println("Password : " + password + "   isPasswordMatch    : " + isPasswordMatch);

    password = "yawin";
    isPasswordMatch = passwordEncoder.matches(password, encodedPassword);
    System.out.println("Password : " + password + "           isPasswordMatch    : " + isPasswordMatch);
  }
}
