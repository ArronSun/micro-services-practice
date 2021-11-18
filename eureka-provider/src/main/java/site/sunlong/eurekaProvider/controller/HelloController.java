package site.sunlong.eurekaProvider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Set;

/**
 * @Author: Sunlong
 * @date: 2021/11/18 11:29
 */
@RequestMapping("/provider")
@RestController
public class HelloController {

    @Autowired
    private ServerProperties serverProperties;
    @Resource
    private ApplicationArguments applicationArguments;


    @GetMapping("/hello")
    public String test(){
        final String[] sourceArgs = applicationArguments.getSourceArgs();
        System.out.println(Arrays.toString(sourceArgs));

        return "Hello , I'm provider ,args:"+ Arrays.toString(sourceArgs);
    }


}
