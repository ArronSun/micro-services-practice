package site.sunlong.eurekaConsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: Sunlong
 * @date: 2021/11/18 11:02
 */
@RequestMapping("/consumer")
@RestController
public class RestTemplateTestController {

    // 用feign调用时要把这个注释掉，不知道为啥
//    @Autowired
    private RestTemplate restTemplate;

    private final String providerUrl = "http://PROVIDER/provider/hello";

    @GetMapping("/pro")
    public String provider(){
//        return restTemplate.getForObject(providerUrl , String.class);
        return "restTemplate.getForObject(providerUrl , String.class)";
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello,I am consumer,nice to meet you!";
    }




}
