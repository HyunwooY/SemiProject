package chaneloper.vo;

import java.sql.Date;


public class Search_ReviewVo {
	private int ph_num;
	private String MI_ID;
	private int R_HIT;
	private Date R_DATE;
	private String R_TITLE;
	private String R_CONTENT;
	private int R_NUM;
	public Search_ReviewVo(int ph_num, String mI_ID, int r_HIT, Date r_DATE, String r_TITLE, String r_CONTENT,
			int r_NUM) {
		super();
		this.ph_num = ph_num;
		MI_ID = mI_ID;
		R_HIT = r_HIT;
		R_DATE = r_DATE;
		R_TITLE = r_TITLE;
		R_CONTENT = r_CONTENT;
		R_NUM = r_NUM;
	}
	public int getPh_num() {
		return ph_num;
	}
	public void setPh_num(int ph_num) {
		this.ph_num = ph_num;
	}
	public String getMI_ID() {
		return MI_ID;
	}
	public void setMI_ID(String mI_ID) {
		MI_ID = mI_ID;
	}
	public int getR_HIT() {
		return R_HIT;
	}
	public void setR_HIT(int r_HIT) {
		R_HIT = r_HIT;
	}
	public Date getR_DATE() {
		return R_DATE;
	}
	public void setR_DATE(Date r_DATE) {
		R_DATE = r_DATE;
	}
	public String getR_TITLE() {
		return R_TITLE;
	}
	public void setR_TITLE(String r_TITLE) {
		R_TITLE = r_TITLE;
	}
	public String getR_CONTENT() {
		return R_CONTENT;
	}
	public void setR_CONTENT(String r_CONTENT) {
		R_CONTENT = r_CONTENT;
	}
	public int getR_NUM() {
		return R_NUM;
	}
	public void setR_NUM(int r_NUM) {
		R_NUM = r_NUM;
	}
}
