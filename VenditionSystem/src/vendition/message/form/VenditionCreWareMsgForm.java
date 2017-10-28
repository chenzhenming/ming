package vendition.message.form;

import org.apache.struts.action.ActionForm;

public class VenditionCreWareMsgForm extends ActionForm {
	private String wareid;

	private String warename;

	private String standard;

	private String unit;

	private String rate;

	public VenditionCreWareMsgForm() {

	}

	/**
	 * @return Returns the rate.
	 */
	public String getRate() {
		return rate;
	}

	/**
	 * @param rate
	 *            The rate to set.
	 */
	public void setRate(String rate) {
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
