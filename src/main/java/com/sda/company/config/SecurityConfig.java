package com.sda.company.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static final String ROLE_USER = "USER";
    private static final String ROLE_ADMIN = "ADMIN";
    private static final String ROLE_POWER_USER = "POWER_USER";

    @Bean
    @Primary
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(BCryptPasswordEncoder bCryptPasswordEncoder) {
        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
        inMemoryUserDetailsManager.createUser(User.withUsername("user")
                .password(bCryptPasswordEncoder.encode("1234"))
                .roles(ROLE_USER)
                .build());

        inMemoryUserDetailsManager.createUser(User.withUsername("admin")
                .password(bCryptPasswordEncoder.encode("1234"))
                .roles(ROLE_ADMIN)
                .build());

        inMemoryUserDetailsManager.createUser(User.withUsername("power_user")
                .password(bCryptPasswordEncoder.encode("1234"))
                .roles(ROLE_POWER_USER, ROLE_USER, ROLE_ADMIN)
                .build());

        inMemoryUserDetailsManager.createUser(User.withUsername("sorin")
                .password(bCryptPasswordEncoder.encode("1234"))
                .roles(ROLE_POWER_USER, ROLE_ADMIN)
                .build());

        return inMemoryUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
// any endpoint MUST be enumerated only once; we can control the access by using .hasRole and .hasAnyRole
        httpSecurity.authorizeHttpRequests(auth -> {
            auth.requestMatchers("/api/v1/company/create").hasAnyRole(ROLE_ADMIN, ROLE_POWER_USER);
            auth.requestMatchers("/api/v1/company/findCompanyByName").hasRole(ROLE_USER);
            auth.requestMatchers("/api/v1/company/generateCompanies").hasRole(ROLE_POWER_USER);
            auth.requestMatchers("/api/v1/company/getAllCompanies").hasRole(ROLE_POWER_USER);
            auth.requestMatchers("/api/v1/employee/createNewEmployee").hasRole(ROLE_POWER_USER);
            auth.requestMatchers("/api/v1/employee/getAllEmployees").hasRole(ROLE_POWER_USER);
            auth.requestMatchers("/api/v1/employee/findEmployeeByName").hasRole(ROLE_POWER_USER);
            auth.requestMatchers("/api/v1/employee/generateEmployees").hasRole(ROLE_POWER_USER);
            auth.requestMatchers("/api/v1/employee/employNewPerson").hasRole(ROLE_POWER_USER);
            auth.requestMatchers("/api/v1/employee/layOffEmployee").hasRole(ROLE_POWER_USER);
            auth.requestMatchers("/api/v1/employee/getEmployeesByCompanyId").hasRole(ROLE_POWER_USER);

//            For THYMELEAF CONTROLLER
            auth.requestMatchers("/start").hasRole(ROLE_USER);
            auth.requestMatchers("/welcome").hasRole(ROLE_USER);
            auth.requestMatchers("/showAll").hasRole(ROLE_USER);

        }).httpBasic();

        httpSecurity.csrf()
                .disable().authorizeHttpRequests()
                .and()
                .cors()
                .disable().authorizeHttpRequests();

        return httpSecurity.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/images/**", "/js/**", "/webjars/**");
    }
}