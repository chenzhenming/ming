package vendition.message.form;

import org.apache.struts.action.ActionForm;

public class VenditionCreSellMsgForm extends ActionForm {
	private String warename;

	private String standard;

	private String unit;

	private int rate;

	private String selldateYear;

	private String selldateMon;

	private String selldateDay;

	private int sellamount;

	private int moneysum;

	public VenditionCreSellMsgForm() {

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
	 * @return Returns the rate.
	 */
	public int getRate() {
		return rate;
	}

	/**
	 * @param rate
	 *            The rate to set.
	 */
	public void setRate(int rate) {
		this.rate = rate;
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
	 * @return Returns the selldateMon.
	 */
	public String getSelldateMon() {
		return selldateMon;
	}

	/**
	 * @param selldateMon
	 *            The selldateMon to set.
	 */
	public void setSelldateMon(String selldateMon) {
		this.selldateMon = selldateMon;
	}

	/**
	 * @return Returns the selldateYear.
	 */
	public String getSelldateYear() {
		return selldateYear;
	}

	/**
	 * @param selldateYear
	 *            The selldateYear to set.
	 */
	public void setSelldateYear(String selldateYear) {
		this.selldateYear = selldateYear;
	}

	/**
	 * @return Returns the sselldateDay.
	 */
	public String getSelldateDay() {
		return selldateDay;
	}

	/**
	 * @param sselldateDay
	 *            The sselldateDay to set.
	 */
	public void setSelldateDay(String selldateDay) {
		this.selldateDay = selldateDay;
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
