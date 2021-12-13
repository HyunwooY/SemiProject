package chaneloper.vo;
//리뷰 데이터 정의중 추후 명명변경 예정
public class Inquiry_historyVo {
	private int ih_num;
	private String md_id;
	private int pi_num;
	private String ih_title;
	private String ih_question;
	private String ih_answer;
	public Inquiry_historyVo(int ih_num, String md_id, int pi_num, String ih_title, String ih_question,
			String ih_answer) {
		super();
		this.ih_num = ih_num;
		this.md_id = md_id;
		this.pi_num = pi_num;
		this.ih_title = ih_title;
		this.ih_question = ih_question;
		this.ih_answer = ih_answer;
	}
	public int getIh_num() {
		return ih_num;
	}
	public void setIh_num(int ih_num) {
		this.ih_num = ih_num;
	}
	public String getMd_id() {
		return md_id;
	}
	public void setMd_id(String md_id) {
		this.md_id = md_id;
	}
	public int getPi_num() {
		return pi_num;
	}
	public void setPi_num(int pi_num) {
		this.pi_num = pi_num;
	}
	public String getIh_title() {
		return ih_title;
	}
	public void setIh_title(String ih_title) {
		this.ih_title = ih_title;
	}
	public String getIh_question() {
		return ih_question;
	}
	public void setIh_question(String ih_question) {
		this.ih_question = ih_question;
	}
	public String getIh_answer() {
		return ih_answer;
	}
	public void setIh_answer(String ih_answer) {
		this.ih_answer = ih_answer;
	}
	
	
}
