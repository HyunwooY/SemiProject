package chaneloper.vo;

import java.sql.Date;

/**
 * @author Steel
 *
 */
public class ProductVo {
	//product_infomation 테이블
	private int pi_num;		// 상품번호
	private String si_id;		// 사업자 아이디
	private String pi_name;		// 상품명
	private int pi_price;		// 가격
	private int pi_count;		// 판매수
	private Date pi_date;		// 등록일
	private String pi_category;		// 분류
	
	// product_detail 테이블
	private String pd_size;		// 상품 사이즈
	private String pd_color;		// 상품 색상
	private int pd_count;			// 제품수량
	
	// product_photo 테이블
	private String pp_title;		// 사진 파일 이름
	

	
	public ProductVo() {
		
	}

	public ProductVo(int pi_num, String si_id, String pi_name, int pi_price, int pi_count, Date pi_date,
			String pi_category, String pd_size, String pd_color, int pd_count, String pp_title) {
		super();
		this.pi_num = pi_num;
		this.si_id = si_id;
		this.pi_name = pi_name;
		this.pi_price = pi_price;
		this.pi_count = pi_count;
		this.pi_date = pi_date;
		this.pi_category = pi_category;
		this.pd_size = pd_size;
		this.pd_color = pd_color;
		this.pd_count = pd_count;
		this.pp_title = pp_title;
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

	public String getPp_title() {
		return pp_title;
	}

	public void setPp_title(String pp_title) {
		this.pp_title = pp_title;
	}
}
