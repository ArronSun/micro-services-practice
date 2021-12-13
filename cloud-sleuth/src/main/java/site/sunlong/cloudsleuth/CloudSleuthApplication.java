package site.sunlong.cloudsleuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin2.server.internal.EnableZipkinServer;

@EnableZipkinServer
@SpringBootApplication
public class CloudSleuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudSleuthApplication.class, args);
    }

}
