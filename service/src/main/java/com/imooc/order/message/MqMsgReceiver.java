package com.imooc.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
* @Description:    用于接收mq消息
* @Author:         scott
* @CreateDate:     2019/1/23 14:28
* @UpdateUser:     scott
* @UpdateDate:     2019/1/23 14:28
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Slf4j
@Component
public class MqMsgReceiver {
    //方式一: 监听固定名称的队列
//    @RabbitListener(queues = "myQueue")
    //方式二: 创建并监听
//    @RabbitListener(queuesToDeclare = @Queue("myQueue"))
    //方式三: 创建并绑定exchange并监听
    //消息分组
    @RabbitListener(bindings = @QueueBinding(
            key = "computer",
            value = @Queue("myQueue"),
            exchange =  @Exchange("myExchange"))
    )
    public void computerProcess(String message){
        log.info("computer MqReceiver:{}",message);
    }

    @RabbitListener(bindings = @QueueBinding(
            key = "fruit",
            value = @Queue("myQueue"),
            exchange =  @Exchange("myExchange"))
    )
    public void fruitProcess(String message){
        log.info("fruit MqReceiver:{}",message);
    }
}
