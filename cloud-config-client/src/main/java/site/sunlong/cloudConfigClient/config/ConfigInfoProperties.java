package site.sunlong.cloudConfigClient.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author: Sunlong
 * @date: 2021/12/1 17:51
 */

@Configuration
@ConfigurationProperties(prefix = "site.sunlong")
public class ConfigInfoProperties {


    private String profile;

    public String getProfile() {
        return profile;
    }
    public void setProfile(String profile) {
        this.profile = profile;
    }
}
