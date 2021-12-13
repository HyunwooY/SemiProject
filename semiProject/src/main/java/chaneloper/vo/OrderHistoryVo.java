package chaneloper.vo;

import java.sql.Date;

public class OrderHistoryVo {
	private int ph_num; // 구매번호
	private String mi_id;
	private String ph_type;
	private String ph_state;
	private Date ph_regdate; // 구매일자
	private String pi_name; // 상품명
	private int p_count; // 구매수량
	private int pi_price;
	public OrderHistoryVo() {};
	public OrderHistoryVo(int ph_num, String mi_id, String ph_type, String ph_state, Date ph_regdate, String pi_name,
			int p_count, int pi_price) {
		this.ph_num = ph_num;
		this.mi_id = mi_id;
		this.ph_type = ph_type;
		this.ph_state = ph_state;
		this.ph_regdate = ph_regdate;
		this.pi_name = pi_name;
		this.p_count = p_count;
		this.pi_price = pi_price;
	}
	public int getPh_num() {
		return ph_num;
	}
	public void setPh_num(int ph_num) {
		this.ph_num = ph_num;
	}
	public String getMi_id() {
		return mi_id;
	}
	public void setMi_id(String mi_id) {
		this.mi_id = mi_id;
	}
	public String getPh_type() {
		return ph_type;
	}
	public void setPh_type(String ph_type) {
		this.ph_type = ph_type;
	}
	public String getPh_state() {
		return ph_state;
	}
	public void setPh_state(String ph_state) {
		this.ph_state = ph_state;
	}
	public Date getPh_regdate() {
		return ph_regdate;
	}
	public void setPh_regdate(Date ph_regdate) {
		this.ph_regdate = ph_regdate;
	}
	public String getPi_name() {
		return pi_name;
	}
	public void setPi_name(String pi_name) {
		this.pi_name = pi_name;
	}
	public int getP_count() {
		return p_count;
	}
	public void setP_count(int p_count) {
		this.p_count = p_count;
	}
	public int getPi_price() {
		return pi_price;
	}
	public void setPi_price(int pi_price) {
		this.pi_price = pi_price;
	}
	
	
}
