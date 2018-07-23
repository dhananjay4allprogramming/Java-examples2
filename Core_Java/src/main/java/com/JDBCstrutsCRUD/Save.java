package com.JDBCstrutsCRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

public class Save extends ActionSupport{
	Mybean mybean = new Mybean();

	public Mybean getMybean() {
		return mybean;
	}

	public void setMybean(Mybean mybean) {
		this.mybean = mybean;
	}
	
	public String execute() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			String s = "insert into details values(?,?,?)";
			PreparedStatement ps = connection.prepareStatement(s);
			ps.setInt(1, mybean.getNo());
			ps.setString(2, mybean.getNam());
			ps.setString(3, mybean.getCt());
			ps.execute();
			connection.commit();
			
			ps.close();
			connection.close();
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		return "success";
	}
}
