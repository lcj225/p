package postgretest;

import java.sql.*;

public class jdbctest {
	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String url = "jdbc:postgresql://localhost:5432/iss_test_db";
		String user = "postgres";
		String password = "abcd1234";
		try {
			conn = DriverManager.getConnection(url, user, password);
			st = conn.createStatement();
			rs = st.executeQuery("SELECT VERSION()");
			if (rs.next())
				System.out.println(rs.getString(1));
		} catch (SQLException sqlEX) {
			System.out.println(sqlEX);
		} finally {
			try {
				rs.close();
				st.close();
				conn.close();
			} catch (SQLException sqlEX) {
				System.out.println(sqlEX);
			}
		}
	}

}
