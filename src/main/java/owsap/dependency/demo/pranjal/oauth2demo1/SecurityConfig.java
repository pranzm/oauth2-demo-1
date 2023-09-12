package owsap.dependency.demo.pranjal.oauth2demo1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(authorizeConfig ->{
                    authorizeConfig.requestMatchers("/").permitAll();
                    authorizeConfig.anyRequest().authenticated();
                })
                .formLogin(Customizer.withDefaults())
                .build();

    }

    @Bean
    public UserDetailsService userDetailsService(){
        return new InMemoryUserDetailsManager(
                User.builder()
                        .username("pranjal")
                        .password("{noop}password")// Not encrypting for demo
                        .authorities("ROLE_user")
                        .build()
        );
    }

}
