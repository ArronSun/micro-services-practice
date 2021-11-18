package site.sunlong.eurekaConsumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Sunlong
 * @date: 2021/11/18 18:12
 */
@FeignClient(name = "PROVIDER")
public interface ProviderService {

    @RequestMapping("/provider/hello")
    public String test();

}
