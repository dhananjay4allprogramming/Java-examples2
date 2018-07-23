package com.JDBCstrutsCRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class Update extends ActionSupport implements ServletRequestAware,ApplicationAware {
	HttpServletRequest request;
	Map map;
	public void setApplication(Map<String, Object> application) {
		this.map = application;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
		
	}
	public HttpServletRequest getServletRequest() {
		return request;
		
	}
	
	public String execute() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			PreparedStatement ps = connection.prepareStatement("select * from details where SNO = ?");
			String a = request.getParameter("fid");
			int k = Integer.parseInt(a);
			ps.setInt(1, k);
			System.out.println("this is a : "+k);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				map.put("a", rs.getInt("sno"));
				map.put("b", rs.getString("sname"));
				map.put("c", rs.getString("scountry"));
				
				ps.close();
				ps.close();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "success";
	}
	

}
