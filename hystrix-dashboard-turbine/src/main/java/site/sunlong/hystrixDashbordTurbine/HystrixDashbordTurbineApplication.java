package site.sunlong.hystrixDashbordTurbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@EnableTurbine
@SpringBootApplication
public class HystrixDashbordTurbineApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashbordTurbineApplication.class, args);
    }

}
