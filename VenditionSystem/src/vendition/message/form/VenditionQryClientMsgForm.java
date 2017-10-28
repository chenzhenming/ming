package vendition.message.form;

import org.apache.struts.action.ActionForm;

public class VenditionQryClientMsgForm extends ActionForm {
	private String clientidMsg;

	private String[] clientids;

	private String clientid;

	public VenditionQryClientMsgForm() {

	}

	/**
	 * @return Returns the clientid.
	 */
	public String getClientid() {
		return clientid;
	}

	/**
	 * @param clientid
	 *            The clientid to set.
	 */
	public void setClientid(String clientid) {
		this.clientid = clientid;
	}

	/**
	 * @return Returns the clientidMsg.
	 */
	public String getClientidMsg() {
		return clientidMsg;
	}

	/**
	 * @param clientidMsg
	 *            The clientidMsg to set.
	 */
	public void setClientidMsg(String clientidMsg) {
		this.clientidMsg = clientidMsg;
	}

	/**
	 * @return Returns the clientids.
	 */
	public String[] getClientids() {
		return clientids;
	}

	/**
	 * @param clientids
	 *            The clientids to set.
	 */
	public void setClientids(String[] clientids) {
		this.clientids = clientids;
	}
}
