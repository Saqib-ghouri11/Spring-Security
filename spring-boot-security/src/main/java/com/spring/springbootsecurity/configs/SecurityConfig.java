package com.spring.springbootsecurity.configs;

import org.springframework.cglib.proxy.NoOp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.DELETE,"/users/delete/**").hasRole("ADMIN")
                .antMatchers("/pub/**").permitAll()
                .antMatchers("/signin").permitAll()
                .anyRequest().authenticated()
                .and().formLogin()
                .loginPage("/signin")
                .loginProcessingUrl("/doLogin")
                .defaultSuccessUrl("/pub/")
                .and()
                .logout().logoutUrl("/logout")
                .invalidateHttpSession(true).deleteCookies().logoutSuccessUrl("/signin");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.inMemoryAuthentication().withUser("saqib").password(getPasswordEncoder().encode("123456")).roles("ADMIN");
        auth.inMemoryAuthentication().withUser("ali").password(getPasswordEncoder().encode("12345")).roles("NORMAL");
    }

    @Bean
    PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    // the commented code below can be used with no password encoding and is not recommended in production.
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("saqib").password("123456").roles("ADMIN");
//        auth.inMemoryAuthentication().withUser("ali").password("123456").roles("NORMAL");
//    }
//
//    @Bean
//    PasswordEncoder getPasswordEncoder(){
//        return NoOpPasswordEncoder.getInstance();
//    }

}
