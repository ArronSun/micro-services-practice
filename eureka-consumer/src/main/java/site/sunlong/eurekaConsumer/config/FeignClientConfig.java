package site.sunlong.eurekaConsumer.config;

import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Sunlong
 * @date: 2021/12/21 10:14
 */
@Configuration
public class FeignClientConfig {

    @Bean
    public Logger.Level getFeignLoggerLevel() {
        return feign.Logger.Level.FULL;
    }


    @Bean
    public BasicAuthRequestInterceptor getBasicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("eurekaUser", "eurekaUserPassword");
    }
}
