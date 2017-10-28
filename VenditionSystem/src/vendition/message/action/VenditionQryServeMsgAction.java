package vendition.message.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import vendition.message.dao.VenditionServeDAO;
import vendition.message.dao.VenditionWareDAO;
import vendition.message.dbexception.DBException;
import vendition.message.form.VenditionQryServeMsgForm;
import vendition.message.form.VenditionQryWareMsgForm;
import vendition.message.util.VenditionZHCNChangeUtil;
import vendition.message.vo.VenditionPageNeedVO;
import vendition.message.vo.VenditionServeVO;
import vendition.message.vo.VenditionWareMsgVO;

public class VenditionQryServeMsgAction extends DispatchAction {
	public ActionForward qryServeMsg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		// 编码转换;
		request.setCharacterEncoding("GB2312");
		VenditionQryServeMsgForm squf = (VenditionQryServeMsgForm) form;
		String stuId = null;
		try {
			if (squf.getServeidMsg() != null
					&& !"".equals(squf.getServeidMsg())) {
				stuId = new VenditionZHCNChangeUtil().ZHCNChange(squf
						.getServeidMsg());
			}
		} catch (Exception ex) {
			request.setAttribute("errors", "查询供应商信息失败");
			return mapping.findForward("errorpage");
		}
		List serveList = null;
		try {
			serveList = new VenditionServeDAO().queryServeMsg(stuId);
			if (serveList.size() == 0) {
				request.setAttribute("errors", "查询供应商信息失败");
				return mapping.findForward("errorpage");
			} else {
				request.setAttribute("serveList", serveList);
			}
		} catch (Exception ex) {
			request.setAttribute("errors", "查询供应商信息失败");
			return mapping.findForward("errorpage");
		}
		VenditionPageNeedVO spnv = new VenditionPageNeedVO();
		spnv.setAddress("/JSP/VenditionServeMsgJsp.jsp");
		request.setAttribute("VenditionPageNeedVO", spnv);
		return mapping.findForward("qrydone");

	}

	public ActionForward creServeMsg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		VenditionPageNeedVO spnv = new VenditionPageNeedVO();
		spnv.setAddress("/JSP/VenditionCreServeMsgJsp.jsp");
		request.setAttribute("VenditionPageNeedVO", spnv);
		return mapping.findForward("credone");

	}

	public ActionForward delServeMsg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// 得到form;
		VenditionQryServeMsgForm mqpf = (VenditionQryServeMsgForm) form;
		// 定义变量;
		String[] st = mqpf.getServeids();
		if (st == null && "".equals(st)) {
			request.setAttribute("errors", "请先选择再删除");
			return mapping.findForward("errorpage");
		}
		boolean whereflag = false;
		try { // 把值传到业务逻辑处理并得到返回值;
			whereflag = new VenditionServeDAO().removeServeMsg(st);
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

	public ActionForward upServeMsg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		// 得到form;
		VenditionQryServeMsgForm mqef = (VenditionQryServeMsgForm) form;
		String st1 = null;
		st1 = new String(mqef.getServeid().getBytes("ISO-8859-1"), "GB2312");
		VenditionServeVO mcvo = null;
		try {// 把值传到业务逻辑处理并得到返回值;
			mcvo = new VenditionServeDAO().queryOnlyServeMsg(st1);
			request.setAttribute("VenditionServeVO", mcvo);
		} catch (DBException e) {
			request.setAttribute("errors", "更新供应商信息失败");
			return mapping.findForward("errorpage");
		}// 把页面地址传到对像中;
		VenditionPageNeedVO spnv = new VenditionPageNeedVO();
		spnv.setAddress("/JSP/VenditionUpServeMsgJsp.jsp");
		request.setAttribute("VenditionPageNeedVO", spnv);
		return mapping.findForward("updone");
	}
}
