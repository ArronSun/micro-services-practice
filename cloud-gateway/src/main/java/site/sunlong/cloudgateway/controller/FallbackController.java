package site.sunlong.cloudgateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Sunlong
 * @date: 2021/12/28 17:56
 */
@RestController
public class FallbackController {

    @GetMapping("eureka_consumer/fallback")
    public String fallback(){
        return "Spring Cloud Gateway fallback.";
    }

}
