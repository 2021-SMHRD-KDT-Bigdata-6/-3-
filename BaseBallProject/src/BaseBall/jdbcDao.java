package BaseBall;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class jdbcDao {

	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement psmt = null;

	
	private void getConn() { //DB����
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

	
	private void close() { //DB���� ������ �ݱ�
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

	
	public int register(userVO vo) { // ȸ������ �޼ҵ�
		int cnt = 0;
		getConn();
		try {
			if (conn != null) {
				System.out.println("Ŀ�ؼ� ���Ἲ��");
			} else {
				System.out.println("Ŀ�ؼ� �������");
			}
			String sql = "insert into bbuser values(?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPw());
			cnt = psmt.executeUpdate();
		} catch (SQLException e) { 
			e.printStackTrace(); 
		} finally {
			close();
		}
		return cnt;
	}

	
	public userVO login(userVO vo) { // �α��� �޼ҵ�
		userVO info = null; 
		getConn();
		try {
			String sql = "select * from bbuser where user_id = ? and user_pw = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPw());
			rs = psmt.executeQuery(); 
			if (rs.next()) { 
				String id = rs.getString(1); 
				String pw = rs.getString("user_pw");
				info = new userVO(id, pw);
			}
		} catch (SQLException e) {
			e.printStackTrace(); 
		} finally {
			close();
		}
		return info;
	}

	
	public ArrayList<playerVO> select() { // Ÿ�� 5�� �����̱� �޼ҵ�
		ArrayList<playerVO> list = new ArrayList<playerVO>();
		getConn();
		try {
			String sql = "select * from bbplayer where pl_position = 'Ÿ��' ";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				String name = rs.getString(1);
				String position = rs.getString(2);
				int capa = rs.getInt(3);
				playerVO vo = new playerVO(name, capa, position);
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace(); // ������ �����۾� �����°� ->������ �ȶ�� ����
		} finally {
			close();
		}
		return list;
		
		
	} 
	
	public ArrayList<playerVO> select2() { //IG_103 ��� ���� 1�� ��������
		ArrayList<playerVO> list = new ArrayList<playerVO>();
		getConn();
		String sql = "select * from bbplayer where pl_position = '����' ";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString(1);
				String position = rs.getString(2);
				int capa = rs.getInt(3);
				playerVO vo = new playerVO(name, capa, position);
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//IG_104 
	public int comparing(int a, int b) {
		return a;
	}
	
	//IG_105 �����߰�����
	
	public ArrayList<playerVO> select3() { //IG_103 ��� Ÿ�� 1�� ��������
		ArrayList<playerVO> list = new ArrayList<playerVO>();
		getConn();
		String sql = "select * from bbplayer where pl_position = 'Ÿ��' ";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString(1);
				String position = rs.getString(2);
				int capa = rs.getInt(3);
				playerVO vo = new playerVO(name, capa, position);
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//userdata�߰�
	
	
	
}	