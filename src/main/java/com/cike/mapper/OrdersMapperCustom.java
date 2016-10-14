package com.cike.mapper;

import java.util.List;

import com.cike.po.OrderCustom;

public interface OrdersMapperCustom {
	//一对一查询，查询订单关联查询用户信息
	public List<OrderCustom> findOrderUserList() throws Exception;
}
