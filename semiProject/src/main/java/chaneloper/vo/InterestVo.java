package chaneloper.vo;

public class InterestVo {
	private int ig_num;
	private String mi_id;
	private int pi_num;
	private String si_name;
	private int pi_price;
	private String pi_name;
	private String pp_title;
	public InterestVo() {}
	public InterestVo(int ig_num, String mi_id, int pi_num,String si_name,int pi_price,String pi_name, String pp_title) {
		super();
		this.ig_num = ig_num;
		this.mi_id = mi_id;
		this.pi_num = pi_num;
		this.si_name=si_name;
		this.pi_price=pi_price;
		this.pi_name=pi_name;
		this.pp_title=pp_title;
	}
	
	public String getPp_title() {
		return pp_title;
	}
	public void setPp_title(String pp_title) {
		this.pp_title = pp_title;
	}
	public int getPi_price() {
		return pi_price;
	}
	public void setPi_price(int pi_price) {
		this.pi_price = pi_price;
	}
	public String getPi_name() {
		return pi_name;
	}
	public void setPi_name(String pi_name) {
		this.pi_name = pi_name;
	}
	public String getSi_name() {
		return si_name;
	}
	public void setSi_name(String si_name) {
		this.si_name = si_name;
	}
	public int getIg_num() {
		return ig_num;
	}
	public void setIg_num(int ig_num) {
		this.ig_num = ig_num;
	}
	public String getMi_id() {
		return mi_id;
	}
	public void setMi_id(String mi_id) {
		this.mi_id = mi_id;
	}
	public int getPi_num() {
		return pi_num;
	}
	public void setPi_num(int pi_num) {
		this.pi_num = pi_num;
	};
	
}
