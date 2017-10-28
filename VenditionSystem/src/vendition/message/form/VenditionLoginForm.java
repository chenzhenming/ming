package vendition.message.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class VenditionLoginForm extends ActionForm {
	private String userId;

	private String password;

	public VenditionLoginForm() {

	}

	/**
	 * @return Returns the pasword.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param pasword
	 *            The pasword to set.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return Returns the userId.
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            The userId to set.
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
