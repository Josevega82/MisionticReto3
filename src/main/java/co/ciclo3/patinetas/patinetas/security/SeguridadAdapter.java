package co.ciclo3.patinetas.patinetas.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeguridadAdapter extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(a -> a
                        .antMatchers("/","/error","/webjars/**"
                        ,"/api/**"
                        )
                        .permitAll()
                        .anyRequest()
                        .authenticated()).exceptionHandling(e -> e
                        .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                                        //Al hacer login nos redirecciona al index.html
                        ).oauth2Login().defaultSuccessUrl("/",true);
        http
                .cors()
                .and()
                .csrf()
                .disable();
    }
}
