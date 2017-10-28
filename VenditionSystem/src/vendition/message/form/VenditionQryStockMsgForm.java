package vendition.message.form;

import org.apache.struts.action.ActionForm;

public class VenditionQryStockMsgForm extends ActionForm {
	private String wareidMsg;

	private String warenameMsg;

	private String stockdateYear;

	private String stockdateMon;

	private String stockdateDay;

	private String stockids;

	private String stockid;

	public VenditionQryStockMsgForm() {

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
	 * @return Returns the stockids.
	 */
	public String getStockids() {
		return stockids;
	}

	/**
	 * @param stockids
	 *            The stockids to set.
	 */
	public void setStockids(String stockids) {
		this.stockids = stockids;
	}

	/**
	 * @return Returns the wareidMsg.
	 */
	public String getWareidMsg() {
		return wareidMsg;
	}

	/**
	 * @param wareidMsg
	 *            The wareidMsg to set.
	 */
	public void setWareidMsg(String wareidMsg) {
		this.wareidMsg = wareidMsg;
	}

	/**
	 * @return Returns the warenameMsg.
	 */
	public String getWarenameMsg() {
		return warenameMsg;
	}

	/**
	 * @param warenameMsg
	 *            The warenameMsg to set.
	 */
	public void setWarenameMsg(String warenameMsg) {
		this.warenameMsg = warenameMsg;
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
}
