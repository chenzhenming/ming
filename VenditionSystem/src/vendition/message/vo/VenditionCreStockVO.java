package vendition.message.vo;

public class VenditionCreStockVO {
	private int stockid;

	private String wareid;

	private String stockdate;

	private int stockamount;

	private int moneysum;

	private String operator;

	public VenditionCreStockVO() {

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
	 * @return Returns the stockamount.
	 */
	public int getStockamount() {
		return stockamount;
	}

	/**
	 * @param stockamount
	 *            The stockamount to set.
	 */
	public void setStockamount(int stockamount) {
		this.stockamount = stockamount;
	}

	/**
	 * @return Returns the stockdate.
	 */
	public String getStockdate() {
		return stockdate;
	}

	/**
	 * @param stockdate
	 *            The stockdate to set.
	 */
	public void setStockdate(String stockdate) {
		this.stockdate = stockdate;
	}

	/**
	 * @return Returns the stockid.
	 */
	public int getStockid() {
		return stockid;
	}

	/**
	 * @param i
	 *            The stockid to set.
	 */
	public void setStockid(int stockid) {
		this.stockid = stockid;
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
