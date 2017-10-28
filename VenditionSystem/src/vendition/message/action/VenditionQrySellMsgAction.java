package vendition.message.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import vendition.message.dao.VenditionSellDAO;
import vendition.message.dao.VenditionStockDAO;
import vendition.message.dao.VenditionWareDAO;
import vendition.message.form.VenditionQrySellMsgForm;
import vendition.message.form.VenditionQryStockMsgForm;
import vendition.message.util.VenditionZHCNChangeUtil;
import vendition.message.vo.VenditionPageNeedVO;

public class VenditionQrySellMsgAction extends DispatchAction {
	public ActionForward qryStockMsg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		// 编码转换;
		request.setCharacterEncoding("GB2312");
		VenditionQrySellMsgForm squf = (VenditionQrySellMsgForm) form;
		String wareid = new VenditionZHCNChangeUtil().ZHCNChange(squf
				.getWareidMsg());
		String warename = new VenditionZHCNChangeUtil().ZHCNChange(squf
				.getWarenameMsg());
		List stockList = null;
		try {
			stockList = new VenditionSellDAO().queryStockMsg(wareid, warename,
					squf);
			if (stockList.size() == 0) {
				return mapping.findForward("qrydone");
			} else {
				request.setAttribute("stockList", stockList);
			}
		} catch (Exception ex) {
			request.setAttribute("errors", "请正确输入入库信息");
			return mapping.findForward("errorpage");
		}
		VenditionPageNeedVO spnv = new VenditionPageNeedVO();
		spnv.setAddress("/JSP/VenditionSellMsgJsp.jsp");
		request.setAttribute("VenditionPageNeedVO", spnv);
		return mapping.findForward("qrydone");

	}

	public ActionForward creStockMsg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		List wareList = null;
		try {
			wareList = new VenditionWareDAO().queryMareMsg(null, null);
			if (wareList.size() == 0) {
				request.setAttribute("errors", "没有对应的商品信息");
				return mapping.findForward("errorpage");
			} else {
				request.setAttribute("wareList", wareList);
			}
		} catch (Exception ex) {
			request.setAttribute("errors", "没有对应的商品信息");
			return mapping.findForward("errorpage");
		}
		VenditionPageNeedVO spnv = new VenditionPageNeedVO();
		spnv.setAddress("/JSP/VenditionCreSellMsgJsp.jsp");
		request.setAttribute("VenditionPageNeedVO", spnv);
		return mapping.findForward("credone");

	}

	public ActionForward delStockMsg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// 直接反回;
		return mapping.findForward("backnow");

	}

	public ActionForward upStockMsg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// 直接反回;
		return mapping.findForward("backnow");

	}
}
