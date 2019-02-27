package com.imooc.order.message;

import com.imooc.common.ProductInfoOutput;
import com.imooc.order.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
/**
* @Description:    接收product端发送的消息并处理
* @Author:         scott
* @CreateDate:     2019/2/14 10:43
* @UpdateUser:     null
* @UpdateDate:     null
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Component
@Slf4j
public class ProductInfoReceiver {
    @RabbitListener(queuesToDeclare = @Queue("productInfo"))
    public void fromMessageToOrder(String message){
        //将String类型的消息转换为Product对象
        log.info("接收到队列【{}】发来的消息:{}","productInfo",message);
        ProductInfoOutput product = null;
        try {
            product = (ProductInfoOutput) JsonUtil.fromJson(message, ProductInfoOutput.class);
        } catch (Exception e) {
            log.error("转换消息对象发生错误:{}",e);
        }
        log.info("转换后的product对象:{}",product);

    }

}
