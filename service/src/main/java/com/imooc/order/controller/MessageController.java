package com.imooc.order.controller;

import com.imooc.order.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/sendMessage")
public class MessageController {
    @Autowired
    private StreamClient streamClient;
    @RequestMapping("/stream")
    public void process(){
        streamClient.outPut().send(MessageBuilder.withPayload("NOW THE TIME IS : "+new Date().toString()).build());
    }
}
