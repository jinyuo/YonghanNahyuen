package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *  DB������ ���� �ε�, ����, ����
 */

public class DBUtill {
	/**
	 * �ε�
	 */
	static {
		try {
		Class.forName(DbProperty.DRVIER_NAME);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ����
	 * �����ϴ� ���� �ƴ� -> �ʿ��Ҷ� ȣ���ؼ� ���
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DbProperty.URL,
				DbProperty.USER,
				DbProperty.PASSWORD);
	
	}
	
	
	/**
	 * ����
	 */
	
	
	/**
	 * �ݱ� (db���� ���� ��ü close)
	 * insert, update, delete�� ���
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
	 * �ݱ� (db���� ���� ��ü close)
	 * select �� ���
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
