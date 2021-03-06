package site.sunlong.eurekaConsumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import site.sunlong.eurekaConsumer.config.FeignClientConfig;
import site.sunlong.eurekaConsumer.config.FeignMultipartSupportConfig;
import site.sunlong.eurekaConsumer.pojo.UserEntity;
import site.sunlong.eurekaConsumer.service.fallback.UserProviderServiceFallbackFactory;

/**
 * @Author: Sunlong
 * @date: 2021/12/14 10:37
 */
//@FeignClient(name = "ZUUL-GATEWAY" , path = "zuul-proxy/user-providers-proxy/user"  ,fallbackFactory = UserProviderServiceFallbackFactory.class,configuration = FeignClientConfig.class)
@FeignClient(name = "CLOUD-GATEWAY" , path = "/user-providers/user"  ,fallbackFactory = UserProviderServiceFallbackFactory.class,configuration = FeignMultipartSupportConfig.class)
public interface UserProviderClientService {


    @GetMapping("/getUserName")
    String getUserName(@RequestParam("username") String username);

    @GetMapping("save")
    String save(UserEntity userEntity);

    @PostMapping(name = "uploadFile" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String uploadFile(@RequestPart("file") MultipartFile multipartFile);

}
