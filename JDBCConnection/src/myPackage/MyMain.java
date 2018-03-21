package myPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MyMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection("jdbc:sqlserver://serverName=;databaseName=;user=;password=;");
		con.setAutoCommit(false);
		Statement stmt = con.createStatement();
		stmt.setQueryTimeout(60);
		ResultSet rs = stmt.executeQuery("select * from abc");
		ResultSetMetaData rsmd = rs.getMetaData();
		rsmd.getColumnCount();
		rsmd.getColumnType(1);
		rsmd.getColumnName(1);
		while(rs.next()) {
			rs.getString(1);
			rs.getString("");
		}
		int i = stmt.executeUpdate("update abc set pqr = '10'"); // i rows affected
		stmt.addBatch("1st query");
		stmt.addBatch("2nd query");
		stmt.executeBatch();
		//con.commit();
		stmt.close();
		con.close();
		
	}

}
