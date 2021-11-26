package site.sunlong.eurekaConsumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.sunlong.eurekaConsumer.service.ProviderService;

/**
 * @Author: Sunlong
 * @date: 2021/11/18 18:19
 */
@RequestMapping("/consumer/feign")
@RestController
public class FeignController {

    @Autowired
    private ProviderService providerService;

    @HystrixCommand
    @GetMapping("hello")
    public String hello(){
        return "hello-test";
    }

    @GetMapping("test")
    public String test(){
        final String test = providerService.test();
//        final String test = "providerService.test()";

        return test;
    }

    @GetMapping("getName/{name}")
    public String testProviderHystrix(@PathVariable("name") String name){
        return providerService.testHystrix(name);
    }

}
