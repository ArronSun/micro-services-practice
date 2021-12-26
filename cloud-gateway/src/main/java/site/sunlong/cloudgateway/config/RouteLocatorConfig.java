package site.sunlong.cloudgateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author: Sunlong
 * @date: 2021/12/24 17:55
 */
@Configuration
public class RouteLocatorConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder locatorBuilder){

        final RouteLocatorBuilder.Builder routes = locatorBuilder.routes();
        //比当前时间早一个小时
        ZonedDateTime localDateTimeAfter = LocalDateTime.now().plusHours(1).atZone(ZoneId.systemDefault());
        System.out.println(localDateTimeAfter);

        //配置文件UTC时间
        String format = ZonedDateTime.now().minusHours(1).format(DateTimeFormatter.ISO_ZONED_DATE_TIME);

        routes
                .route(baidu-> baidu.path("/qq_39654841").uri("http://blog.csdn.net/").id("my_csdn_route"))
                .route(afterRoute ->afterRoute.after(localDateTimeAfter).uri("http://blog.csdn.net/qq_39654841/category_9123089.html").id("after_route"))


        ;
        return routes.build();
    }

}
