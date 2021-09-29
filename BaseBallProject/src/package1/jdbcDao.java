package package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import aa.MemberVO;
import aa.��Ŭ������;

public class jdbcDao {

	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement psmt = null;

	private void getConn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String db_url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe"; // localhost ip�ּ�, 1521 ��Ʈ�ѹ�
			String db_id = "cgi_5_1";
			String db_pw = "smhrd1";
			conn = DriverManager.getConnection(db_url, db_id, db_pw);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
cc
	private void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int register(��Ŭ������ vo) {
		int cnt = 0;
		getConn();
		try {
			if (conn != null) {
				System.out.println("Ŀ�ؼ� ���Ἲ��");
			} else {
				System.out.println("Ŀ�ؼ� �������");
			}
			String sql = "insert into user values(?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId()); 
			psmt.setString(2, vo.getPw());
			psmt.setString(3, vo.getNick());
			psmt.setString(4, vo.getScore()); //�̰� �Ⱦ���
			cnt = psmt.executeUpdate(); 
		} catch (SQLException e) { // SQL���� ������� �����ϱ� ��� ����
			e.printStackTrace(); // ������ �����۾� �����°� ->������ �ȶ�� ����
		} finally {
			close();
		}
		return cnt;
	}
	
	public ��Ŭ������ login(��Ŭ������ vo) {
		��Ŭ������ info = null; // �α��ν����ϸ� ��, �����ϸ� ���ο� ��ü����
		getConn();
		try {
			String sql = "select * from user where id = ? and pw = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPw());
			rs = psmt.executeQuery(); // select ����� �ʿ��� Ű����
			if (rs.next()) { // Ŀ�� �̵��� ���� RS������ ���ذ� �ȵȴ�
				String id = rs.getString(1); // �÷� ��ġ�� ���ȳ��� "id" �÷����� ����
				String pw = rs.getString("pw");
				info = new ��Ŭ������(id, pw);
			}
		} catch (SQLException e) {
			e.printStackTrace(); // ������ �����۾� �����°� ->������ �ȶ�� ����
		} finally {
			close();
		}
		return info;
	}
	
	
	
	
	
	

}
