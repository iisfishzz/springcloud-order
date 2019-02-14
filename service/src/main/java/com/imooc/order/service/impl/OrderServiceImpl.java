package com.imooc.order.service.impl;

import com.imooc.order.dto.OrderDTO;
import com.imooc.order.service.OrderService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by 廖师兄
 * 2017-12-10 16:44
 */
@Service
public class OrderServiceImpl implements OrderService {



    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {
        //TODO
        return null;
    }

    @Override
    @Transactional
    public OrderDTO finish(String orderId) {
        return null;
    }


}
