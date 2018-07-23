package com.JDBCstrutsCRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class Display extends ActionSupport implements ServletRequestAware {
	HttpServletRequest request;
	
	public String execute() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from details");
			List list = new ArrayList();
			Mybean mybean = null;
			while(resultSet.next()) {
				mybean = new Mybean();
				mybean.setNo(resultSet.getInt("sno"));
				mybean.setNam(resultSet.getString("sname"));
				mybean.setCt(resultSet.getString("scountry"));
				list.add(mybean);
			}
			request.setAttribute("disp", list);
			resultSet.close();
			statement.close();
			connection.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "success";
	}
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpServletRequest getServletRequest() {
		return request;		
	}
	
}
