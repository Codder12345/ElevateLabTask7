package org.elavatelab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeService {
	public void addEmployee(String name, String department, double salary) {
	    String sql = "INSERT INTO employees (name, department, salary) VALUES (?, ?, ?)";
	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setString(1, name);
	        pstmt.setString(2, department);
	        pstmt.setDouble(3, salary);
	        pstmt.executeUpdate();
	        System.out.println("Employee added successfully!");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public void viewEmployees() {
	    String sql = "SELECT * FROM employees";
	    try (Connection conn = DBConnection.getConnection();
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(sql)) {
	        while (rs.next()) {
	            System.out.println(rs.getInt("id") + " | " +
	                               rs.getString("name") + " | " +
	                               rs.getString("department") + " | " +
	                               rs.getDouble("salary"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public void updateEmployee(int id, String department, double salary) {
	    String sql = "UPDATE employees SET department = ?, salary = ? WHERE id = ?";
	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setString(1, department);
	        pstmt.setDouble(2, salary);
	        pstmt.setInt(3, id);
	        pstmt.executeUpdate();
	        System.out.println("Employee updated successfully!");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public void deleteEmployee(int id) {
	    String sql = "DELETE FROM employees WHERE id = ?";
	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setInt(1, id);
	        pstmt.executeUpdate();
	        System.out.println("Employee deleted successfully!");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


}
