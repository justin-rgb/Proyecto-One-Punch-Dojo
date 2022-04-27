package com.onepunch;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        
        auth.inMemoryAuthentication()
                .withUser("justin")
                .password("{noop}123")
                .roles("ADMIN","VENDEDOR","USER")
        .and()
        .withUser("julian")
                .password("{noop}123")
                .roles("ENTRENADOR","USUARIO")
        .and()
        .withUser("profe")
                .password("{noop}123")
                .roles("USUARIO");
    }
  
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
            .antMatchers("/").hasAnyRole("ENTRENADOR","USUARIO","ADMIN")
            
            .antMatchers("/admin*").access("hasRole('ADMIN')")
                
            .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
            .and()
               .exceptionHandling().accessDeniedPage("/errores/403");
                
    }
}
