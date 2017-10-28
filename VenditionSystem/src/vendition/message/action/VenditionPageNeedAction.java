package vendition.message.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import vendition.message.dao.VenditionClientDAO;
import vendition.message.dao.VenditionSellDAO;
import vendition.message.dao.VenditionServeDAO;
import vendition.message.dao.VenditionStockDAO;
import vendition.message.dao.VenditionWareDAO;
import vendition.message.dao.venditionRepertoryDAO;
import vendition.message.form.VenditionPageNeedForm;
import vendition.message.util.VenditionPageNeedUtil;
import vendition.message.util.VenditionZHCNChangeUtil;
import vendition.message.vo.VenditionPageNeedVO;

public class VenditionPageNeedAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 编码转换;
		request.setCharacterEncoding("GB2312");
		VenditionPageNeedForm spnf = (VenditionPageNeedForm) form;
		String pageName = new VenditionZHCNChangeUtil().ZHCNChange(spnf
				.getPageName());
		VenditionPageNeedVO spnv = new VenditionPageNeedVO();
		spnv.setAddress(new VenditionPageNeedUtil().addressMsg(pageName));
		request.setAttribute("VenditionPageNeedVO", spnv);
		if (pageName.equals("商品基本信息")) {
			List mareMsgList = null;
			try {
				mareMsgList = new VenditionWareDAO().queryMareMsg(null, null);
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
		}
		if (pageName.equals("供应商基本信息")) {
			List serveList = null;
			try {
				serveList = new VenditionServeDAO().queryServeMsg(null);
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
		}
		if (pageName.equals("客户基本信息")) {
			List clientList = null;
			try {
				clientList = new VenditionClientDAO().queryClientMsg(null);
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
		}
		if (pageName.equals("进货管理")) {
			List stockList = null;
			try {
				stockList = new VenditionStockDAO().queryStockMsg(null, null,
						null);
				if (stockList.size() == 0) {
					request.setAttribute("errors", "查询入库信息失败");
					return mapping.findForward("errorpage");
				} else {
					request.setAttribute("stockList", stockList);
				}
			} catch (Exception ex) {
				request.setAttribute("errors", "查询入库信息失败");
				return mapping.findForward("errorpage");
			}
		}
		if (pageName.equals("销售管理")) {
			List stockList = null;
			try {
				stockList = new VenditionSellDAO().queryStockMsg(null, null,
						null);
				if (stockList.size() == 0) {
					request.setAttribute("errors", "查询出库信息失败");
					return mapping.findForward("errorpage");
				} else {
					request.setAttribute("stockList", stockList);
				}
			} catch (Exception ex) {
				request.setAttribute("errors", "查询出库信息失败");
				return mapping.findForward("errorpage");
			}
		}
		if (pageName.equals("库存管理")) {
			List reperList = null;
			try {
				reperList = new venditionRepertoryDAO().queryReperMsg(null,
						null);
				if (reperList.size() == 0) {
					request.setAttribute("errors", "查询库存信息失败");
					return mapping.findForward("errorpage");
				} else {
					request.setAttribute("reperList", reperList);
				}
			} catch (Exception ex) {
				request.setAttribute("errors", "查询库存信息失败");
				return mapping.findForward("errorpage");
			}
		}
		return mapping.findForward("chdone");
	}
}
