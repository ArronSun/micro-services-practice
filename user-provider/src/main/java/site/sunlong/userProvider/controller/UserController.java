package site.sunlong.userProvider.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import site.sunlong.userProvider.pojo.UserEntity;
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
    @GetMapping("/getUserName")
    public String getUserName(@RequestParam("username") String username) throws Exception {
        return userService.getUsername(username);
    }

    @GetMapping("save")
    String save(UserEntity userEntity){
        return userService.save(userEntity);
    }

}
