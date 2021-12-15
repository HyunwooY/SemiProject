package chaneloper.vo;

import java.sql.Date;

public class OrderListVo {
	private int pi_num;
	private String pd_size;
	private int pd_count;
	private String pi_name;
	private Date ph_regdate;
	private int pi_price;
	private String pd_color;
	public OrderListVo() {};
	public OrderListVo(int pi_num, String pd_size, int pd_count, String pi_name, Date ph_regdate, int pi_price,
			String pd_color) {
		super();
		this.pi_num = pi_num;
		this.pd_size = pd_size;
		this.pd_count = pd_count;
		this.pi_name = pi_name;
		this.ph_regdate = ph_regdate;
		this.pi_price = pi_price;
		this.pd_color = pd_color;
	}
	public int getPi_num() {
		return pi_num;
	}
	public void setPi_num(int pi_num) {
		this.pi_num = pi_num;
	}
	public String getPd_size() {
		return pd_size;
	}
	public void setPd_size(String pd_size) {
		this.pd_size = pd_size;
	}
	public int getPd_count() {
		return pd_count;
	}
	public void setPd_count(int pd_count) {
		this.pd_count = pd_count;
	}
	public String getPi_name() {
		return pi_name;
	}
	public void setPi_name(String pi_name) {
		this.pi_name = pi_name;
	}
	public Date getPh_regdate() {
		return ph_regdate;
	}
	public void setPh_regdate(Date ph_regdate) {
		this.ph_regdate = ph_regdate;
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
	
}
