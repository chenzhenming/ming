package vendition.message.form;

import org.apache.struts.action.ActionForm;

public class VenditionPageNeedForm extends ActionForm {
	private String pageName;

	public VenditionPageNeedForm() {

	}

	/**
	 * @return Returns the pageName.
	 */
	public String getPageName() {
		return pageName;
	}

	/**
	 * @param pageName
	 *            The pageName to set.
	 */
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
}
