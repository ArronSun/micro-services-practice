package site.sunlong.streamconsumer.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @Author: Sunlong
 * @date: 2021/12/10 17:55
 */
public interface IProcessor {

    /**
     * output channel name.
     */
    String OUTPUT = "stream_output";

    /**
     * Input channel name.
     */
    String INPUT = "stream_input";


    /**
     * @return output channel
     */
    @Output(IProcessor.OUTPUT)
    MessageChannel output();


    /**
     * @return input channel.
     */
    @Input(IProcessor.INPUT)
    SubscribableChannel input();

}
