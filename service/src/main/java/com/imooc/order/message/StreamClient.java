package com.imooc.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface StreamClient {
    String INPUT = "myQueue";
    String OUTPUT = "outMessage";
    @Input(INPUT)
    SubscribableChannel input();
    @Output(OUTPUT)
    MessageChannel outPut();
}
