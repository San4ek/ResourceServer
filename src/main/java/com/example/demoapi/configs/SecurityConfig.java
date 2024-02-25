package com.example.demoapi.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*@Bean
    public UserDetailService userDetailService(UserRepository userRepo) {
        return username -> {
            CustomUser user =userRepo.findByUsername(username);
            if (user!=null) return user;

            throw new UsernameNotFoundException("User '"+username+"' not found");
        };
    }*/

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, JwtRoleConverter jwtRoleConverter) throws Exception {

        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtRoleConverter);

        return http.
                authorizeHttpRequests(authorize -> authorize.
                        requestMatchers(HttpMethod.POST, "api/ingredients").
                        hasRole("ADMIN").
                        requestMatchers(HttpMethod.DELETE, "api/ingredients/**").
                        hasRole("ADMIN").
                        requestMatchers(HttpMethod.GET, "api/ingredients/**").
                        hasRole("ADMIN")).
                oauth2ResourceServer(oauth2 -> oauth2.jwt(jwtConfigurer -> jwtConfigurer.jwtAuthenticationConverter(jwtAuthenticationConverter))).
                build();
    }
}
