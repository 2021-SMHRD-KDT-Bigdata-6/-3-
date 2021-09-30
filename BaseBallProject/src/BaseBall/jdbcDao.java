package BaseBall;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
<<<<<<< HEAD
import java.util.ArrayList;
=======
>>>>>>> branch 'master' of https://github.com/2021-SMHRD-KDT-Bigdata-6/ROORIPIRATES.git

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

	public int register(userVO vo) {
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
		} catch (SQLException e) { // SQL���� ������� �����ϱ� ��� ����
			e.printStackTrace(); // ������ �����۾� �����°� ->������ �ȶ�� ����
		} finally {
			close();
		}
		return cnt;
	}

	public userVO login(userVO vo) {
		userVO info = null; // �α��ν����ϸ� ��, �����ϸ� ���ο� ��ü����
		getConn();
		try {
			String sql = "select * from bbuser where user_id = ? and user_pw = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPw());
			rs = psmt.executeQuery(); // select ����� �ʿ��� Ű����
			if (rs.next()) { // Ŀ�� �̵��� ���� RS������ ���ذ� �ȵȴ�
				String id = rs.getString(1); // �÷� ��ġ�� ���ȳ��� "id" �÷����� ����
				String pw = rs.getString("user_pw");
				info = new userVO(id, pw);
			}
		} catch (SQLException e) {
<<<<<<< HEAD
=======
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
>>>>>>> branch 'master' of https://github.com/2021-SMHRD-KDT-Bigdata-6/ROORIPIRATES.git
			e.printStackTrace(); // ������ �����۾� �����°� ->������ �ȶ�� ����
		} finally {
			close();
		}
		return info;
	}

	
//ig_102������
	
	
	
	// IG_103 ��� ���� ��������

	public ArrayList<playerVO> select2() {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	// IG_104
	public int comparing(int a, int b) {
		return a;
	}

	// IG_105 �����߰�����

	public playerVO select3(playerVO pvo) {
		return pvo;
	}
<<<<<<< HEAD
=======
	

>>>>>>> branch 'master' of https://github.com/2021-SMHRD-KDT-Bigdata-6/ROORIPIRATES.git


}
