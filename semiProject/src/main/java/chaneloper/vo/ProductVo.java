<<<<<<< HEAD
package chaneloper.vo;

public class ProductVo {
	String pi_num;
	String pi_name;
	String pi_price;
	String pd_color;
	String pp_title;
	String t_name;
	public ProductVo(String pi_num, String pi_name, String pi_price, String pd_color, String pp_title, String t_name) {
		super();
		this.pi_num = pi_num;
		this.pi_name = pi_name;
		this.pi_price = pi_price;
		this.pd_color = pd_color;
		this.pp_title = pp_title;
		this.t_name = t_name;
	}
	public String getPi_num() {
		return pi_num;
	}
	public void setPi_num(String pi_num) {
		this.pi_num = pi_num;
	}
	public String getPi_name() {
		return pi_name;
	}
	public void setPi_name(String pi_name) {
		this.pi_name = pi_name;
	}
	public String getPi_price() {
		return pi_price;
	}
	public void setPi_price(String pi_price) {
		this.pi_price = pi_price;
	}
	public String getPd_color() {
		return pd_color;
	}
	public void setPd_color(String pd_color) {
		this.pd_color = pd_color;
	}
	public String getPp_title() {
		return pp_title;
	}
	public void setPp_title(String pp_title) {
		this.pp_title = pp_title;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	
}
=======
package chaneloper.vo;

public class ProductVo {
	private int pi_num;		// 상품번호
	private String si_id;		// 사업자 아이디
	private String pi_name;		// 상품명
	private int pi_price;		// 가격
	private int pi_slaes;		// 판매수
	private int pi_count;		// 조회수
	
	public ProductVo() {
	}
	public ProductVo(int pi_num, String si_id, String pi_name, int pi_price, int pi_slaes, int pi_count) {
		super();
		this.pi_num = pi_num;
		this.si_id = si_id;
		this.pi_name = pi_name;
		this.pi_price = pi_price;
		this.pi_slaes = pi_slaes;
		this.pi_count = pi_count;
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
	public int getPi_slaes() {
		return pi_slaes;
	}
	public void setPi_slaes(int pi_slaes) {
		this.pi_slaes = pi_slaes;
	}
	public int getPi_count() {
		return pi_count;
	}
	public void setPi_count(int pi_count) {
		this.pi_count = pi_count;
	}
	
	
}
>>>>>>> branch 'master' of https://github.com/HyunwooY/SemiProject.git
