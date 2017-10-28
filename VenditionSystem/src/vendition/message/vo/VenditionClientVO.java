package vendition.message.vo;

public class VenditionClientVO {
	private int mark;

	private String clientid;

	private String clientname;

	private String address;

	private String linkman;

	private String phone;

	private String bank;

	private String accounts;

	public VenditionClientVO() {

	}

	/**
	 * @return Returns the accounts.
	 */
	public String getAccounts() {
		return accounts;
	}

	/**
	 * @param accounts
	 *            The accounts to set.
	 */
	public void setAccounts(String accounts) {
		this.accounts = accounts;
	}

	/**
	 * @return Returns the address.
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            The address to set.
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return Returns the bank.
	 */
	public String getBank() {
		return bank;
	}

	/**
	 * @param bank
	 *            The bank to set.
	 */
	public void setBank(String bank) {
		this.bank = bank;
	}

	/**
	 * @return Returns the clientid.
	 */
	public String getClientid() {
		return clientid;
	}

	/**
	 * @param clientid
	 *            The clientid to set.
	 */
	public void setClientid(String clientid) {
		this.clientid = clientid;
	}

	/**
	 * @return Returns the clientname.
	 */
	public String getClientname() {
		return clientname;
	}

	/**
	 * @param clientname
	 *            The clientname to set.
	 */
	public void setClientname(String clientname) {
		this.clientname = clientname;
	}

	/**
	 * @return Returns the linkman.
	 */
	public String getLinkman() {
		return linkman;
	}

	/**
	 * @param linkman
	 *            The linkman to set.
	 */
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	/**
	 * @return Returns the mark.
	 */
	public int getMark() {
		return mark;
	}

	/**
	 * @param mark
	 *            The mark to set.
	 */
	public void setMark(int mark) {
		this.mark = mark;
	}

	/**
	 * @return Returns the phone.
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            The phone to set.
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
