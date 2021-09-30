package BaseBall;

public class playerVO {

	// 이름, 능력치, 포지션
	private String name;
	private int capa;
	private String position;
	
	public playerVO(String name, int capa, String position) {
		super();
		this.name = name;
		this.capa = capa;
		this.position = position;
	}
	
	@Override
	public String toString() {
		return "playerVO [name=" + name + ", capa=" + capa + ", position=" + position + "]";
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCapa() {
		return capa;
	}
	public void setCapa(int capa) {
		this.capa = capa;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	
	
}
