package com.imooc.order.message;

import com.imooc.OrderApplicationTest;
import com.imooc.order.OrderApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

import static org.junit.Assert.*;

@Component
@Slf4j
public class MqMsgReceiverTest extends OrderApplicationTest {
    @Autowired
    public AmqpTemplate amqpTemplate;
    @Test
    public void sendMqMessage(){
        amqpTemplate.convertAndSend("myExchange","fruit","date=: "+new Date());
        log.info("send - message : {}","消息已发送");
    }
}