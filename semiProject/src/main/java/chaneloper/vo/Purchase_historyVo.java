package chaneloper.vo;

import java.sql.Date;

public class Purchase_historyVo {
	private int ph_num;
	private String mi_id;
	private int pd_num;
	private String ph_type;
	private String ph_state;
	private Date ph_regdate;
	private String ph_phone;
	private String ph_name;
	
	public Purchase_historyVo() {}
	
	public Purchase_historyVo(int ph_num, String mi_id, int pd_num, String ph_type, String ph_state, Date ph_regdate,
			String ph_phone, String ph_name) {
		super();
		this.ph_num = ph_num;
		this.mi_id = mi_id;
		this.pd_num = pd_num;
		this.ph_type = ph_type;
		this.ph_state = ph_state;
		this.ph_regdate = ph_regdate;
		this.ph_phone = ph_phone;
		this.ph_name = ph_name;
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
	public int getPd_num() {
		return pd_num;
	}
	public void setPd_num(int pd_num) {
		this.pd_num = pd_num;
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
	public String getPh_phone() {
		return ph_phone;
	}
	public void setPh_phone(String ph_phone) {
		this.ph_phone = ph_phone;
	}
	public String getPh_name() {
		return ph_name;
	}
	public void setPh_name(String ph_name) {
		this.ph_name = ph_name;
	}
	
	
}
