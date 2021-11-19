package site.sunlong.eurekaProvider.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.sunlong.eurekaProvider.service.ProviderService;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * @Author: Sunlong
 * @date: 2021/11/18 11:29
 */
@RequestMapping("/provider")
@RestController
public class ProviderController {

    @Resource
    private ApplicationArguments applicationArguments;

    @Autowired
    private ProviderService providerService;



    @GetMapping("/hello")
    public String test(){
        final String[] sourceArgs = applicationArguments.getSourceArgs();
        System.out.println(Arrays.toString(sourceArgs));

        return "Hello , I'm provider ,args:"+ Arrays.toString(sourceArgs);
    }


    @HystrixCommand(fallbackMethod = "testHystrixFallBack")
    @GetMapping("/getName/{name}")
    public String testHystrix(@PathVariable String name) throws Exception {
        return providerService.getArgs(name);
    }


    String testHystrixFallBack(@PathVariable String name){
        return "name: "+name +" is not exist.";
    }



}
