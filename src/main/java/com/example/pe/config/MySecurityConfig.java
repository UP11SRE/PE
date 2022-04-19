package com.example.pe.config;

import com.example.pe.service.userServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {




    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                //csrf disable for api testing , please turn on when we use on browser.
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/user","/adduser").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

   // @Override
    //protected void configure(AuthenticationManagerBuilder auth) throws Exception{
      //  auth.userDetailsService(User);
    //}

    //@Bean
    //public BCryptPasswordEncoder  passwordEncoder(){
      //  return new BCryptPasswordEncoder(20);
    //}

    @Autowired
    private UserDetailsService userDetailsService;
    @Bean
    public AuthenticationProvider authProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return provider;

    }
    //@Bean
    //public PasswordEncoder passwordEncoder(){
      //  return NoOpPasswordEncoder.getInstance();
    //}






}
