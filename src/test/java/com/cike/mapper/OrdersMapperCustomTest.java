package com.cike.mapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.cike.po.OrderCustom;
import com.cike.po.Orders;
import com.cike.po.User;

public class OrdersMapperCustomTest {
	private SqlSessionFactory sessionFactory;

	// 创建工厂
	@Before
	public void init() throws IOException {
		// 配置文件
		String resource = "SqlMapConfig.xml";
		// 加载配置文件到输入流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂
		sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindOrderUserList() throws Exception {
		SqlSession sqlSession = sessionFactory.openSession();
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		List<OrderCustom> ordersMapperCustoms = ordersMapperCustom.findOrderUserList();
		for (OrderCustom orderCustom : ordersMapperCustoms) {
			System.out.println(orderCustom);
		}
	}

	@Test
	public void testFindOrderUserResultMap() throws Exception {
		SqlSession sqlSession = sessionFactory.openSession();
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		List<Orders> orders = ordersMapperCustom.findOrderUserResultMap();
		for (Orders order : orders) {
			System.out.println(order);
		}
	}

	@Test
	public void testFindOrderAndOrderDetails() throws Exception {
		SqlSession sqlSession = sessionFactory.openSession();
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		List<Orders> orders = ordersMapperCustom.findOrderAndOrderDetails();
		for (Orders order : orders) {
			System.out.println(order);
		}
	}

	@Test
	public void testFindUserOrderDetails() throws Exception {
		SqlSession sqlSession = sessionFactory.openSession();
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		List<User> users = ordersMapperCustom.findUserOrderDetails();
		for (User user : users) {
			System.out.println(user);
		}
	}

}
