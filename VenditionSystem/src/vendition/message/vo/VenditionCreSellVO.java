package vendition.message.vo;

public class VenditionCreSellVO {
	private int sellid;

	private String wareid;

	private String selldate;

	private int sellamount;

	private int moneysum;

	private String operator;

	public VenditionCreSellVO() {

	}

	/**
	 * @return Returns the moneysum.
	 */
	public int getMoneysum() {
		return moneysum;
	}

	/**
	 * @param moneysum
	 *            The moneysum to set.
	 */
	public void setMoneysum(int moneysum) {
		this.moneysum = moneysum;
	}

	/**
	 * @return Returns the operator.
	 */
	public String getOperator() {
		return operator;
	}

	/**
	 * @param operator
	 *            The operator to set.
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}

	/**
	 * @return Returns the sellamount.
	 */
	public int getSellamount() {
		return sellamount;
	}

	/**
	 * @param sellamount
	 *            The sellamount to set.
	 */
	public void setSellamount(int sellamount) {
		this.sellamount = sellamount;
	}

	/**
	 * @return Returns the selldate.
	 */
	public String getSelldate() {
		return selldate;
	}

	/**
	 * @param selldate
	 *            The selldate to set.
	 */
	public void setSelldate(String selldate) {
		this.selldate = selldate;
	}

	/**
	 * @return Returns the sellid.
	 */
	public int getSellid() {
		return sellid;
	}

	/**
	 * @param sellid
	 *            The sellid to set.
	 */
	public void setSellid(int sellid) {
		this.sellid = sellid;
	}

	/**
	 * @return Returns the wareid.
	 */
	public String getWareid() {
		return wareid;
	}

	/**
	 * @param wareid
	 *            The wareid to set.
	 */
	public void setWareid(String wareid) {
		this.wareid = wareid;
	}
}
