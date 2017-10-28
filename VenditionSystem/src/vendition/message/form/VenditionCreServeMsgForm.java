package vendition.message.form;

import org.apache.struts.action.ActionForm;

public class VenditionCreServeMsgForm extends ActionForm {

	private String serveid;

	private String servename;

	private String address;

	private String linkman;

	private String phone;

	private String bank;

	private String accounts;

	public VenditionCreServeMsgForm() {

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

	/**
	 * @return Returns the serveid.
	 */
	public String getServeid() {
		return serveid;
	}

	/**
	 * @param serveid
	 *            The serveid to set.
	 */
	public void setServeid(String serveid) {
		this.serveid = serveid;
	}

	/**
	 * @return Returns the servename.
	 */
	public String getServename() {
		return servename;
	}

	/**
	 * @param servename
	 *            The servename to set.
	 */
	public void setServename(String servename) {
		this.servename = servename;
	}
}
