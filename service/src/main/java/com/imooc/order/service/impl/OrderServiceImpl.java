package com.imooc.order.service.impl;

import com.imooc.order.dataobject.OrderDetail;
import com.imooc.order.dataobject.OrderMaster;
import com.imooc.order.dto.OrderDTO;
import com.imooc.order.enums.OrderStatusEnum;
import com.imooc.order.enums.ResultEnum;
import com.imooc.order.exception.OrderException;
import com.imooc.order.repository.OrderDetailRepository;
import com.imooc.order.repository.OrderMasterRepository;
import com.imooc.order.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Created by 廖师兄
 * 2017-12-10 16:44
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMasterRepository orderMasterRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {
        //TODO
        //查询商品数量,价格

        //减少库存
        return null;
    }

    @Override
    @Transactional
    public OrderDTO finish(String orderId) {
        //1.查询订单
        Optional<OrderMaster> optional = orderMasterRepository.findById(orderId);
        if(!optional.isPresent()){
            throw new OrderException(ResultEnum.ORDER_NOT_EXIST);
        }
        OrderMaster orderMaster = optional.get();
        //2.判断订单状态
        if(!OrderStatusEnum.NEW.getCode().equals(orderMaster.getOrderStatus())){
            throw new OrderException(ResultEnum.ORDER_STATUS_ERROR);
        }
        //将状态改为完结
        orderMaster.setOrderStatus(OrderStatusEnum.FINISHED.getCode());
        orderMasterRepository.save(orderMaster);
        //返回orderDTO
        List<OrderDetail> orderDetailList = orderDetailRepository.findByOrderId(orderId);
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }


}
