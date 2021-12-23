package chaneloper.vo;

public class PackagingVo {
	private int p_num;
	private int ph_num;
	private int pd_num;
	private int p_count;
	public PackagingVo() {}
	public PackagingVo(int p_num, int ph_num, int pd_num, int p_count) {
		super();
		this.p_num = p_num;
		this.ph_num = ph_num;
		this.pd_num = pd_num;
		this.p_count = p_count;
	}
	public int getP_num() {
		return p_num;
	}
	public void setP_num(int p_num) {
		this.p_num = p_num;
	}
	public int getPh_num() {
		return ph_num;
	}
	public void setPh_num(int ph_num) {
		this.ph_num = ph_num;
	}
	public int getPd_num() {
		return pd_num;
	}
	public void setPd_num(int pd_num) {
		this.pd_num = pd_num;
	}
	public int getP_count() {
		return p_count;
	}
	public void setP_count(int p_count) {
		this.p_count = p_count;
	}
	
}
