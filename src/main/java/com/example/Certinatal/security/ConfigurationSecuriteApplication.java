package com.example.Certinatal.security;

import static org.springframework.http.HttpMethod.*;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import jakarta.servlet.http.HttpServletRequest;

// import com.midikizi.CertiNatal.services.Impl.UserServiceImpl;

@Configuration
@EnableWebSecurity
public class ConfigurationSecuriteApplication {

        private final BCryptPasswordEncoder bCryptPasswordEncoder;
        private final JwtFilter jwtFilter;
        public ConfigurationSecuriteApplication(JwtFilter jwtFilter,BCryptPasswordEncoder bCryptPasswordEncoder) {
                this.bCryptPasswordEncoder = bCryptPasswordEncoder;
                this.jwtFilter = jwtFilter;
                // this.userDetailsService = userDetailsService;
        }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return
                httpSecurity
                        .cors(corsCustomizer->corsCustomizer.configurationSource((CorsConfigurationSource) new CorsConfigurationSource() {
                        @SuppressWarnings("null")
                        @Override
                        public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                                CorsConfiguration corsConfiguration=new CorsConfiguration();
                                corsConfiguration.setAllowCredentials(true);// allows taking authentication with credentials
                                corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
                                // providing the allowed origin details, can provide multiple origins here, 7070 is the port number of client application here
                                corsConfiguration.setAllowedMethods(Collections.singletonList("*"));// allowing all HTTP methods GET,POST,PUT etc, can configure on your need
                                corsConfiguration.setAllowedHeaders(Collections.singletonList("*"));// allowing all the request headers, can configure according to your need, which headers to allow
                                corsConfiguration.setMaxAge(Duration.ofMinutes(5L)); // setting the max time till which the allowed origin will not make a pre-flight request again to check if the CORS is allowed on not
                                return corsConfiguration;
                        }
                        }))
                        .csrf(AbstractHttpConfigurer::disable)
                        .authorizeHttpRequests(
                                authorize ->
                                        authorize
                                                .requestMatchers(GET, "/swagger-ui/**", "/v3/api-docs/**", "/swagger-resources/**", "/webjars/**").permitAll()
                                                .requestMatchers(POST,"/api/inscription").permitAll()
                                                .requestMatchers(POST,"/api/activation").permitAll()
                                                .requestMatchers(POST,"/api/connexion").permitAll()
                                                .anyRequest().authenticated()
                        )
                        .sessionManagement(httpSecuritySessionManagementConfigurer ->
                                httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                                )
                        .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                        .build();
                        
    }

    

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }


     @Bean
    public AuthenticationProvider authenticationProvider (UserDetailsService userDetailsService) {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder);
        return daoAuthenticationProvider;
    }
}
