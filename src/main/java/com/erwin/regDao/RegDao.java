package com.erwin.regDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.erwin.reg.Reg;

public class RegDao {
	public void storeData(Reg r) throws ClassNotFoundException, SQLException {
		Connection con=null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		String databaseUrl="jdbc:mysql://localhost:3306/demodatabase";
		String username="root";
		String password="ErwinRoy@3";
		con=DriverManager.getConnection(databaseUrl,username,password);
		String query="INSERT INTO users(first_name,last_name,email_address,phone_number,user_password) VALUES(?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, r.getFirstName());
		ps.setString(2, r.getLastName());
		ps.setString(3, r.getEmail());
		ps.setString(4, r.getPhone());
		ps.setString(5, r.getPassword());
		ps.executeUpdate();
	}
}
