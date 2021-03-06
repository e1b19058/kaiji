package team8.kaiji.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class AuthConfiguration extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    auth.inMemoryAuthentication().withUser("user1").password(passwordEncoder().encode("a")).roles("USER");

    auth.inMemoryAuthentication().withUser("user2").password(passwordEncoder().encode("a")).roles("USER");

    auth.inMemoryAuthentication().withUser("user3").password(passwordEncoder().encode("a")).roles("USER");

    auth.inMemoryAuthentication().withUser("user4").password(passwordEncoder().encode("a")).roles("USER");

    auth.inMemoryAuthentication().withUser("user5").password(passwordEncoder().encode("a")).roles("USER");

    auth.inMemoryAuthentication().withUser("user6").password(passwordEncoder().encode("a")).roles("USER");

    auth.inMemoryAuthentication().withUser("master").password(passwordEncoder().encode("a")).roles("MASTER");
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.formLogin();

    http.authorizeRequests().antMatchers("/game/**").authenticated();

    http.logout().logoutSuccessUrl("/");

    http.csrf().disable();
    http.headers().frameOptions().disable();
  }
}
