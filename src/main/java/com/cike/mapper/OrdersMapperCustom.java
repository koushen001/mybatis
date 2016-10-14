package com.cike.mapper;

import java.util.List;

import com.cike.po.OrderCustom;
import com.cike.po.Orders;
import com.cike.po.User;

public interface OrdersMapperCustom {
	// 一对一查询，查询订单关联查询用户信息，使用resultType
	public List<OrderCustom> findOrderUserList() throws Exception;

	// 一对一查询延迟加载
	public List<Orders> findOrderUserListLazyLoading() throws Exception;

	// 一对一查询，查询订单关联查询用户信息，使用resultMap
	public List<Orders> findOrderUserResultMap() throws Exception;

	// 一对多查询，使用resultMap

	public List<Orders> findOrderAndOrderDetails() throws Exception;

	// 一对多查询，使用resultMap完成，查询用户及订单关联订单明细和商品信息
	public List<User> findUserOrderDetails() throws Exception;
}
