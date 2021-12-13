package chaneloper.vo;

import java.sql.Date;

public class ReviewVo {
	private int r_num;
	private int ph_num;
	private String r_title;
	private Date r_date;
	private int r_hit;
	private String r_content;
	private String rp_title;
	public ReviewVo(int r_num, int ph_num, String r_title, Date r_date, int r_hit, String r_content, String rp_title) {
		super();
		this.r_num = r_num;
		this.ph_num = ph_num;
		this.r_title = r_title;
		this.r_date = r_date;
		this.r_hit = r_hit;
		this.r_content = r_content;
		this.rp_title = rp_title;
	}
	public int getR_num() {
		return r_num;
	}
	public void setR_num(int r_num) {
		this.r_num = r_num;
	}
	public int getPh_num() {
		return ph_num;
	}
	public void setPh_num(int ph_num) {
		this.ph_num = ph_num;
	}
	public String getR_title() {
		return r_title;
	}
	public void setR_title(String r_title) {
		this.r_title = r_title;
	}
	public Date getR_date() {
		return r_date;
	}
	public void setR_date(Date r_date) {
		this.r_date = r_date;
	}
	public int getR_hit() {
		return r_hit;
	}
	public void setR_hit(int r_hit) {
		this.r_hit = r_hit;
	}
	public String getR_content() {
		return r_content;
	}
	public void setR_content(String r_content) {
		this.r_content = r_content;
	}
	public String getRp_title() {
		return rp_title;
	}
	public void setRp_title(String rp_title) {
		this.rp_title = rp_title;
	}
	
}
