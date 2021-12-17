package chaneloper.vo;

public class ShowPurchaseListVo {
	private String pp_title;
	private String pi_name;
	private String pd_size;
	private String pd_color;
	private int pi_price;
	private String si_name;
	public ShowPurchaseListVo() {}
	public ShowPurchaseListVo(String pp_title, String pi_name, String pd_size, String pd_color, int pi_price,
			String si_name) {
		super();
		this.pp_title = pp_title;
		this.pi_name = pi_name;
		this.pd_size = pd_size;
		this.pd_color = pd_color;
		this.pi_price = pi_price;
		this.si_name = si_name;
	}
	public String getPp_title() {
		return pp_title;
	}
	public void setPp_title(String pp_title) {
		this.pp_title = pp_title;
	}
	public String getPi_name() {
		return pi_name;
	}
	public void setPi_name(String pi_name) {
		this.pi_name = pi_name;
	}
	public String getPd_size() {
		return pd_size;
	}
	public void setPd_size(String pd_size) {
		this.pd_size = pd_size;
	}
	public String getPd_color() {
		return pd_color;
	}
	public void setPd_color(String pd_color) {
		this.pd_color = pd_color;
	}
	public int getPi_price() {
		return pi_price;
	}
	public void setPi_price(int pi_price) {
		this.pi_price = pi_price;
	}
	public String getSi_name() {
		return si_name;
	}
	public void setSi_name(String si_name) {
		this.si_name = si_name;
	}
	
	
}
