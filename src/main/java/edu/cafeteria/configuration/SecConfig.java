package edu.cafeteria.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import edu.cafeteria.Controllers.homeController;
<<<<<<< HEAD


@Configuration
@EnableWebSecurity
public class SecConfig {
    @Autowired
    homeController homController;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf().disable();

        http.oauth2Login()
                .loginPage("/auth/login").successHandler((request, response, authentication) -> {
                    homController.google = true;
                    response.sendRedirect("/HomeGuest");
                }).failureHandler((request, response, exception) -> {
                    homController.google = true;
                    response.sendRedirect("/HomeGuest");
                });

        return http
                .authorizeHttpRequests(auth -> {

                    auth.anyRequest().permitAll();
                })
                .build();
    }

=======
 

@Configuration
@EnableWebSecurity
public class SecConfig  


{
	@Autowired
homeController homController;
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		http.oauth2Login()
        .loginPage("/auth/login").successHandler((request, response, authentication) -> {
        	homController.google=true;
          response.sendRedirect("/HomeGuest");     })        .failureHandler((request, response, exception)                                              -> {                                                                                            	homController.google=true;                                 response.sendRedirect("/HomeGuest"); });
		
		return  http
				.authorizeHttpRequests(auth  -> {
 
				 	auth.anyRequest().permitAll();
				})
				.build();
	}
	
	
	 
	
>>>>>>> f4810c9af638d9b83a4a8f8b5e337c7a0132c43b

}