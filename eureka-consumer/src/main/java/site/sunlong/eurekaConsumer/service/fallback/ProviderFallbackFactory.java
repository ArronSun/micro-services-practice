package site.sunlong.eurekaConsumer.service.fallback;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import site.sunlong.eurekaConsumer.service.ProviderService;

/**
 *  provider 失败反馈工厂类
 * @Author: Sunlong
 * @date: 2021/11/19 17:44
 */
@Component
public class ProviderFallbackFactory implements FallbackFactory<ProviderService> {


    @Override
    public ProviderService create(Throwable throwable) {

        return new ProviderService() {
            @Override
            public String test() {
                return "ProviderFallbackFactory-test";
            }

            @Override
            public String testHystrix(String name) {
                return "ProviderFallbackFactory-testHystrix";
            }
        };
    }
}
