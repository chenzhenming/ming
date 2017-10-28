package vendition.message.form;

import org.apache.struts.action.ActionForm;

public class VenditionQryWareMsgForm extends ActionForm {
	private String wareidMsg;

	private String warenameMsg;

	private String wareid;

	private String[] wareids;

	public VenditionQryWareMsgForm() {
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
	 * @return Returns the wareids.
	 */
	public String[] getWareids() {
		return wareids;
	}

	/**
	 * @param wareids
	 *            The wareids to set.
	 */
	public void setWareids(String[] wareids) {
		this.wareids = wareids;
	}

}
