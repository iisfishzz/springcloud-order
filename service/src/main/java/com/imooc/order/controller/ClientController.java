package com.imooc.order.controller;

import com.imooc.client.ProductClient;
import com.imooc.common.ProductInfoOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;
@RestController
public class ClientController {

    @Autowired
    private ProductClient productClient;

    /**
     * euraka  客户端通信的三种方式
     */
    @GetMapping("getProductMsg")
    @ResponseBody
    public String getProductMessage(){
        String response = productClient.msg();
        System.out.println("方式一接收到的返回结果:" + response);
        return response;
    }
    @GetMapping("/product/getProductListForOrder")
    public List<ProductInfoOutput> getProductListByOrder(){
        List<ProductInfoOutput> productInfoOutputs = productClient.listForOrder(Arrays.asList("20181205235929977233532"));
        return  productInfoOutputs;
    }

    @GetMapping("/product/returnSth")
    public String getReturnSth(Integer i){
        if(i % 2 == 0){
            String sth = productClient.returnSth();
            return  sth;
        }
        throw new RuntimeException();
    }
}
