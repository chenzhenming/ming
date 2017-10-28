package vendition.message.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import vendition.message.dao.VenditionWareDAO;
import vendition.message.form.VenditionCreWareMsgForm;
import vendition.message.util.VenditionZHCNChangeUtil;
import vendition.message.vo.VenditionWareMsgVO;

public class VenditionCreWareMsgAction extends DispatchAction {
	public ActionForward venditionCreWareMsg(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		// 编码转换;
		request.setCharacterEncoding("GB2312");
		VenditionCreWareMsgForm scmf = (VenditionCreWareMsgForm) form;
		VenditionWareMsgVO sumv = new VenditionWareMsgVO();
		sumv.setWareid(new VenditionZHCNChangeUtil().ZHCNChange(scmf
				.getWareid()));
		sumv.setWarename(new VenditionZHCNChangeUtil().ZHCNChange(scmf
				.getWarename()));
		sumv.setStandard(new VenditionZHCNChangeUtil().ZHCNChange(scmf
				.getStandard()));
		sumv.setUnit(new VenditionZHCNChangeUtil().ZHCNChange(scmf.getUnit()));
		sumv.setRate(new VenditionZHCNChangeUtil().ZHCNChange(scmf.getRate()));
		int count = 0;
		try {
			count = new VenditionWareDAO().createWareMsg(sumv);
			if (count == 0) {
				request.setAttribute("errors", "添加商品信息失败");
				return mapping.findForward("errorpage");
			}

		} catch (Exception ex) {
			request.setAttribute("errors", "添加商品信息失败");
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
