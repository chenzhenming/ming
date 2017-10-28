package vendition.message.form;

import org.apache.struts.action.ActionForm;

public class VenditionQryReperForm extends ActionForm {
	private String wareidMsg;

	private String warenameMsg;

	public VenditionQryReperForm() {

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
