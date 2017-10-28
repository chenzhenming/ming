package vendition.message.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import vendition.message.dao.VenditionClientDAO;
import vendition.message.dao.venditionRepertoryDAO;
import vendition.message.form.VenditionQryClientMsgForm;
import vendition.message.form.VenditionQryReperForm;
import vendition.message.util.VenditionZHCNChangeUtil;
import vendition.message.vo.VenditionPageNeedVO;

public class VenditionQryReperAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		// ±‡¬Î◊™ªª;
		request.setCharacterEncoding("GB2312");
		VenditionQryReperForm squf = (VenditionQryReperForm) form;
		String stuId = null;
		String studf = null;
		try {
			if (squf.getWareidMsg() != null && !"".equals(squf.getWareidMsg())) {
				stuId = new VenditionZHCNChangeUtil().ZHCNChange(squf
						.getWareidMsg());
			}
			if (squf.getWarenameMsg() != null
					&& !"".equals(squf.getWarenameMsg())) {
				studf = new VenditionZHCNChangeUtil().ZHCNChange(squf
						.getWarenameMsg());
			}
		} catch (Exception ex) {
			request.setAttribute("errors", "≤È—Øø‚¥Ê–≈œ¢ ß∞‹");
			return mapping.findForward("errorpage");
		}
		List reperList = null;
		try {
			reperList = new venditionRepertoryDAO().queryReperMsg(stuId, studf);
			if (reperList.size() == 0) {
				request.setAttribute("errors", "≤È—Øø‚¥Ê–≈œ¢ ß∞‹");
				return mapping.findForward("errorpage");
			} else {
				request.setAttribute("reperList", reperList);
			}
		} catch (Exception ex) {
			request.setAttribute("errors", "≤È—Øø‚¥Ê–≈œ¢ ß∞‹");
			return mapping.findForward("errorpage");
		}
		VenditionPageNeedVO spnv = new VenditionPageNeedVO();
		spnv.setAddress("/JSP/VenditionRepertoryMsgJsp.jsp");
		request.setAttribute("VenditionPageNeedVO", spnv);
		return mapping.findForward("qrydone");
	}
}
