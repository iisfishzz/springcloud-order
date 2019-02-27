package com.imooc.client;

import com.imooc.common.DecreaseStockInput;
import com.imooc.common.ProductInfoOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 由于导入外部项目的jar包不能使用，所以先在本地使用feignClient，
 * 正常情况下应引入服务提供方的jar包来使用
 */
@FeignClient(value = "product" , fallback = ProductClient.ProductClientFallback.class) //如果客户端
public interface ProductClient {
    @RequestMapping(value = "msg" ,method= RequestMethod.GET)
    String msg();

    @PostMapping("/product/listForOrder")
    List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList);


    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList);

    @GetMapping("/product/returnSth")
    String returnSth();

    @Component
    static class ProductClientFallback implements ProductClient{

        @Override
        public String msg() {
            return "filed msg";
        }

        @Override
        public List<ProductInfoOutput> listForOrder(List<String> productIdList) {
            return null;
        }

        @Override
        public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {
            System.out.println("========================none decreaseStock");
        }

        @Override
        public String returnSth() {
            return "warning can't return sth";
        }
    }

}