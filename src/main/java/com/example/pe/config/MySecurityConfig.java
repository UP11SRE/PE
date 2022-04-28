package com.example.pe.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
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

                //.and()
                //.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))

                //.logoutSuccessUrl("/logout1").deleteCookies("JSESSIONID")
                //.invalidateHttpSession(true);
    }





    @Autowired
    private UserDetailsService userDetailsService;





    @Bean
    public static BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(bCryptPasswordEncoder());
    }







}
