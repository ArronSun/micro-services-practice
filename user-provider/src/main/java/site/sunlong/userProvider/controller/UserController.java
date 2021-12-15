package site.sunlong.userProvider.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.sunlong.userProvider.service.UserService;

/**
 * @Author: Sunlong
 * @date: 2021/11/26 16:35
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @HystrixCommand
    @GetMapping("/getUserName/{username}")
    public String getUserName(@PathVariable("username") String username) throws Exception {
        return userService.getUsername(username);
    }



}
