package vendition.message.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.struts.actions.DispatchAction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import vendition.message.dao.VenditionWareDAO;
import vendition.message.dbexception.DBException;
import vendition.message.form.VenditionQryWareMsgForm;
import vendition.message.util.VenditionZHCNChangeUtil;
import vendition.message.vo.VenditionPageNeedVO;
import vendition.message.vo.VenditionWareMsgVO;

public class VenditionQryWareMsgAction extends DispatchAction {
	public ActionForward qryWareMsg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		// 编码转换;
		request.setCharacterEncoding("GB2312");
		VenditionQryWareMsgForm squf = (VenditionQryWareMsgForm) form;
		String stuId = null;
		String stuSub = null;
		try {
			if (squf.getWareidMsg() != null && !"".equals(squf.getWareidMsg())) {
				stuId = new VenditionZHCNChangeUtil().ZHCNChange(squf
						.getWareidMsg());

			}
			if (squf.getWarenameMsg() != null
					&& !"".equals(squf.getWarenameMsg())) {
				stuSub = new VenditionZHCNChangeUtil().ZHCNChange(squf
						.getWarenameMsg());
			}
		} catch (Exception ex) {
			request.setAttribute("errors", "查询商品信息失败");
			return mapping.findForward("errorpage");
		}
		List mareMsgList = null;
		try {
			mareMsgList = new VenditionWareDAO().queryMareMsg(stuId, stuSub);
			if (mareMsgList.size() == 0) {
				request.setAttribute("errors", "查询商品信息失败");
				return mapping.findForward("errorpage");
			} else {
				request.setAttribute("mareMsgList", mareMsgList);
			}
		} catch (Exception ex) {
			request.setAttribute("errors", "查询商品信息失败");
			return mapping.findForward("errorpage");
		}
		VenditionPageNeedVO spnv = new VenditionPageNeedVO();
		spnv.setAddress("/JSP/VenditionWareMsgJsp.jsp");
		request.setAttribute("VenditionPageNeedVO", spnv);
		return mapping.findForward("qrydone");

	}

	public ActionForward creWareMsg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		VenditionPageNeedVO spnv = new VenditionPageNeedVO();
		spnv.setAddress("/JSP/VenditionCreWareMsgJsp.jsp");
		request.setAttribute("VenditionPageNeedVO", spnv);
		return mapping.findForward("credone");

	}

	public ActionForward delWareMsg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// 得到form;
		VenditionQryWareMsgForm mqpf = (VenditionQryWareMsgForm) form;
		// 定义变量;
		String[] st = mqpf.getWareids();
		if (st == null && "".equals(st)) {
			request.setAttribute("errors", "请先选择再删除");
			return mapping.findForward("errorpage");
		}
		boolean whereflag = false;
		try { // 把值传到业务逻辑处理并得到返回值;
			whereflag = new VenditionWareDAO().removeWareMsg(st);
			// 判断反回值;
			if (whereflag = false) {
				// 无值的话转到错误页面;
				request.setAttribute("errors", "删除失败");
				return mapping.findForward("errorpage");
			}// 异常处理
		} catch (Exception ex) {
			request.setAttribute("errors", "删除过程失败");
			return mapping.findForward("errorpage");
		}
		return mapping.findForward("deldone");

	}

	public ActionForward upWareMsg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		// 得到form;
		VenditionQryWareMsgForm mqef = (VenditionQryWareMsgForm) form;
		String st1 = null;
		st1 = new String(mqef.getWareid().getBytes("ISO-8859-1"), "GB2312");
		VenditionWareMsgVO mcvo = null;
		try {// 把值传到业务逻辑处理并得到返回值;
			mcvo = new VenditionWareDAO().queryOnlyMareMsg(st1);
			request.setAttribute("VenditionWareMsgVO", mcvo);
		} catch (DBException e) {
			request.setAttribute("errors", "更新商品信息失败");
			return mapping.findForward("errorpage");
		}// 把页面地址传到对像中;
		VenditionPageNeedVO spnv = new VenditionPageNeedVO();
		spnv.setAddress("/JSP/VenditionUpWareMsgJsp.jsp");
		request.setAttribute("VenditionPageNeedVO", spnv);
		return mapping.findForward("updone");

	}
}
