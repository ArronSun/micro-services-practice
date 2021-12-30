package site.sunlong.eurekaConsumer.interceptor;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Request;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import jdk.nashorn.internal.ir.IfNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;

/**
 *  解决feign多参数问题
 * @Author: Sunlong
 * @date: 2021/12/30 15:31
 */
@Component
public class FeignRequestInterceptor implements RequestInterceptor {

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Called for every request. Add data using methods on the supplied {@link RequestTemplate}.
     *
     * @param template
     */
    @Override
    public void apply(RequestTemplate template) {
        final String method = template.method();
        final Request.Body requestBody = template.requestBody();

        if ("GET".equals(method) && requestBody != null && requestBody.bodyTemplate() != null) {
            final String requestParam = requestBody.asString();
            try {
                //把之前的请求体清空
                template.body(Request.Body.empty());

                final JsonNode jsonNode = objectMapper.readTree(requestParam);

                Map<String, Collection<String>> params = new HashMap<>(jsonNode.size());
                final Iterator<String> stringIterator = jsonNode.fieldNames();

                // 把请求对象封装成map做为参数传递
                while (stringIterator.hasNext()){
                    final String next = stringIterator.next();
                    final List<String> valuesAsText = jsonNode.findValuesAsText(next);
                    params.put(next , valuesAsText);
                }
                template.queries(params);
            } catch (IOException e) {
                //可根据项目需求处理异常
                e.printStackTrace();
            }
        }
    }
}
