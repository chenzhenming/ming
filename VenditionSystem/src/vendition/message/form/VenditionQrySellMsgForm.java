package vendition.message.form;

import org.apache.struts.action.ActionForm;

public class VenditionQrySellMsgForm extends ActionForm {
	private String wareidMsg;

	private String warenameMsg;

	private String selldateYear;

	private String selldateMon;

	private String selldateDay;

	private String sellid;

	public VenditionQrySellMsgForm() {

	}

	/**
	 * @return Returns the selldateDay.
	 */
	public String getSelldateDay() {
		return selldateDay;
	}

	/**
	 * @param selldateDay
	 *            The selldateDay to set.
	 */
	public void setSelldateDay(String selldateDay) {
		this.selldateDay = selldateDay;
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
}
