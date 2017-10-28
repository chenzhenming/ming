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
import vendition.message.dao.VenditionStockDAO;
import vendition.message.dao.VenditionWareDAO;
import vendition.message.dao.venditionRepertoryDAO;
import vendition.message.form.VenditionCreServeMsgForm;
import vendition.message.form.VenditionCreStockMsgForm;
import vendition.message.form.VenditionLoginForm;
import vendition.message.util.VenditionZHCNChangeUtil;
import vendition.message.vo.VenditionCreStockVO;
import vendition.message.vo.VenditionPageNeedVO;
import vendition.message.vo.VenditionServeVO;
import vendition.message.vo.VenditionStockMoneyVO;
import vendition.message.vo.VenditionWareMsgVO;
import vendition.message.vo.venditionStockVO;

public class VenditionCreStockMsgAction extends DispatchAction {
	public ActionForward venditionCreStockMsg(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		// 编码转换;
		request.setCharacterEncoding("GB2312");
		VenditionCreStockMsgForm vcsf = (VenditionCreStockMsgForm) form;
		VenditionCreStockVO sumv = new VenditionCreStockVO();
		sumv.setWareid(new VenditionZHCNChangeUtil().ZHCNChange(vcsf
				.getWarename()));
		sumv.setStockdate(new VenditionZHCNChangeUtil().ZHCNChange(vcsf
				.getStockdateYear()
				+ "-" + vcsf.getStockdateMon() + "-" + vcsf.getStockdateDay()));
		VenditionLoginForm vlfm = (VenditionLoginForm) request.getSession()
				.getAttribute("VenditionLoginForm");
		sumv.setOperator(vlfm.getUserId());
		sumv.setMoneysum(vcsf.getMoneysum());
		sumv.setStockamount(vcsf.getStockamount());
		int count = 0;
		int sum = 0;
		int max = 0;
		try {
			List stockList = new VenditionStockDAO().querystockidMsg();
			venditionStockVO ev = (venditionStockVO) stockList.get(0);
			max = new Integer(ev.getStockid()).parseInt(ev.getStockid());
			for (int i = 0; i < stockList.size(); i++) {
				venditionStockVO evs = (venditionStockVO) stockList.get(i);
				sum = new Integer(evs.getStockid()).parseInt(evs.getStockid());
				if (max < sum) {
					max = sum;
				}
			}
			sumv.setStockid(max + 1);
			count = new VenditionStockDAO().createStockMsg(sumv);
			if (count == 0) {
				request.setAttribute("errors", "添加进货信息失败");
				return mapping.findForward("errorpage");
			}

		} catch (Exception ex) {
			request.setAttribute("errors", "添加进货信息失败");
			return mapping.findForward("errorpage");
		}
		VenditionWareMsgVO vmmv = null;
		try {
			vmmv = new VenditionWareDAO().queryOnlyMareMsg(vcsf.getWarename());
			int cou = new venditionRepertoryDAO().queryReperCouMsg(vcsf
					.getWarename());
			if (cou == 0) {
				int sumy = new venditionRepertoryDAO().createReperMsg(vmmv,
						vcsf.getStockamount());
			} else {
				String stage = new venditionRepertoryDAO()
						.queryReperCouMsgss(vcsf.getWarename());
				int allsum = vcsf.getStockamount()
						+ new Integer(stage).parseInt(stage);
				boolean whereflag = false;
				whereflag = new venditionRepertoryDAO()
						.upStockMsg(vmmv, allsum);
				if (whereflag == false) {
					request.setAttribute("errors", "添加进货信息失败");
					return mapping.findForward("errorpage");
				}
			}
		} catch (Exception ex) {
			request.setAttribute("errors", "添加进货信息失败");
			return mapping.findForward("errorpage");
		}
		return mapping.findForward("credone");
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
		VenditionPageNeedVO spnv = new VenditionPageNeedVO();
		spnv.setAddress("/JSP/VenditionCreStockMsgJsp.jsp");
		request.setAttribute("VenditionPageNeedVO", spnv);
		return mapping.findForward("changenow");

	}

	public ActionForward stockMoneyMsg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		// 编码转换;
		request.setCharacterEncoding("GB2312");
		VenditionCreStockMsgForm vcsf = (VenditionCreStockMsgForm) form;
		int aw = vcsf.getRate();
		int te = vcsf.getStockamount();
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
