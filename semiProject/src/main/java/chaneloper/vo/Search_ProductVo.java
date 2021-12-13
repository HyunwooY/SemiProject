package chaneloper.vo;

public class Search_ProductVo {
	private int pi_num;
	private String pi_name;
	private int pi_price;
	private String pd_color;
	private String pp_title;
	public Search_ProductVo(int pi_num, String pi_name, int pi_price, String pd_color, String pp_title) {
		super();
		this.pi_num = pi_num;
		this.pi_name = pi_name;
		this.pi_price = pi_price;
		this.pd_color = pd_color;
		this.pp_title = pp_title;
	}
	public int getPi_num() {
		return pi_num;
	}
	public void setPi_num(int pi_num) {
		this.pi_num = pi_num;
	}
	public String getPi_name() {
		return pi_name;
	}
	public void setPi_name(String pi_name) {
		this.pi_name = pi_name;
	}
	public int getPi_price() {
		return pi_price;
	}
	public void setPi_price(int pi_price) {
		this.pi_price = pi_price;
	}
	public String getPd_color() {
		return pd_color;
	}
	public void setPd_color(String pd_color) {
		this.pd_color = pd_color;
	}
	public String getPp_title() {
		return pp_title;
	}
	public void setPp_title(String pp_title) {
		this.pp_title = pp_title;
	}
	
	
	
}