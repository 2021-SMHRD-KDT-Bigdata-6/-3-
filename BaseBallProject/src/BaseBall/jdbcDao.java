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

	
	private void getConn() { //DB연결
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String db_url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe"; // localhost ip주소, 1521 포트넘버
			String db_id = "cgi_5_1";
			String db_pw = "smhrd1";
			conn = DriverManager.getConnection(db_url, db_id, db_pw);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	private void close() { //DB연결 종료후 닫기
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

	
	public int register(userVO vo) { // 회원가입 메소드
		int cnt = 0;
		getConn();
		try {
			if (conn != null) {
				System.out.println("커넥션 연결성공");
			} else {
				System.out.println("커넥션 연결실패");
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

	
	public userVO login(userVO vo) { // 로그인 메소드
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

	
	public ArrayList<playerVO> select() { // 타자 5명 랜덤뽑기 메소드
		ArrayList<playerVO> list = new ArrayList<playerVO>();
		getConn();
		try {
			String sql = "select * from bbplayer where pl_position = '타자' ";
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
			e.printStackTrace(); // 에러시 빨간글씨 나오는거 ->없으면 안뜬다 넣자
		} finally {
			close();
		}
		return list;
		
		
	} 
	
	public ArrayList<playerVO> select2() { //IG_103 상대 투수 1명 랜덤추출
		ArrayList<playerVO> list = new ArrayList<playerVO>();
		getConn();
		String sql = "select * from bbplayer where pl_position = '투수' ";
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
	
	//IG_105 선수추가추출
	
	public ArrayList<playerVO> select3() { //IG_103 상대 타자 1명 랜덤추출
		ArrayList<playerVO> list = new ArrayList<playerVO>();
		getConn();
		String sql = "select * from bbplayer where pl_position = '타자' ";
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
	
	//userdata추가
	
	
	
}	