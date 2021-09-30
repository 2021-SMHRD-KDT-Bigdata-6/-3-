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

	private void getConn() {
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
				System.out.println("커넥션 연결성공");
			} else {
				System.out.println("커넥션 연결실패");
			}
			String sql = "insert into bbuser values(?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPw());
			cnt = psmt.executeUpdate();
		} catch (SQLException e) { // SQL에서 오류뜰수 있으니까 요건 냅둬
			e.printStackTrace(); // 에러시 빨간글씨 나오는거 ->없으면 안뜬다 넣자
		} finally {
			close();
		}
		return cnt;
	}

	public userVO login(userVO vo) {
		userVO info = null; // 로그인실패하면 널, 성공하면 새로운 객체생성
		getConn();
		try {
			String sql = "select * from bbuser where user_id = ? and user_pw = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPw());
			rs = psmt.executeQuery(); // select 실행시 필요한 키워드
			if (rs.next()) { // 커서 이동시 성공 RS개념이 이해가 안된다
				String id = rs.getString(1); // 컬럼 위치가 기억안나면 "id" 컬럼명사용 가능
				String pw = rs.getString("user_pw");
				info = new userVO(id, pw);
			}
		} catch (SQLException e) {
			e.printStackTrace(); // 에러시 빨간글씨 나오는거 ->없으면 안뜬다 넣자
		} finally {
			close();
		}
		return info;
	}

	
	public ArrayList<playerVO> select() {
		ArrayList<playerVO> list = new ArrayList<playerVO>();
		 // 로그인실패하면 널, 성공하면 새로운 객체생성
		getConn();
		try {
			//String sql = "select * from bbplayer where pl_name = ? and pl_position = ? and pl_capa = ? and rownum <= 5 and pl_position = '타자' order by DBMS_random.value ";
			String sql = "select * from bbplayer";
			psmt = conn.prepareStatement(sql);
//			psmt.setString(1, vo.getName());
//			psmt.setString(2, vo.getPosition());
//			psmt.setInt(3, vo.getCapa());
			rs = psmt.executeQuery(); // select 실행시 필요한 키워드
			while(rs.next()) {
				String name = rs.getString(1);
				int capa = rs.getInt(2);
				String position = rs.getString(3);
				playerVO info = new playerVO(name, capa, position);
				list.add(info);
			}
//			if (rs.next()) { // 커서 이동시 성공 RS개념이 이해가 안된다
//				
//				
//				
//				String name = rs.getString(1); // 컬럼 위치가 기억안나면 "id" 컬럼명사용 가능
//				String position = rs.getString("pl_position");
//				int capa = rs.getInt("pl_capa");
//				info = new playerVO(name, capa, position);
//			}
		} catch (SQLException e) {
			e.printStackTrace(); // 에러시 빨간글씨 나오는거 ->없으면 안뜬다 넣자
		} finally {
			close();
		}
		return list;
	} 
	//IG_103 상대 투수 랜덤추출
	public playerVO select2(playerVO pvo) {
		return pvo;
		
	}
	//IG_104 
	public int comparing(int a, int b) {
		return a;
	}
	
	//IG_105 선수추가추출
	
	public playerVO select3(playerVO pvo) {
		return pvo;
	}
	
	
	
	
	
	



}
