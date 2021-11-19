package site.sunlong.eurekaProvider.service;

/**
 * @Author: Sunlong
 * @date: 2021/11/19 14:32
 */
public interface ProviderService {

    /**
     * 获取启动参数
     * @return
     */
    String getArgs(String name) throws Exception;

}
