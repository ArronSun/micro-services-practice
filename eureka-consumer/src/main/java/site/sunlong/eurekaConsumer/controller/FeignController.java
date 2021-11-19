package site.sunlong.eurekaConsumer.controller;

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


    @GetMapping("test")
    public String test(){
        final String test = providerService.test();
//        final String test = "providerService.test()";

        return test;
    }

    @GetMapping("getName/{name}")
    public String testHystrix(@PathVariable("name") String name){
        return providerService.testHystrix(name);
    }

}
