package BaseBall;

public class userVO {

	private String id;
	private String pw;
	
	public userVO(String id, String pw) {
		this.id = id;
		this.pw = pw;
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
	
	
}
