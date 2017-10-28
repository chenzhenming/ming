package vendition.message.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import vendition.message.dao.VenditionClientDAO;
import vendition.message.form.VenditionCreClientMsgForm;
import vendition.message.form.VenditionUpClientMsgForm;
import vendition.message.util.VenditionZHCNChangeUtil;
import vendition.message.vo.VenditionClientVO;

public class VenditionUpClientMsgAction extends DispatchAction {
	public ActionForward upClientMsg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		// 编码转换;
		request.setCharacterEncoding("GB2312");
		VenditionUpClientMsgForm scmf = (VenditionUpClientMsgForm) form;
		VenditionClientVO sumv = new VenditionClientVO();
		sumv.setClientid(new VenditionZHCNChangeUtil().ZHCNChange(scmf
				.getClientid()));
		sumv.setClientname(new VenditionZHCNChangeUtil().ZHCNChange(scmf
				.getClientname()));
		sumv.setAddress(new VenditionZHCNChangeUtil().ZHCNChange(scmf
				.getAddress()));
		sumv.setLinkman(new VenditionZHCNChangeUtil().ZHCNChange(scmf
				.getLinkman()));
		sumv
				.setPhone(new VenditionZHCNChangeUtil().ZHCNChange(scmf
						.getPhone()));
		sumv.setBank(new VenditionZHCNChangeUtil().ZHCNChange(scmf.getBank()));
		sumv.setAccounts(new VenditionZHCNChangeUtil().ZHCNChange(scmf
				.getAccounts()));
		boolean count = false;
		try {
			count = new VenditionClientDAO().upClientMsg(sumv);
			if (count == false) {
				request.setAttribute("errors", "更新客户信息失败");
				return mapping.findForward("errorpage");
			}

		} catch (Exception ex) {
			request.setAttribute("errors", "更新客户信息失败");
			return mapping.findForward("errorpage");
		}
		return mapping.findForward("updone");
	}

	public ActionForward backfun(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// 直接反回;
		return mapping.findForward("backnow");

	}
}
