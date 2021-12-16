package chaneloper.vo;

public class ColorVo {
	private int pi_num;
	private String pd_color;
	public ColorVo(int pi_num, String pd_color) {
		super();
		this.pi_num = pi_num;
		this.pd_color = pd_color;
	}
	public int getPi_num() {
		return pi_num;
	}
	public void setPi_num(int pi_num) {
		this.pi_num = pi_num;
	}
	public String getPd_color() {
		return pd_color;
	}
	public void setPd_color(String pd_color) {
		this.pd_color = pd_color;
	}
	
}

