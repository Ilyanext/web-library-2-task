package ru.skypro.lessons.springboot.weblibrary.security;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.HttpSecurityDsl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import ru.skypro.lessons.springboot.weblibrary.pojo.Role;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
@Bean
public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception{
    return httpSecurity
            .csrf(AbstractHttpConfigurer::disable)
            .formLogin(Customizer.withDefaults())
            .logout(Customizer.withDefaults())
            .sessionManagement(Customizer.withDefaults())
            .httpBasic(Customizer.withDefaults())
            .authorizeHttpRequests(
                    matcherRegistry-> matcherRegistry
                            .requestMatchers(HttpMethod.POST,"/employee/**","/report/**")
                            .hasRole(ru.skypro.lessons.springboot.weblibrary.pojo.Role.ADMIN.name())
                            .requestMatchers(HttpMethod.PUT, "employee/**").hasRole(Role.ADMIN.name())
                            .requestMatchers(HttpMethod.DELETE, "employee/**").hasRole(Role.ADMIN.name())
                            .requestMatchers(HttpMethod.GET, "employee/**", "/report/**")
                            .hasAnyRole(Role.ADMIN.name(), Role.USER.name())
                            .requestMatchers("/**").permitAll()
            )
            .build();
}
@Bean
public UserDetailsManager userDetailsManager(PasswordEncoder passwordEncoder) {

    // Создаем пользователя Ivan с ролью USER
    UserDetails ivan = User.withUsername("Ivan")
            .password(passwordEncoder.encode("ivan1234"))
            .roles("USER")
            .build();

    // Создаем пользователя Vladimir с ролью USER
    UserDetails vladimir = User.withUsername("Vladimir")
            .password(passwordEncoder.encode("vladimir1234"))
            .roles("USER")
            .build();

    // Создаем пользователя admin с ролью ADMIN
    UserDetails admin = User.withUsername("admin")
            .password(passwordEncoder.encode("admin1234"))
            .roles("USER","ADMIN")
            .build();

    // Возвращаем новый сервис управления InMemoryUserDetailsManager
    // с добавленными пользователями (Ivan, Vladimir, admin)
    return new InMemoryUserDetailsManager(ivan, vladimir, admin);
}
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
