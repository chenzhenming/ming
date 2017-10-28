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
import vendition.message.dao.venditionRepertoryDAO;
import vendition.message.form.VenditionCreSellMsgForm;
import vendition.message.form.VenditionCreStockMsgForm;
import vendition.message.form.VenditionLoginForm;
import vendition.message.util.VenditionZHCNChangeUtil;
import vendition.message.vo.VenditionCreSellVO;
import vendition.message.vo.VenditionCreStockVO;
import vendition.message.vo.VenditionPageNeedVO;
import vendition.message.vo.VenditionSellVO;
import vendition.message.vo.VenditionStockMoneyVO;
import vendition.message.vo.VenditionWareMsgVO;
import vendition.message.vo.venditionStockVO;

public class VenditionCreSellMsgAction extends DispatchAction {
	public ActionForward venditionCreStockMsg(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		// 编码转换;
		request.setCharacterEncoding("GB2312");
		VenditionCreSellMsgForm vcsf = (VenditionCreSellMsgForm) form;
		VenditionCreSellVO sumv = new VenditionCreSellVO();
		sumv.setWareid(new VenditionZHCNChangeUtil().ZHCNChange(vcsf
				.getWarename()));
		sumv.setSelldate(new VenditionZHCNChangeUtil().ZHCNChange(vcsf
				.getSelldateYear()
				+ "-" + vcsf.getSelldateMon() + "-" + vcsf.getSelldateDay()));
		VenditionLoginForm vlfm = (VenditionLoginForm) request.getSession()
				.getAttribute("VenditionLoginForm");
		sumv.setOperator(vlfm.getUserId());
		sumv.setMoneysum(vcsf.getMoneysum());
		sumv.setSellamount(vcsf.getSellamount());
		int count = 0;
		int sum = 0;
		int max = 0;
		try {
			List stockList = new VenditionSellDAO().querystockidMsg();
			VenditionSellVO ev = (VenditionSellVO) stockList.get(0);
			max = new Integer(ev.getSellid()).parseInt(ev.getSellid());
			for (int i = 0; i < stockList.size(); i++) {
				VenditionSellVO evs = (VenditionSellVO) stockList.get(i);
				sum = new Integer(evs.getSellid()).parseInt(evs.getSellid());
				if (max < sum) {
					max = sum;
				}
			}
			sumv.setSellid(max + 1);
			String stage = new venditionRepertoryDAO().queryReperCouMsgss(vcsf
					.getWarename());
			int allsum = new Integer(stage).parseInt(stage)
					- vcsf.getSellamount();
			if (allsum < 0) {
				request.setAttribute("errors", "没有足够的货物信息");
				return mapping.findForward("errorpage");
			}
			count = new VenditionSellDAO().createStockMsg(sumv);
			if (count == 0) {
				request.setAttribute("errors", "添加出货信息失败");
				return mapping.findForward("errorpage");
			}

		} catch (Exception ex) {
			request.setAttribute("errors", "添加出货信息失败");
			return mapping.findForward("errorpage");
		}
		VenditionWareMsgVO vmmv = null;
		try {
			vmmv = new VenditionWareDAO().queryOnlyMareMsg(vcsf.getWarename());
			int cou = new venditionRepertoryDAO().queryReperCouMsg(vcsf
					.getWarename());
			if (cou == 0) {
				int sumy = new venditionRepertoryDAO().createReperMsg(vmmv,
						vcsf.getSellamount());
			} else {
				String stage = new venditionRepertoryDAO()
						.queryReperCouMsgss(vcsf.getWarename());
				int allsum = new Integer(stage).parseInt(stage)
						- vcsf.getSellamount();
				if (allsum < 0) {
					request.setAttribute("errors", "没有足够的货物信息");
					return mapping.findForward("errorpage");
				}
				boolean whereflag = false;
				whereflag = new venditionRepertoryDAO()
						.upStockMsg(vmmv, allsum);
				if (whereflag == false) {
					request.setAttribute("errors", "添加出货信息失败");
					return mapping.findForward("errorpage");
				}
			}
		} catch (Exception ex) {
			request.setAttribute("errors", "添加出货信息失败");
			return mapping.findForward("errorpage");
		}
		return mapping.findForward("credone");
	}

	public ActionForward changeStockMsg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		// 编码转换;
		request.setCharacterEncoding("GB2312");
		VenditionCreSellMsgForm vcsf = (VenditionCreSellMsgForm) form;
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
		VenditionPageNeedVO spnv = new VenditionPageNeedVO();
		spnv.setAddress("/JSP/VenditionCreSellMsgJsp.jsp");
		request.setAttribute("VenditionPageNeedVO", spnv);
		return mapping.findForward("changenow");

	}

	public ActionForward stockMoneyMsg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		// 编码转换;
		request.setCharacterEncoding("GB2312");
		VenditionCreSellMsgForm vcsf = (VenditionCreSellMsgForm) form;
		int aw = vcsf.getRate();
		int te = vcsf.getSellamount();
		int sdff = aw * te;
		VenditionStockMoneyVO vmvo = new VenditionStockMoneyVO();
		vmvo.setSomeMoney(sdff);
		request.setAttribute("VenditionStockMoneyVO", vmvo);
		return mapping.findForward("sumnow");

	}

	public ActionForward backfun(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// 直接反回;
		return mapping.findForward("backnow");

	}
}
