package com.school.appointsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/login.html", "/css/**", "/js/**").permitAll()  // 允许访问登录页面和静态资源
                .anyRequest().authenticated()  // 其他所有请求都需要认证
            )
            .formLogin(form -> form
                .loginPage("/login.html")  // 指定自定义登录页面
                .loginProcessingUrl("/login")  // 指定登录处理URL
                .defaultSuccessUrl("/index.html", true)  // 登录成功后跳转到首页
                .permitAll()
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/login.html")  // 登出后跳转到登录页面
                .permitAll()
            )
            .csrf(csrf -> csrf.disable()); // 禁用CSRF保护
            
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        // 创建默认用户
        UserDetails user = User.builder()
            .username("admin")
            .password(passwordEncoder.encode("123456"))
            .roles("USER")
            .build();
            
        return new InMemoryUserDetailsManager(user);
    }
}