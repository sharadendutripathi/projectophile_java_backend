/**
 * 
 */
package com.project.backend.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.project.backend.security.JwtAuthenticationEntryPoint;
import com.project.backend.security.JwtAuthenticationFilter;

/**
 * @author Sharadendu
 *
 */

@Configuration
public class SecurityConfig {
	
	@Autowired
	private JwtAuthenticationEntryPoint point;
	
	@Autowired
	private JwtAuthenticationFilter filter;
	
	
	
	
	

	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		
		
		http.csrf(csrf-> csrf.disable())
			.cors()
			.and()
			.authorizeHttpRequests(auth-> auth
					.requestMatchers("/signup/**").permitAll()
					.requestMatchers("/student/**").hasRole("STUDENT")
					.requestMatchers("/mentor/**").hasRole("MENTOR")
					.requestMatchers("/admin/**").hasRole("ADMIN")
					.anyRequest().authenticated()					)
			.exceptionHandling(ex-> ex.authenticationEntryPoint(point));
		
			//.sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
			
//        http.formLogin();
		
		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        
        return http.build();
    }
	
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
	    CorsConfiguration configuration = new CorsConfiguration();
	    configuration.setAllowedOrigins(Arrays.asList("*"));
	    configuration.setAllowedMethods(Arrays.asList("*"));
	    configuration.setAllowedHeaders(Arrays.asList("*"));
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", configuration);
	    return source;
	}
	
	

}
