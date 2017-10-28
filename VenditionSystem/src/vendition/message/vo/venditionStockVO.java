package vendition.message.vo;

import java.sql.Date;

public class venditionStockVO {
	private String stockid;

	private String wareid;

	private String warename;

	private String standard;

	private String unit;

	private String rate;

	private Date stockdate;

	private String stockamount;

	private String moneysum;

	private String operator;

	public venditionStockVO() {

	}

	/**
	 * @return Returns the moneysum.
	 */
	public String getMoneysum() {
		return moneysum;
	}

	/**
	 * @param moneysum
	 *            The moneysum to set.
	 */
	public void setMoneysum(String moneysum) {
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
	 * @return Returns the rate.
	 */
	public String getRate() {
		return rate;
	}

	/**
	 * @param rate
	 *            The rate to set.
	 */
	public void setRate(String rate) {
		this.rate = rate;
	}

	/**
	 * @return Returns the standard.
	 */
	public String getStandard() {
		return standard;
	}

	/**
	 * @param standard
	 *            The standard to set.
	 */
	public void setStandard(String standard) {
		this.standard = standard;
	}

	/**
	 * @return Returns the stockamount.
	 */
	public String getStockamount() {
		return stockamount;
	}

	/**
	 * @param stockamount
	 *            The stockamount to set.
	 */
	public void setStockamount(String stockamount) {
		this.stockamount = stockamount;
	}

	/**
	 * @return Returns the stockdate.
	 */
	public Date getStockdate() {
		return stockdate;
	}

	/**
	 * @param stockdate
	 *            The stockdate to set.
	 */
	public void setStockdate(Date stockdate) {
		this.stockdate = stockdate;
	}

	/**
	 * @return Returns the stockid.
	 */
	public String getStockid() {
		return stockid;
	}

	/**
	 * @param stockid
	 *            The stockid to set.
	 */
	public void setStockid(String stockid) {
		this.stockid = stockid;
	}

	/**
	 * @return Returns the unit.
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * @param unit
	 *            The unit to set.
	 */
	public void setUnit(String unit) {
		this.unit = unit;
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

	/**
	 * @return Returns the warename.
	 */
	public String getWarename() {
		return warename;
	}

	/**
	 * @param warename
	 *            The warename to set.
	 */
	public void setWarename(String warename) {
		this.warename = warename;
	}
}
