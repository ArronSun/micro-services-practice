package site.sunlong.streamconsumer.rabbitmq;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;


/**
 * 收信方
 * @Author: Sunlong
 * @date: 2021/12/9 16:15
 */

//@EnableBinding(Sink.class)
public class SinkReceiver {

    @StreamListener(Sink.INPUT)
    public void receive(Message<?> receivedMessage){
        System.out.println("receivedMessage="+receivedMessage.getPayload());
    }

}
