package site.sunlong.eurekaConsumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import site.sunlong.eurekaConsumer.service.fallback.ProviderFallbackFactory;
import site.sunlong.eurekaConsumer.service.fallback.ProviderServiceFallback;

/**
 * @Author: Sunlong
 * @date: 2021/11/18 18:12
 */
@FeignClient(name = "PROVIDER" , path = "provider" , fallback = ProviderServiceFallback.class)
//@FeignClient(name = "PROVIDER" , path = "provider" , fallbackFactory = ProviderFallbackFactory.class)
public interface ProviderService {

    @GetMapping("hello")
    public String test();

    @GetMapping("getName/{name}")
    public String testHystrix(@PathVariable String name);

}
