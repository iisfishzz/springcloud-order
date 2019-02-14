package com.imooc.order.client;

import com.imooc.order.dataobject.DecreaseStockInput;
import com.imooc.order.dataobject.ProductInfoOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "product",path = "product") //如果客户端
public interface ProductClient {
    @RequestMapping(value = "msg" ,method= RequestMethod.GET)
    String msg();
    @PostMapping(value = "listForOrder")
    List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList);
    @PostMapping("/decreaseStock")
    void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList);

}
