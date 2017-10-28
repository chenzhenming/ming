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
		// ����ת��;
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
			request.setAttribute("errors", "��ѯ�ͻ���Ϣʧ��");
			return mapping.findForward("errorpage");
		}
		List clientList = null;
		try {
			clientList = new VenditionClientDAO().queryClientMsg(stuId);
			if (clientList.size() == 0) {
				request.setAttribute("errors", "��ѯ�ͻ���Ϣʧ��");
				return mapping.findForward("errorpage");
			} else {
				request.setAttribute("clientList", clientList);
			}
		} catch (Exception ex) {
			request.setAttribute("errors", "��ѯ�ͻ���Ϣʧ��");
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
		// �õ�form;
		VenditionQryClientMsgForm mqpf = (VenditionQryClientMsgForm) form;
		// �������;
		String[] st = mqpf.getClientids();
		if (st == null && "".equals(st)) {
			request.setAttribute("errors", "����ѡ����ɾ��");
			return mapping.findForward("errorpage");
		}
		boolean whereflag = false;
		try { // ��ֵ����ҵ���߼������õ�����ֵ;
			whereflag = new VenditionClientDAO().removeClientMsg(st);
			// �жϷ���ֵ;
			if (whereflag = false) {
				// ��ֵ�Ļ�ת������ҳ��;
				request.setAttribute("errors", "ɾ��ʧ��");
				return mapping.findForward("errorpage");
			}// �쳣����
		} catch (Exception ex) {
			request.setAttribute("errors", "ɾ������ʧ��");
			return mapping.findForward("errorpage");
		}
		return mapping.findForward("deldone");

	}

	public ActionForward upClientMsg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		// �õ�form;
		VenditionQryClientMsgForm mqef = (VenditionQryClientMsgForm) form;
		String st1 = null;
		st1 = new String(mqef.getClientid().getBytes("ISO-8859-1"), "GB2312");
		VenditionClientVO mcvo = null;
		try {// ��ֵ����ҵ���߼������õ�����ֵ;
			mcvo = new VenditionClientDAO().queryOnlyClientMsg(st1);
			request.setAttribute("VenditionClientVO", mcvo);
		} catch (DBException e) {
			request.setAttribute("errors", "���¹�Ӧ����Ϣʧ��");
			return mapping.findForward("errorpage");
		}// ��ҳ���ַ����������;
		VenditionPageNeedVO spnv = new VenditionPageNeedVO();
		spnv.setAddress("/JSP/VenditionUpClientMsgJsp.jsp");
		request.setAttribute("VenditionPageNeedVO", spnv);
		return mapping.findForward("updone");
	}
	public ActionForward changeStockMsg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		// ����ת��;
		request.setCharacterEncoding("GB2312");
		VenditionCreStockMsgForm vcsf = (VenditionCreStockMsgForm) form;
		String someid = new VenditionZHCNChangeUtil().ZHCNChange(vcsf
				.getWarename());
		VenditionWareMsgVO vmvo = null;
		try {
			vmvo = new VenditionWareDAO().queryOnlyMareMsg(someid);
			if (vmvo == null) {
				request.setAttribute("errors", "û�ж�Ӧ����Ʒ��Ϣ");
				return mapping.findForward("errorpage");
			} else {
				request.setAttribute("VenditionWareMsgVO", vmvo);
			}
		} catch (Exception ex) {
			request.setAttribute("errors", "û�ж�Ӧ����Ʒ��Ϣ");
			return mapping.findForward("errorpage");
		}
		return mapping.findForward("changenow");

	}
}
