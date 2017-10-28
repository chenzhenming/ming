package vendition.message.vo;

import java.sql.Date;

public class VenditionSellVO {
	private String sellid;

	private String wareid;

	private String warename;

	private String standard;

	private String unit;

	private String rate;

	private Date selldate;

	private String sellamount;

	private String moneysum;

	private String operator;

	public VenditionSellVO() {

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
	 * @return Returns the sellamount.
	 */
	public String getSellamount() {
		return sellamount;
	}

	/**
	 * @param sellamount
	 *            The sellamount to set.
	 */
	public void setSellamount(String sellamount) {
		this.sellamount = sellamount;
	}

	/**
	 * @return Returns the selldate.
	 */
	public Date getSelldate() {
		return selldate;
	}

	/**
	 * @param selldate
	 *            The selldate to set.
	 */
	public void setSelldate(Date selldate) {
		this.selldate = selldate;
	}

	/**
	 * @return Returns the sellid.
	 */
	public String getSellid() {
		return sellid;
	}

	/**
	 * @param sellid
	 *            The sellid to set.
	 */
	public void setSellid(String sellid) {
		this.sellid = sellid;
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
