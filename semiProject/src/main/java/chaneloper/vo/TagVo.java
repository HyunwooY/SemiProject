package chaneloper.vo;

public class TagVo {
	private int pi_num;
	private String tag;
	
	public TagVo(int pi_num, String tag) {
		super();
		this.tag = tag;
		this.pi_num = pi_num;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public int getPi_num() {
		return pi_num;
	}
	public void setPi_num(int pi_num) {
		this.pi_num = pi_num;
	}
	
}
