package com.imooc.order.servie.impl;

import com.imooc.order.dataobject.OrderMaster;
import com.imooc.order.dto.OrderDto;
import com.imooc.order.enums.OrderStatusEnum;
import com.imooc.order.enums.PayStatusEnum;
import com.imooc.order.repository.OrderDetailRepository;
import com.imooc.order.repository.OrderMasterRepository;
import com.imooc.order.servie.OrderService;
import com.imooc.order.utils.KeyUtil;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public OrderDto create(OrderDto orderDto) {
    // TODO 1.查询商品信息(调用商品服务)
    // TODO 2.计算总价
    // TODO 3.扣库存(调用商品服务)

    // 4.订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDto.setOrderId(KeyUtil.genUniqueKey());
        BeanUtils.copyProperties(orderDto,orderMaster);
        orderMaster.setOrderAmount(new BigDecimal(5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setOrderId(KeyUtil.genUniqueKey());

        orderMasterRepository.save(orderMaster);
        return orderDto;
    }
}
