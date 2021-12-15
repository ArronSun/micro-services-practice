package site.sunlong.eurekaConsumer.service.fallback;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import site.sunlong.eurekaConsumer.service.UserProviderService;

/**
 * @Author: Sunlong
 * @date: 2021/12/15 11:56
 */
@Component
public class UserProviderServiceFallbackFactory implements FallbackFactory<UserProviderService> {

    @Override
    public UserProviderService create(Throwable throwable) {
        return new UserProviderService() {
            @Override
            public String getUserName(String username) {
                return "UserProviderServiceFallbackFactory-getUserName-fallback";
            }
        };
    }
}
