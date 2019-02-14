package com.imooc.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {
    @StreamListener(StreamClient.INPUT)
    @SendTo({StreamClient.OUTPUT})
    public String processInput(Object message){
        log.info("OutStream接收到消息-----------------------------------------------------------:{}",message);
        return message.toString();
    }

    public void processOutput(String message){
        log.info("OUT接收消息 : {}",message);
    }
}
