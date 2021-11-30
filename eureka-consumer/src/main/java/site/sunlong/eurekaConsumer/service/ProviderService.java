package site.sunlong.eurekaConsumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import site.sunlong.eurekaConsumer.service.fallback.ProviderServiceFallback;

/**
 * fallback = ProviderServiceFallback.class 不能获取具体异常
 * @Author: Sunlong
 * @date: 2021/11/18 18:12
 */
//@FeignClient(name = "PROVIDER" , path = "provider" , fallback = ProviderServiceFallback.class)
@FeignClient(name = "ZUUL-GATEWAY" , path = "zuul-proxy/providers-proxy/provider" , fallback = ProviderServiceFallback.class)
//@FeignClient(name = "PROVIDER" , path = "provider" , fallbackFactory = ProviderFallbackFactory.class)
public interface ProviderService {

    @GetMapping("hello")
    public String test();

    @GetMapping("getName/{name}")
    public String testHystrix(@PathVariable String name);

}
