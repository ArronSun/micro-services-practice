package site.sunlong.cloudStream.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/**
 * @Author: Sunlong
 * @date: 2021/12/9 16:31
 */
@EnableBinding(Source.class)
public class SourceProvider {

    @Resource
    @Qualifier("output")
    private MessageChannel messageChannel;

    public void send(Object sendMessage){
        messageChannel.send(MessageBuilder.withPayload(sendMessage).build());
    }

}
