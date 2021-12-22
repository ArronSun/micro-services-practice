package site.sunlong.zuul.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author: Sunlong
 * @date: 2021/12/22 18:40
 */
@EnableOAuth2Sso
public class Oauth2WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests().
                antMatchers("/login" , "/client/**").permitAll()
        .anyRequest().authenticated()
                .and().csrf().disable();

    }
}
