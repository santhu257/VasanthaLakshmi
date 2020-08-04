package com.altimetrik.foodorder.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import oracle.jdbc.pool.OracleDataSource;

public class ConnectionManager {

	private static DataSource ds = null;

	private static void createConnection() {
		if (ds == null) {
			try {
				OracleDataSource ds = new OracleDataSource();
				ds.setDescription("Oracle on Sparky - Oracle Data Source");
				ds.setServerName("Test_2020");
				ds.setPortNumber(1521);
				ds.setUser("scott");
				ds.setPassword("tiger");
				Hashtable<String, String> env = new Hashtable<String, String>();
				env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory");
				env.put(Context.PROVIDER_URL, "jdbc:oracle:thin:@localhost:1521:xe");
				Context ctx = new InitialContext(env);
				ctx.bind("jdbc/FoodOrder", ds);
			} catch (NamingException e) {
				System.out.println("Naming Exception occured while creating connection " + e.getMessage());
				return;
			} catch (SQLException e) {
				System.out.println("SQL Exception occurred while creating connection " + e.getMessage());
				return;
			} catch (Exception e) {
				System.out.println("Exception occurred while creating connection " + e.getMessage());
				return;
			}
		}
	}

	public static Connection getConnection() throws SQLException {
		if (ds == null) {
			createConnection();
		}
		return ds.getConnection();
	}

}
