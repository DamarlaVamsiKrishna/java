package com.thoughtfocus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.thoughtfocus.dto.Dto;

public class Dao {
	Connection connection;

	public Dao(Connection connection) {
		this.connection = connection;
	}

	private static String insertQuery = "INSERT INTO stationary values(?,?,?,?,?,?)";

	public boolean add(Dto dto) {

		PreparedStatement preparedStatement;

		try {
			preparedStatement = connection.prepareStatement(insertQuery);

			preparedStatement.setString(1, dto.getName());
			preparedStatement.setDouble(2, dto.getPrice());
			preparedStatement.setString(3, dto.getType());
			preparedStatement.setInt(4, dto.getQunatity());
			preparedStatement.setString(5, dto.getBrandname());
			preparedStatement.setLong(6, dto.getSerialnumber());

			preparedStatement.execute();
			System.out.println("inserted successfully");
			return true;
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return false;

	}

	private static String getAllQuery = "SELECT * FROM stationary;";

	public void getAll() {
		PreparedStatement preparedStatement;

		try {
			preparedStatement = connection.prepareStatement(getAllQuery);
			System.out.println(preparedStatement.executeQuery());
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static String deleteQuery="DELETE FROM stationary where serialnumber=?";
	
	public Dto deleteBySerialNumber(long serialnumber) {
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(deleteQuery);
			preparedStatement.setLong(1, serialnumber);
			System.out.println(preparedStatement.executeUpdate());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;

	}
	private static String updateQuery="UPDATE stationary SET price=? where brandname=?";

	public Dto updatePriceByBrandName(Double price,String brand) {
		
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setDouble(1, price);
			preparedStatement.setString(2, brand);
			System.out.println(preparedStatement.executeUpdate());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;

	}
	
	private static String getAllByNameQuery = "SELECT name FROM stationary;";

	public List<Dto> getAllByName() {
		
		PreparedStatement preparedStatement;

		try {
			preparedStatement = connection.prepareStatement(getAllByNameQuery);
			System.out.println(preparedStatement.executeQuery());
			System.out.println("getting by name");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;

	}
} 
