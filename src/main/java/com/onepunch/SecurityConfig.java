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
                .roles("ADMIN","ENTRENADOR","USUARIO")
        .and()
        .withUser("julian")
                .password("{noop}123")
                .roles("ADMIN","ENTRENADOR","USUARIO")
        .and()
        .withUser("profe")
                .password("{noop}123")
                .roles("ENTRENADOR","USUARIO")
        .and()
        .withUser("usuario")
                .password("{noop}123")
                .roles("USUARIO");
    }
  
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                
            .antMatchers("/clientes/modificar/**","/clientes/eliminar/**",
                        "/colaboradores/modificar/**","/colaboradores/eliminar/**",
                        "/compras/modificar/**","/compras/eliminar/**",
                        "/facturas/modificar/**","/facturas/eliminar/**",
                        "/eventos/modificar/**","/eventos/eliminar/**",
                        "/proveedores/modificar/**","/proveedores/eliminar/**",
                        "/trofeos/modificar/**","/trofeos/eliminar/**",
                        "/inventario/modificar/**","/inventario/eliminar/**"
                    ).hasRole("ADMIN")
  
            .antMatchers("/clientes/nuevo","/clientes/guardar",
                        "/colaboradores/nuevo","/colaboradores/guardar",
                        "/compras/nuevo","/compras/guardar",
                        "/facturas/nuevo","/facturas/guardar",
                        "/eventos/nuevo","/eventos/guardar",
                        "/proveedores/nuevo","/proveedores/guardar",
                        "/trofeos/nuevo","/trofeos/guardar",
                        "/inventario/nuevo","/inventario/guardar"
                    ).hasAnyRole("ADMIN","ENTRENADOR")
                
                
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
