package site.sunlong.cloudConfigClient.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: Sunlong
 * @date: 2021/12/1 17:51
 */

@Component
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
