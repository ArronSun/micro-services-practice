package site.sunlong.oauth2server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author sunlong
 * @date 2021/12/22 22 41
 */
@Configuration
public class Oauth2WebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        final BCryptPasswordEncoder passwordEncoder = bCryptPasswordEncoder();
        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder)
                .withUser("guest").password(passwordEncoder.encode("guest")).authorities("WRIGHT_READ")
                .and()
                .withUser("admin").password(passwordEncoder.encode("admin")).authorities("WRIGHT_READ","WRIGHT_WRITE");
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 密码加密方式
     * @return
     */
    @Bean
    public static BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
