package com.abc.demo.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class DemoWebSecurityConfig {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		
        .anyRequest()
        .hasRole("ADMIN")
//        .authenticated()
        .and()
        .httpBasic()
        .and()
        .formLogin()
        .loginPage("/login.html")//登入頁面設定
        .loginProcessingUrl("/loginAction")
        .usernameParameter("username")
        .passwordParameter("password")
        .defaultSuccessUrl("/index.html")
        .permitAll()//不攔截
        .and().logout().permitAll()
        .logoutSuccessUrl("/login.html")
        .and()
        .csrf()
        .ignoringRequestMatchers("/login").disable();
//        .defaultSuccessUrl("/index")
////        .successForwardUrl("/index")
//        .failureForwardUrl("/loginFail")
//        .failureUrl("/login.html")
        
//        .loginProcessingUrl("/login") //Postman設定27~34
//        .usernameParameter("username")
//        .passwordParameter("password")
//        .successHandler( new DemoAuthenticationSuccessHandler() )
//        .failureHandler( new DemoAuthenticationFailureHandler() )
//        .and()
//        .exceptionHandling()
//        .authenticationEntryPoint(new DemoAuthenticationEntryPoint())
        
//        .ignoringRequestMatchers("/login");

		 return http.build();
		
	}
	
	@Bean
    public UserDetailsService userDetailsService() {
        
        UserBuilder users = User.withDefaultPasswordEncoder();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(users.username("user123")
                                .password("user123")
                                .roles("USER").build());
        
        manager.createUser(users.username("admin123")
                                .password("admin123")
                                .roles("USER", "ADMIN")
                                .build());
        
        return manager;
    }
	
}
