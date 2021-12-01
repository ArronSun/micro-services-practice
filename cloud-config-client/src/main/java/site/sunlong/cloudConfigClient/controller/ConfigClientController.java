package site.sunlong.cloudConfigClient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.sunlong.cloudConfigClient.config.ConfigInfoProperties;

/**
 * @Author: Sunlong
 * @date: 2021/12/1 18:20
 */
@RequestMapping("configClient")
@RestController
public class ConfigClientController {

    @Autowired
    private ConfigInfoProperties configInfoProperties;

    @GetMapping("config")
    public String getConfig(){
        return configInfoProperties.getProfile();
    }

}
