package com.cos.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity //시큐리티 필터가 등록이된다.
@EnableGlobalMethodSecurity(prePostEnabled = true)//특정 주소로 접근하면 권한 인증을 미리체크하겠다는 뜻
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Bean //IoC가 되서 스프링이 관리하게됨.. 필요할때 쓸 수 있음
    public BCryptPasswordEncoder encoderPWD(){
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()

                .antMatchers("/","/auth/**","/js/**","/css/**","/image/**") //auth는 누구나 들어갈 수 있는 url
                .permitAll()
                .anyRequest()
                .authenticated()
        .and()
                .formLogin()
                .loginPage("/auth/loginForm");


    }
}
