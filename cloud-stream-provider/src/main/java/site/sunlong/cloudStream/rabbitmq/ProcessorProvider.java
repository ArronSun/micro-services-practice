package site.sunlong.cloudStream.rabbitmq;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import site.sunlong.cloudStream.messaging.IProcessor;

import javax.annotation.Resource;

/**
 * @Author: Sunlong
 * @date: 2021/12/13 10:32
 */
@EnableBinding(IProcessor.class)
public class ProcessorProvider {
    @Resource
    @Qualifier(IProcessor.OUTPUT)
    private MessageChannel messageChannel;

    public void send(Object sendMessage){
        messageChannel.send(MessageBuilder.withPayload(sendMessage).build());
    }
}
