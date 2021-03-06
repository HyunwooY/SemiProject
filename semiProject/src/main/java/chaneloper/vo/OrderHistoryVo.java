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
	private int ph_count;
	private int priceAll;
	private String pp_title;
	private int pd_num;
	private String pd_size;
	private int pi_num;
	
	public OrderHistoryVo() {};
	public OrderHistoryVo(int ph_num, String mi_id, String ph_type, String ph_state, Date ph_regdate, String pi_name,
			int p_count, int pi_price,int ph_count,int priceAll,String pp_title, int pd_num,String pd_size,int pi_num) {
		this.ph_num = ph_num;
		this.mi_id = mi_id;
		this.ph_type = ph_type;
		this.ph_state = ph_state;
		this.ph_regdate = ph_regdate;
		this.pi_name = pi_name;
		this.p_count = p_count;
		this.pi_price = pi_price;
		this.ph_count = ph_count;
		this.priceAll = priceAll;
		this.pp_title=pp_title;
		this.pd_num=pd_num;
		this.pd_size=pd_size;
		this.pi_num=pi_num;
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
	public int getPd_num() {
		return pd_num;
	}
	public void setPd_num(int pd_num) {
		this.pd_num = pd_num;
	}
	public String getPp_title() {
		return pp_title;
	}
	public void setPp_title(String pp_title) {
		this.pp_title = pp_title;
	}
	public int getPh_count() {
		return ph_count;
	}
	public void setPh_count(int ph_count) {
		this.ph_count = ph_count;
	}
	public int getPriceAll() {
		return priceAll;
	}
	public void setPriceAll(int priceAll) {
		this.priceAll = priceAll;
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
