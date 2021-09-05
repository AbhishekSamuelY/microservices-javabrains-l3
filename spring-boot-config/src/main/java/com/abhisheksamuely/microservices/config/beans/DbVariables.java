package com.abhisheksamuely.microservices.config.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Configuration
@ConfigurationProperties("db")
public class DbVariables {

	private String connectionstring;
	private String username;
	private String password;
}
