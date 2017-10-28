package vendition.message.form;

import org.apache.struts.action.ActionForm;

public class VenditionQryServeMsgForm extends ActionForm {
	private String serveidMsg;

	private String[] serveids;

	private String serveid;

	public VenditionQryServeMsgForm() {

	}

	/**
	 * @return Returns the serveid.
	 */
	public String getServeid() {
		return serveid;
	}

	/**
	 * @param serveid The serveid to set.
	 */
	public void setServeid(String serveid) {
		this.serveid = serveid;
	}

	/**
	 * @return Returns the serveidMsg.
	 */
	public String getServeidMsg() {
		return serveidMsg;
	}

	/**
	 * @param serveidMsg The serveidMsg to set.
	 */
	public void setServeidMsg(String serveidMsg) {
		this.serveidMsg = serveidMsg;
	}

	/**
	 * @return Returns the serveids.
	 */
	public String[] getServeids() {
		return serveids;
	}

	/**
	 * @param serveids The serveids to set.
	 */
	public void setServeids(String[] serveids) {
		this.serveids = serveids;
	}
}
