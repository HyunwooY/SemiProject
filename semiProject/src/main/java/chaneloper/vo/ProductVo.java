package chaneloper.vo;

import java.sql.Date;

public class ProductVo {
	private int pi_num;		// 상품번호
	private String si_id;		// 사업자 아이디
	private String pi_name;		// 상품명
	private int pi_price;		// 가격
	private int pi_count;		// 판매수
	private Date pi_date;		// 등록일
	private String pi_category;
	
	public ProductVo() {
		
	}
	public ProductVo(int pi_num, String si_id, String pi_name, int pi_price, int pi_count, Date pi_date, String pi_category) {

		this.pi_num = pi_num;
		this.si_id = si_id;
		this.pi_name = pi_name;
		this.pi_price = pi_price;
		this.pi_count = pi_count;
		this.pi_date = pi_date;
		this.pi_category = pi_category;
	}
	public int getPi_num() {
		return pi_num;
	}
	public void setPi_num(int pi_num) {
		this.pi_num = pi_num;
	}
	public String getSi_id() {
		return si_id;
	}
	public void setSi_id(String si_id) {
		this.si_id = si_id;
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
	public int getPi_count() {
		return pi_count;
	}
	public void setPi_count(int pi_count) {
		this.pi_count = pi_count;
	}
	public Date getPi_date() {
		return pi_date;
	}
	public void setPi_date(Date pi_date) {
		this.pi_date = pi_date;
	}

	public String getPi_category() {
		return pi_category;
	}

	public void setPi_category(String pi_category) {
		this.pi_category = pi_category;
	}

	
}
