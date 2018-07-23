package com.JDBCstrutsCRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.opensymphony.xwork2.ActionSupport;

public class Updates extends ActionSupport{
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
			PreparedStatement ps = connection.prepareStatement("update details set sname=?,scountry=? where sno=?");
			ps.setString(1, mybean.getNam());
			ps.setString(2, mybean.getCt());
			ps.setInt(3, mybean.getNo());
			ps.executeUpdate();
			connection.commit();
			
			ps.close();
			connection.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
}
