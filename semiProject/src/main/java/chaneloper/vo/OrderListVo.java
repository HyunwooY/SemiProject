package chaneloper.vo;

import java.sql.Date;

public class OrderListVo {
	// purchase_history table
	private int ph_num;					// 구매(판매) 번호
	private String mi_id;				// 구매자 ID
	private String ph_type;				// 구매 방법(카드결제, 무통장...)
	private String ph_state;			// 구매상태(결제전, 결제완료, 배송준비중, 배송중, 배송완료)
	private Date ph_regdate;			// 구매 날짜
	private String ph_addr;				// 수령 주소
	private String ph_phone;			// 수령인 전화번호
	private String ph_name;				// 수령인
	
	// product_detail table
	private int pd_num;					// 상품 세부 번호
	private String pd_size;				// 상품 사이즈
	private String pd_color;			// 상품 색상
	private int pd_count;				// 판매수
	
	// product_infomation table
	private int pi_num;				// 상품 번호
	private String pi_name;			// 상품 이름
	private int pi_price;			// 상품 가격				
	private int pi_count;			// 판매수
	private Date pi_date;			// 상품 등록일자
	private String pi_category;			// 상품 분류
	
	public OrderListVo() {}

	public OrderListVo(int ph_num, String mi_id, String ph_type, String ph_state, Date ph_regdate, String ph_addr,
			String ph_phone, String ph_name, int pd_num, String pd_size, String pd_color, int pd_count, int pi_num,
			String pi_name, int pi_price, int pi_count, Date pi_date, String pi_category) {
		super();
		this.ph_num = ph_num;
		this.mi_id = mi_id;
		this.ph_type = ph_type;
		this.ph_state = ph_state;
		this.ph_regdate = ph_regdate;
		this.ph_addr = ph_addr;
		this.ph_phone = ph_phone;
		this.ph_name = ph_name;
		this.pd_num = pd_num;
		this.pd_size = pd_size;
		this.pd_color = pd_color;
		this.pd_count = pd_count;
		this.pi_num = pi_num;
		this.pi_name = pi_name;
		this.pi_price = pi_price;
		this.pi_count = pi_count;
		this.pi_date = pi_date;
		this.pi_category = pi_category;
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

	public String getPh_addr() {
		return ph_addr;
	}

	public void setPh_addr(String ph_addr) {
		this.ph_addr = ph_addr;
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

	public int getPd_num() {
		return pd_num;
	}

	public void setPd_num(int pd_num) {
		this.pd_num = pd_num;
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

	public int getPd_count() {
		return pd_count;
	}

	public void setPd_count(int pd_count) {
		this.pd_count = pd_count;
	}

	public int getPi_num() {
		return pi_num;
	}

	public void setPi_num(int pi_num) {
		this.pi_num = pi_num;
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
