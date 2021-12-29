package site.sunlong.cloudgateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import site.sunlong.cloudgateway.resolver.UriKeyResolver;

/**
 * @Author: Sunlong
 * @date: 2021/12/29 15:00
 */
@Configuration
public class ResolverConfig {

//    @Bean
    public UriKeyResolver uriKeyResolver(){
        return new UriKeyResolver();
    }

}
