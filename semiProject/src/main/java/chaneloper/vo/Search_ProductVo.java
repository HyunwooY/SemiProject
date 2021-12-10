package chaneloper.vo;

public class Search_ProductVo {
	private String pi_num;
	private String pi_name;
	private String pi_price;
	private String pd_color;
	private String pp_title;
	private String t_name;
	public Search_ProductVo(String pi_num, String pi_name, String pi_price, String pd_color, String pp_title, String t_name) {
		super();
		this.pi_num = pi_num;
		this.pi_name = pi_name;
		this.pi_price = pi_price;
		this.pd_color = pd_color;
		this.pp_title = pp_title;
		this.t_name = t_name;
	}
	public String getPi_num() {
		return pi_num;
	}
	public void setPi_num(String pi_num) {
		this.pi_num = pi_num;
	}
	public String getPi_name() {
		return pi_name;
	}
	public void setPi_name(String pi_name) {
		this.pi_name = pi_name;
	}
	public String getPi_price() {
		return pi_price;
	}
	public void setPi_price(String pi_price) {
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
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
}