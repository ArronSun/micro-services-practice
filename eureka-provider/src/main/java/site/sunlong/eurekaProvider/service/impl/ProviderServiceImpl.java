package site.sunlong.eurekaProvider.service.impl;

import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Service;
import site.sunlong.eurekaProvider.service.ProviderService;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * @Author: Sunlong
 * @date: 2021/11/19 14:35
 */
@Service
public class ProviderServiceImpl implements ProviderService {


    @Resource
    private ApplicationArguments applicationArguments;

    /**
     * 获取启动参数
     *
     * @return
     */
    @Override
    public String getArgs(String name) throws Exception {
        if ("ex".equals(name)) {
            throw new Exception();
        }
        return name+"---"+Arrays.toString(applicationArguments.getSourceArgs());
    }


}
