package site.sunlong.cloudStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "site.sunlong.*")
public class CloudStreamProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudStreamProviderApplication.class, args);
    }

}
