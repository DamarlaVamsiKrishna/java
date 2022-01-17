package com.thoughtfocus.assessment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.thoughtfocus.dao.Dao;
import com.thoughtfocus.dto.Dto;

public class MainClass {
	
	public static void main(String[] args) {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thoughtfocus", "root", "Bakka@1434");
			if (connection != null) {
				System.out.println("connection is acquired successfully");
			} else {
				System.out.println("connection failed");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Dto dto =new Dto();

		dto.setName("book");
		dto.setPrice(50.25);
		dto.setType("white");
		dto.setQunatity(10);
		dto.setBrandname("Best friends");
		dto.setSerialnumber(12345678);
		
		Dao dao= new Dao(connection);
		
		dao.add(dto);
		dao.getAll();
		dao.deleteBySerialNumber(12345678);
		dao.updatePriceByBrandName(80.25, "Best friends");
		dao.getAllByName();
		
	}
	
	
}
