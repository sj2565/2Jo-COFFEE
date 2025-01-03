package myCafe.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SuperDao {
	public String driver = "oracle.jdbc.driver.OracleDriver";
	public String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public String id = "team2cafe";
	public String password = "cafe123";
	public Connection conn = null; // 접속 객체

	public SuperDao() {
		try {
			Class.forName(driver); // 드라이버 로딩

			this.conn = this.getConnection(); // 접속 객체 생성
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void closeConnection() {
		// 해당 커넥션 정보를 종료합니다.
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		// 접속 객체를 만들어 주는 메소드입니다.
		Connection imsi = null;
		try {
			imsi = DriverManager.getConnection(url, id, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return imsi;
	}

}
