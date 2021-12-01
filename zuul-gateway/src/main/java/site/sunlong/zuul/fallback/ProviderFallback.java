package site.sunlong.zuul.fallback;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * zuul 的降级处理
 * @Author: Sunlong
 * @date: 2021/12/1 11:16
 */
@Component
public class ProviderFallback implements FallbackProvider {
    @Override
    public String getRoute() {
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        final HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return badRequest;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return badRequest.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return badRequest.getReasonPhrase();
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                final String s = route + "服务不可用";
                return  new ByteArrayInputStream(s.getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.set("Content-Type", "text/html; charset=UTF-8");
                return headers;
            }
        };
    }
}
