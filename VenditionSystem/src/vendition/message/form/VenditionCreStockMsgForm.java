package vendition.message.form;

import org.apache.struts.action.ActionForm;

public class VenditionCreStockMsgForm extends ActionForm {
	private String warename;

	private String standard;

	private String unit;

	private int rate;

	private String stockdateYear;

	private String stockdateMon;

	private String stockdateDay;

	private int stockamount;

	private int moneysum;

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

	public VenditionCreStockMsgForm() {

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
	 * @return Returns the stockdateDay.
	 */
	public String getStockdateDay() {
		return stockdateDay;
	}

	/**
	 * @param stockdateDay
	 *            The stockdateDay to set.
	 */
	public void setStockdateDay(String stockdateDay) {
		this.stockdateDay = stockdateDay;
	}

	/**
	 * @return Returns the stockdateMon.
	 */
	public String getStockdateMon() {
		return stockdateMon;
	}

	/**
	 * @param stockdateMon
	 *            The stockdateMon to set.
	 */
	public void setStockdateMon(String stockdateMon) {
		this.stockdateMon = stockdateMon;
	}

	/**
	 * @return Returns the stockdateYear.
	 */
	public String getStockdateYear() {
		return stockdateYear;
	}

	/**
	 * @param stockdateYear
	 *            The stockdateYear to set.
	 */
	public void setStockdateYear(String stockdateYear) {
		this.stockdateYear = stockdateYear;
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
