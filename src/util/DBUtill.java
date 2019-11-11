package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *  DB연동을 위한 로드, 연결, 실행
 */

public class DBUtill {
	/**
	 * 로드
	 */
	static {
		try {
		Class.forName(DbProperty.DRVIER_NAME);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 연결
	 * 공유하는 것이 아님 -> 필요할때 호출해서 사용
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DbProperty.URL,
				DbProperty.USER,
				DbProperty.PASSWORD);
	
	}
	
	
	/**
	 * 실행
	 */
	
	
	/**
	 * 닫기 (db관련 사용된 객체 close)
	 * insert, update, delete인 경우
	 */
	public static void dbClose (Connection con, Statement stmt) {
		try {
		if(stmt != null) stmt.close();
		if (con!= null) con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 닫기 (db관련 사용된 객체 close)
	 * select 인 경우
	 */
	public static void dbClose(Connection con, Statement stmt, ResultSet rs) {
		try {
		if(rs!= null) rs.close();
		dbClose(con,stmt);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
