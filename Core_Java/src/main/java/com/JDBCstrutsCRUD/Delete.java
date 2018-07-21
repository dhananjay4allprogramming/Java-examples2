package com.JDBCstrutsCRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class Delete extends ActionSupport implements ServletRequestAware{
	HttpServletRequest request;
	
	//override from Acction support
	@Override
	public String execute(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			PreparedStatement ps =null;
			
			String cv[] = request.getParameterValues("rdel");
			for(int i=0;i<cv.length;i++) {
				ps = connection.prepareStatement("delete from details where SNO = (?)");
				int k = Integer.parseInt(cv[i]);
				System.out.println("this is "+k);
				ps.setInt(1, k);
				ps.executeUpdate();
				connection.commit();
				
			}
			ps.close();
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
