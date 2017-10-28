package vendition.message.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import vendition.message.dao.VenditionClientDAO;
import vendition.message.dao.VenditionServeDAO;
import vendition.message.dao.VenditionWareDAO;
import vendition.message.dbexception.DBException;
import vendition.message.form.VenditionCreStockMsgForm;
import vendition.message.form.VenditionQryClientMsgForm;
import vendition.message.form.VenditionQryServeMsgForm;
import vendition.message.util.VenditionZHCNChangeUtil;
import vendition.message.vo.VenditionClientVO;
import vendition.message.vo.VenditionPageNeedVO;
import vendition.message.vo.VenditionServeVO;
import vendition.message.vo.VenditionWareMsgVO;

public class VenditionQryClientMsgAction extends DispatchAction {
	public ActionForward qryClientMsg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		// 编码转换;
		request.setCharacterEncoding("GB2312");
		VenditionQryClientMsgForm squf = (VenditionQryClientMsgForm) form;
		String stuId = null;
		try {
			if (squf.getClientidMsg() != null
					&& !"".equals(squf.getClientidMsg())) {
				stuId = new VenditionZHCNChangeUtil().ZHCNChange(squf
						.getClientidMsg());
			}
		} catch (Exception ex) {
			request.setAttribute("errors", "查询客户信息失败");
			return mapping.findForward("errorpage");
		}
		List clientList = null;
		try {
			clientList = new VenditionClientDAO().queryClientMsg(stuId);
			if (clientList.size() == 0) {
				request.setAttribute("errors", "查询客户信息失败");
				return mapping.findForward("errorpage");
			} else {
				request.setAttribute("clientList", clientList);
			}
		} catch (Exception ex) {
			request.setAttribute("errors", "查询客户信息失败");
			return mapping.findForward("errorpage");
		}
		VenditionPageNeedVO spnv = new VenditionPageNeedVO();
		spnv.setAddress("/JSP/VenditionClientMsgJsp.jsp");
		request.setAttribute("VenditionPageNeedVO", spnv);
		return mapping.findForward("qrydone");

	}

	public ActionForward creClientMsg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		VenditionPageNeedVO spnv = new VenditionPageNeedVO();
		spnv.setAddress("/JSP/VenditionCreClientMsgJsp.jsp");
		request.setAttribute("VenditionPageNeedVO", spnv);
		return mapping.findForward("credone");

	}

	public ActionForward delClientMsg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// 得到form;
		VenditionQryClientMsgForm mqpf = (VenditionQryClientMsgForm) form;
		// 定义变量;
		String[] st = mqpf.getClientids();
		if (st == null && "".equals(st)) {
			request.setAttribute("errors", "请先选择再删除");
			return mapping.findForward("errorpage");
		}
		boolean whereflag = false;
		try { // 把值传到业务逻辑处理并得到返回值;
			whereflag = new VenditionClientDAO().removeClientMsg(st);
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

	public ActionForward upClientMsg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		// 得到form;
		VenditionQryClientMsgForm mqef = (VenditionQryClientMsgForm) form;
		String st1 = null;
		st1 = new String(mqef.getClientid().getBytes("ISO-8859-1"), "GB2312");
		VenditionClientVO mcvo = null;
		try {// 把值传到业务逻辑处理并得到返回值;
			mcvo = new VenditionClientDAO().queryOnlyClientMsg(st1);
			request.setAttribute("VenditionClientVO", mcvo);
		} catch (DBException e) {
			request.setAttribute("errors", "更新供应商信息失败");
			return mapping.findForward("errorpage");
		}// 把页面地址传到对像中;
		VenditionPageNeedVO spnv = new VenditionPageNeedVO();
		spnv.setAddress("/JSP/VenditionUpClientMsgJsp.jsp");
		request.setAttribute("VenditionPageNeedVO", spnv);
		return mapping.findForward("updone");
	}
	public ActionForward changeStockMsg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		// 编码转换;
		request.setCharacterEncoding("GB2312");
		VenditionCreStockMsgForm vcsf = (VenditionCreStockMsgForm) form;
		String someid = new VenditionZHCNChangeUtil().ZHCNChange(vcsf
				.getWarename());
		VenditionWareMsgVO vmvo = null;
		try {
			vmvo = new VenditionWareDAO().queryOnlyMareMsg(someid);
			if (vmvo == null) {
				request.setAttribute("errors", "没有对应的商品信息");
				return mapping.findForward("errorpage");
			} else {
				request.setAttribute("VenditionWareMsgVO", vmvo);
			}
		} catch (Exception ex) {
			request.setAttribute("errors", "没有对应的商品信息");
			return mapping.findForward("errorpage");
		}
		return mapping.findForward("changenow");

	}
}
