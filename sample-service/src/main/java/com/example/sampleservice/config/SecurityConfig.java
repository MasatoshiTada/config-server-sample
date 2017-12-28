package com.example.sampleservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic(); // TODO このクラス作るとBASIC認証は無効になるの？
        http.csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                // ユーザー名:actuator、パスワード:password、ロール:ACTUATORのユーザーを追加
                .withUser("actuator").password("password").roles("ACTUATOR").and()
                // ユーザー名:user、パスワード:password、ロール:USERのユーザーを追加
                .withUser("user").password("password").roles("USER");
    }
}