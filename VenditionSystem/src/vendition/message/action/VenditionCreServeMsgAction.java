package vendition.message.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import vendition.message.dao.VenditionServeDAO;
import vendition.message.dao.VenditionWareDAO;
import vendition.message.form.VenditionCreServeMsgForm;
import vendition.message.form.VenditionCreWareMsgForm;
import vendition.message.util.VenditionZHCNChangeUtil;
import vendition.message.vo.VenditionServeVO;
import vendition.message.vo.VenditionWareMsgVO;

public class VenditionCreServeMsgAction extends DispatchAction {
	public ActionForward venditionCreServeMsg(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		// 编码转换;
		request.setCharacterEncoding("GB2312");
		VenditionCreServeMsgForm scmf = (VenditionCreServeMsgForm) form;
		VenditionServeVO sumv = new VenditionServeVO();
		sumv.setServeid(new VenditionZHCNChangeUtil().ZHCNChange(scmf
				.getServeid()));
		sumv.setServename(new VenditionZHCNChangeUtil().ZHCNChange(scmf
				.getServename()));
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
			count = new VenditionServeDAO().createServeMsg(sumv);
			if (count == 0) {
				request.setAttribute("errors", "添加供应商信息失败");
				return mapping.findForward("errorpage");
			}

		} catch (Exception ex) {
			request.setAttribute("errors", "添加供应商信息失败");
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
