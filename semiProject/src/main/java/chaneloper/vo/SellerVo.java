package chaneloper.vo;

public class SellerVo {
	private String si_id;
	private String  si_pwd;
	private String si_num;
	private String si_addr;
	private String si_phone;
	private String si_name;
	private String email;
	
	public SellerVo() {
	}

	public SellerVo(String si_id, String si_pwd, String si_num, String si_addr, String si_phone, String si_name,
			String email) {
		super();
		this.si_id = si_id;
		this.si_pwd = si_pwd;
		this.si_num = si_num;
		this.si_addr = si_addr;
		this.si_phone = si_phone;
		this.si_name = si_name;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
