package chaneloper.vo;

public class Search_ReviewptVo {
	private int r_num;
	private String title;
	public Search_ReviewptVo(int r_num, String title) {
		super();
		this.r_num = r_num;
		this.title = title;
	}
	public int getR_num() {
		return r_num;
	}
	public void setR_num(int r_num) {
		this.r_num = r_num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
