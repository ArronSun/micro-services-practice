package site.sunlong.eurekaConsumer.service.fallback;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import site.sunlong.eurekaConsumer.service.ProviderClientService;

/**
 *  provider 失败反馈工厂类
 * @Author: Sunlong
 * @date: 2021/11/19 17:44
 */
@Component
public class ProviderFallbackFactory implements FallbackFactory<ProviderClientService> {


    @Override
    public ProviderClientService create(Throwable throwable) {
        throwable.printStackTrace();
        return new ProviderClientService() {
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
