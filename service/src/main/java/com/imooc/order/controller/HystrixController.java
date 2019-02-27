package com.imooc.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {

    @GetMapping("/getProductInfoList")
//    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",
//                    value = "3000")
//    })
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value = "10"), //校验条数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //断路器开启时间
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage", value = "60"), //触发断路器需要的错误比例
    })
    public String getProductInfoList(int i){
        if(i % 2 == 0){
            return "success";
        }
//        throw new RuntimeException();
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject("http://127.0.0.1:8080/product/listForOrder"
                                        , Arrays.asList("1"),String.class);
    }
    public String fallback(){
        return "当前排队的人太多啦,请稍后再试";
    }
    public String defaultFallback(){
        return "默认提示:请稍后再试";
    }
}
