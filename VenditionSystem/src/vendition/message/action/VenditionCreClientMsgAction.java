package vendition.message.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import vendition.message.dao.VenditionClientDAO;
import vendition.message.dao.VenditionServeDAO;
import vendition.message.form.VenditionCreClientMsgForm;
import vendition.message.form.VenditionCreServeMsgForm;
import vendition.message.util.VenditionZHCNChangeUtil;
import vendition.message.vo.VenditionClientVO;
import vendition.message.vo.VenditionServeVO;

public class VenditionCreClientMsgAction extends DispatchAction {
	public ActionForward venditionCreClientMsg(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		// 编码转换;
		request.setCharacterEncoding("GB2312");
		VenditionCreClientMsgForm scmf = (VenditionCreClientMsgForm) form;
		VenditionClientVO sumv = new VenditionClientVO();
		sumv.setClientid(new VenditionZHCNChangeUtil().ZHCNChange(scmf
				.getClientid()));
		sumv.setClientname(new VenditionZHCNChangeUtil().ZHCNChange(scmf
				.getClientid()));
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
		int count = 0;
		try {
			count = new VenditionClientDAO().createClientMsg(sumv);
			if (count == 0) {
				request.setAttribute("errors", "添加客户信息失败");
				return mapping.findForward("errorpage");
			}

		} catch (Exception ex) {
			request.setAttribute("errors", "添加客户信息失败");
			return mapping.findForward("errorpage");
		}
		return mapping.findForward("credone");
	}

	public ActionForward backfun(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// 直接反回;
		return mapping.findForward("backnow");

	}
}
