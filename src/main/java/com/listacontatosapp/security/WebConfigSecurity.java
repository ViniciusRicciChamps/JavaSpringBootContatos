package com.listacontatosapp.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class WebConfigSecurity extends WebSecurityConfigurerAdapter {

	@Override //configura as solicitações de acesso por http
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf()
		.disable()// desativa as configurações padrões de memória 
		.authorizeRequests() // permitir restringir acessos
		.antMatchers(HttpMethod.GET, "/").permitAll() //qualquer usuario acessa
		.anyRequest().authenticated()
		.and()
		.formLogin().permitAll()
		.and()
		.logout().logoutRequestMatcher(null)
		
	}
	
}
