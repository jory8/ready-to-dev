package com.joolbite.incognito.config;

import com.joolbite.incognito.service.utilisateur.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    final UtilisateurService utilisateurService;

    public SecurityConfig(UtilisateurService utilisateurService){
        this.utilisateurService = utilisateurService;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf()
                .disable()
                .exceptionHandling()
                .authenticationEntryPoint(new Http403ForbiddenEntryPoint() {
                })
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .successHandler(new AuthentificationLoginSuccessHandler())
                .failureHandler(new SimpleUrlAuthenticationFailureHandler())
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(new AuthentificationLogoutSuccessHandler())
                .invalidateHttpSession(true)
                .and()
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/logout").permitAll()
                .antMatchers("/user").authenticated()
                .anyRequest().permitAll();
    }

    private class AuthentificationLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

        @Override
        public void onAuthenticationSuccess(HttpServletRequest request,
                                            HttpServletResponse response, Authentication authentication)
                throws IOException, ServletException {
            response.setStatus(HttpServletResponse.SC_OK);
        }
    }

    private class AuthentificationLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {

        @Override
        public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
                                    Authentication authentication) throws IOException, ServletException {
            response.setStatus(HttpServletResponse.SC_OK);
        }
    }


}