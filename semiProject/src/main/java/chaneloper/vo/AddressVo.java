package chaneloper.vo;

public class AddressVo {
	private int num;
	private String id;
	private String name;
	private String nickname;
	private String phone;
	private String addr;
	public AddressVo() {}
	public AddressVo(int num, String id, String name, String nickname, String phone, String addr) {
		super();
		this.num = num;
		this.id = id;
		this.name = name;
		this.nickname = nickname;
		this.phone = phone;
		this.addr = addr;
	}
	public int getNum() {
		return num;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getNickname() {
		return nickname;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
}