package site.sunlong.cloudgateway.resolver;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 *    URI解析
 *   根据 URI 限流
 * @Author: Sunlong
 * @date: 2021/12/29 14:35
 */
@Component
public class UriKeyResolver implements KeyResolver {

    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        final String path = exchange.getRequest().getURI().getPath();
        System.out.println(path);
        return Mono.just(path);
    }
}
