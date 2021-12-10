package chaneloper.vo;

public class Search_DetailProductVo {
	private int pi_num;
	private String pi_name;
	private int pi_price;
	private String pd_size;
	private String pd_color;
	private int pd_count;
	private String pp_title;
	private int r_num;
	private String r_title;
	private String r_content;
	private String r_date;
	private int r_hit;
	private String rp_title;
	public Search_DetailProductVo(int pi_num, String pi_name, int pi_price, String pd_size, String pd_color,
			int pd_count, String pp_title, int r_num, String r_title, String r_content, String r_date, int r_hit,
			String rp_title) {
		super();
		this.pi_num = pi_num;
		this.pi_name = pi_name;
		this.pi_price = pi_price;
		this.pd_size = pd_size;
		this.pd_color = pd_color;
		this.pd_count = pd_count;
		this.pp_title = pp_title;
		this.r_num = r_num;
		this.r_title = r_title;
		this.r_content = r_content;
		this.r_date = r_date;
		this.r_hit = r_hit;
		this.rp_title = rp_title;
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
	public int getR_num() {
		return r_num;
	}
	public void setR_num(int r_num) {
		this.r_num = r_num;
	}
	public String getR_title() {
		return r_title;
	}
	public void setR_title(String r_title) {
		this.r_title = r_title;
	}
	public String getR_content() {
		return r_content;
	}
	public void setR_content(String r_content) {
		this.r_content = r_content;
	}
	public String getR_date() {
		return r_date;
	}
	public void setR_date(String r_date) {
		this.r_date = r_date;
	}
	public int getR_hit() {
		return r_hit;
	}
	public void setR_hit(int r_hit) {
		this.r_hit = r_hit;
	}
	public String getRp_title() {
		return rp_title;
	}
	public void setRp_title(String rp_title) {
		this.rp_title = rp_title;
	}
	
	
	
}
