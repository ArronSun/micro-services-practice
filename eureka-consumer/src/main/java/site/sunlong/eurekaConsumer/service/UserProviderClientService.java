package site.sunlong.eurekaConsumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import site.sunlong.eurekaConsumer.config.FeignClientConfig;
import site.sunlong.eurekaConsumer.service.fallback.UserProviderServiceFallbackFactory;

/**
 * @Author: Sunlong
 * @date: 2021/12/14 10:37
 */
@FeignClient(name = "ZUUL-GATEWAY" , path = "zuul-proxy/user-providers-proxy/user"  ,fallbackFactory = UserProviderServiceFallbackFactory.class)
public interface UserProviderClientService {


    @GetMapping("/getUserName/{username}")
    String getUserName(@PathVariable("username") String username);

}
