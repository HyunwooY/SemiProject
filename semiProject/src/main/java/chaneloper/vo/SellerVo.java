package chaneloper.vo;

public class SellerVo {
	private String si_id;
	private String si_pwd;
	private String si_num;
	private String si_addr;
	private String si_phone;
	private String si_name;
	private String si_email;
	
	public SellerVo() {
	}

	public SellerVo(String si_id, String si_pwd, String si_num, String si_addr, String si_phone, String si_name,
			String si_email) {
		super();
		this.si_id = si_id;		// 사업자 아이디
		this.si_pwd = si_pwd;		// 사업자 비밀번호
		this.si_num = si_num;		// 사업자번호
		this.si_addr = si_addr;		// 소재지
		this.si_phone = si_phone;		// 사업자 연락처
		this.si_name = si_name;		// 브랜드명
		this.si_email = si_email;			// 사업자 이메일
	}

	public String getSi_id() {
		return si_id;
	}

	public void setSi_id(String si_id) {
		this.si_id = si_id;
	}

	public String getSi_pwd() {
		return si_pwd;
	}

	public void setSi_pwd(String si_pwd) {
		this.si_pwd = si_pwd;
	}

	public String getSi_num() {
		return si_num;
	}

	public void setSi_num(String si_num) {
		this.si_num = si_num;
	}

	public String getSi_addr() {
		return si_addr;
	}

	public void setSi_addr(String si_addr) {
		this.si_addr = si_addr;
	}

	public String getSi_phone() {
		return si_phone;
	}

	public void setSi_phone(String si_phone) {
		this.si_phone = si_phone;
	}

	public String getSi_name() {
		return si_name;
	}

	public void setSi_name(String si_name) {
		this.si_name = si_name;
	}

	public String getSi_email() {
		return si_email;
	}

	public void setSi_email(String si_email) {
		this.si_email = si_email;
	}
	
	
}
