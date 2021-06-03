package com.promineotech.dealerships.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.promineotech.dealerships.entity.Employee;

@Service
public class EmployeeDao {
    private static final String HOSTNAME = "jdbc:mysql://localhost:3306/dealership?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Dolphins";
	
    public List<Employee> listAllEmployees() {
		final String sql = "SELECT * FROM employees";

		try (Connection connection = DriverManager.getConnection(HOSTNAME, USERNAME, PASSWORD);

				// create an employee statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

			// execute the employee query
			ResultSet rs = preparedStatement.executeQuery();
			List<Employee> list = new ArrayList<>();
			while (rs.next()) {
				int employeeID = rs.getInt("employeeID");
				String name = rs.getString("name");
				int locationID = rs.getInt("locationID");
				Employee employee = new Employee(employeeID, name, locationID);
				list.add(employee);
			}
			return list;
		} catch (SQLException e) {
			printSQLException(e);
			return Collections.emptyList();
		}

	}
    
 // new 
    public void newEmployee(int customerID, String name, int dealershipID) {
        final String sql = "insert into employees add name = ?, dealershipID = ? , where customerID = ?;";

        try (
			Connection connection = DriverManager.getConnection(HOSTNAME, USERNAME, PASSWORD);

				
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ) {

                preparedStatement.setString(1, name);
                preparedStatement.setInt(2, dealershipID);
                preparedStatement.setInt(3, customerID);

			  
			    preparedStatement.executeQuery();
            
        } catch (SQLException e) {
			printSQLException(e);
		} 
            
    }
    
    //update

	public void updateEmployee(int employeeID, String name, int locationID) {
		final String sql = "update which employeeID = ?, name = ?, locationID = ?;";

		try (Connection connection = DriverManager.getConnection(HOSTNAME, USERNAME, PASSWORD);

				// create an employee statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
			preparedStatement.setInt(1, employeeID);
			preparedStatement.setString(2, name);
			preparedStatement.setInt(3, locationID);

			// execute the employee query
			preparedStatement.executeQuery();

		} catch (SQLException e) {
			printSQLException(e);
		}

	}
	
	// Delete 
    
    public void deleteEmployee(int employeeID, String name, int dealershipID) {
        final String sql = "delete employee, confirm name = ?, dealershipID = ? , where employeeID = ?;";

        try (
			Connection connection = DriverManager.getConnection(HOSTNAME, USERNAME, PASSWORD);

				
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ) {

                preparedStatement.setString(1, name);
                preparedStatement.setInt(2, dealershipID);
                preparedStatement.setInt(3, employeeID);

			    
			    preparedStatement.executeQuery();
            
        } catch (SQLException e) {
			printSQLException(e);
		} 
            
    }

	public static void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}