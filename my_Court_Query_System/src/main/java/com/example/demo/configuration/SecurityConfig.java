//package com.example.demo.configuration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.security.reactive.PathRequest;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//	 @Bean
//	    public PasswordEncoder passwobrdEncoder(){
//	        return new BCryptPasswordEncoder();
//	    }
//
//	 @Bean
//	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//	        http.csrf().disable()
//            //不通过Session获取SecurityContext
//            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//            .and()
////            .formLogin(login -> login
//////            		处理登录请求的url
////	                .loginProcessingUrl("/api/user/login")
////	                .loginPage("/api/adminLogin")
////	                .defaultSuccessUrl("/")
////	                .permitAll())
//            .authorizeHttpRequests(authz -> authz
//	                .requestMatchers("/api/infoPage").permitAll()
//	                .anyRequest().authenticated()
//	        );
//	        http.cors();
//	        return http.build();
//	    }
//	 @Autowired
//	    private AuthenticationConfiguration authenticationConfiguration;
//
//	    @Bean
//	    public AuthenticationManager authenticationManager() throws Exception{
//	        AuthenticationManager authenticationManager = authenticationConfiguration.getAuthenticationManager();
//	        return authenticationManager;
//}
//}
