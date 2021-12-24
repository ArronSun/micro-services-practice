package site.sunlong.cloudgateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Sunlong
 * @date: 2021/12/24 17:55
 */
@Configuration
public class RouteLocatorConfig {

//    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder locatorBuilder){

        final RouteLocatorBuilder.Builder routes = locatorBuilder.routes();

        routes.route(baidu-> baidu.path("/qq_39654841").uri("http://blog.csdn.net/").id("my_csdn_route"));

        return routes.build();
    }

}
