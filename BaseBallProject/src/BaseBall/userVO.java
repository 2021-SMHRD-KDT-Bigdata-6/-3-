package BaseBall;

public class userVO {

	private String id;
	private String pw;
	private int StreakCount =0;
	
	public userVO(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	public userVO() {
		
	}
	@Override
	public String toString() {
		return "userVO [id=" + id + ", pw=" + pw + "]";
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getStreakCount() {
		return StreakCount;
	}
	public void setStreakCount(int streakCount) {
		StreakCount = streakCount;
	}
	
	
}
