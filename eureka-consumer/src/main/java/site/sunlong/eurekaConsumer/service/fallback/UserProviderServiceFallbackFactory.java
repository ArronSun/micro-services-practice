package site.sunlong.eurekaConsumer.service.fallback;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import site.sunlong.eurekaConsumer.pojo.UserEntity;
import site.sunlong.eurekaConsumer.service.UserProviderClientService;

/**
 * @Author: Sunlong
 * @date: 2021/12/15 11:56
 */
@Component
public class UserProviderServiceFallbackFactory implements FallbackFactory<UserProviderClientService> {

    @Override
    public UserProviderClientService create(Throwable throwable) {
        throwable.printStackTrace();
        return new UserProviderClientService() {
            @Override
            public String getUserName(String username) {
                return "UserProviderServiceFallbackFactory-getUserName-fallback";
            }

            @Override
            public String save(UserEntity userEntity) {
                return "UserProviderServiceFallbackFactory-save-fallback:"+userEntity;
            }
        };
    }
}
