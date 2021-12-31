package site.sunlong.eurekaConsumer.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import site.sunlong.eurekaConsumer.pojo.UserXmlDTO;

/**
 * @Author: Sunlong
 * @date: 2021/12/31 11:01
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @PostMapping(value = "testXmlParam" , consumes = MediaType.APPLICATION_XML_VALUE , produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public UserXmlDTO testXmlParam(@RequestBody UserXmlDTO userXmlDTO){
        System.out.println(userXmlDTO);
        return userXmlDTO;
    }

}
