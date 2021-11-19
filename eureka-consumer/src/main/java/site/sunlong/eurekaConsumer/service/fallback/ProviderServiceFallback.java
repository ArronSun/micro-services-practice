package site.sunlong.eurekaConsumer.service.fallback;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import site.sunlong.eurekaConsumer.service.ProviderService;

/**
 * @Author: Sunlong
 * @date: 2021/11/19 18:09
 */
@Component
public class ProviderServiceFallback implements ProviderService {

    @Override
    public String test() {
        return "consumer - test - fallback";
    }

    @Override
    public String testHystrix(String name) {
        return "consumer -testHystrix- fallback";
    }
}
