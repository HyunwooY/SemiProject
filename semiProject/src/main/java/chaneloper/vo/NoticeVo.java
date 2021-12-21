package chaneloper.vo;

public class NoticeVo {
	private int n_num;
	private String n_context;
	public NoticeVo(int n_num, String n_context) {
		super();
		this.n_num = n_num;
		this.n_context = n_context;
	}
	public int getN_num() {
		return n_num;
	}
	public void setN_num(int n_num) {
		this.n_num = n_num;
	}
	public String getN_context() {
		return n_context;
	}
	public void setN_context(String n_context) {
		this.n_context = n_context;
	}

}
