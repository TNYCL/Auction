package com.craftrise.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.craftrise.data.SQL;

public class Connect implements SQL {

	public static Connection connect;
	public static Statement stat;
	
	public static void connectDatabase() {
		try {
			connect = DriverManager.getConnection("jdbc:mysql://"+IP+":"+PORT+"/"+DATABASE+"?autoReconnect=true",USER,PASS);
			stat = connect.createStatement();
		} catch(SQLException e) {
			System.out.println(CONNECTION_ERROR);
		}
	}

}
