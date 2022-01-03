package site.sunlong.eurekaConsumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import site.sunlong.eurekaConsumer.pojo.UserEntity;
import site.sunlong.eurekaConsumer.pojo.UserXmlDTO;
import site.sunlong.eurekaConsumer.service.ProviderClientService;
import site.sunlong.eurekaConsumer.service.UserProviderClientService;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: Sunlong
 * @date: 2021/11/18 18:19
 */
@RequestMapping("/consumer/feign")
@RestController
public class FeignController {

    private final static Map<String, AtomicInteger> countMap = new ConcurrentHashMap<>();

    @Autowired
    private ProviderClientService providerClientService;
    @Autowired
    private UserProviderClientService userProviderClientService;



    @HystrixCommand
    @GetMapping("hello")
    public String hello(){
        return "hello-test";
    }

    @GetMapping("test")
    public String test(){
        final String test = providerClientService.test();
//        final String test = "providerService.test()";

        return test;
    }

    @GetMapping("getName/{name}")
    public String testProviderHystrix(@PathVariable("name") String name){
        return providerClientService.testHystrix(name);
    }


    @GetMapping("/getUserName")
    public String getUserName(@RequestParam("username") String name){
        return userProviderClientService.getUserName(name);
    }


    @GetMapping("/user/save")
    String save( UserEntity userEntity){
        return userProviderClientService.save(userEntity);
    }

    @GetMapping("/gateway/request")
    public String getRequest(HttpServletRequest request) throws InterruptedException {

        final String header = request.getHeader("request-arg");
        System.out.println("AddRequestHeader="+header);

        final String requestParameter = request.getParameter("request-parameter");
        System.out.println("AddRequestParameter="+requestParameter);

        //休眠20s
        TimeUnit.SECONDS.sleep(20);

        // 重试
        final AtomicInteger atomicInteger = countMap.computeIfAbsent(requestParameter, v -> new AtomicInteger());
        final int i = atomicInteger.incrementAndGet();

        System.out.println("重试次数："+i);

        if (i < 3){
            throw new RuntimeException("try again.");
        }

        return "request";
    }

    @GetMapping("/gateway/rateLimit")
    public String gatewayRateLimit(){

        return "Request Rate Limit";
    }


    @PostMapping(value = "uploadFile" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String uploadFile(@RequestPart("file") MultipartFile multipartFile){
        return userProviderClientService.uploadFile(multipartFile);
    }

}
