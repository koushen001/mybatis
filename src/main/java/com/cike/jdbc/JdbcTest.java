package com.cike.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * jdbc测试程序
 *
 */
public class JdbcTest {
	public static void main(String[] args) {
		Connection connection = null;
		// PreparedStatement防止sql注入，执行数据库效率高
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			// 加载数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 通过驱动管理类获取数据库连接
			connection = DriverManager.getConnection("jdbc:mysql://localhost/mybatis", "root", "root");
			// 定义sql语句，？表示占位符
			String sql = "select * from user where username = ?";
			// 获取预处理的statement
			preparedStatement = connection.prepareStatement(sql);
			// 设置参数，第一个参数为sql语句中参数的序号（从1开始），第二个参数为参数的值
			preparedStatement.setString(1, "王五");
			// 执行查询，得到结果集
			resultSet = preparedStatement.executeQuery();
			// 遍历查询结果集
			while (resultSet.next()) {
				System.out.println(resultSet.getString("id") + " " + resultSet.getString("username"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
