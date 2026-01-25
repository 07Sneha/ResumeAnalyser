package com.analyser.resumeanalyzer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AppConfig {

	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	

	    @Bean
	    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory connectionFactory) {
	        RedisTemplate<String, String> template = new RedisTemplate<>();
	        template.setConnectionFactory(connectionFactory);
	        return template;
	    }
	    

	    @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	            .csrf().disable()
	            .authorizeHttpRequests(auth -> auth
	                .anyRequest().permitAll() // allow all requests without auth
	            );
	        return http.build();
	    }
}