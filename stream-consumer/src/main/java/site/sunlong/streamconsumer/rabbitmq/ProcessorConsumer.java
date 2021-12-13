package site.sunlong.streamconsumer.rabbitmq;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import site.sunlong.streamconsumer.messaging.IProcessor;

/**
 * @Author: Sunlong
 * @date: 2021/12/13 10:30
 */
@EnableBinding(IProcessor.class)
public class ProcessorConsumer {

    @StreamListener(IProcessor.INPUT)
    public void receive(Message<?> receivedMessage){
        System.out.println("receivedMessage="+receivedMessage.getPayload());
    }
}
