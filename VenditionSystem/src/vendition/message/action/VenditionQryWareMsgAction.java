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
		// ����ת��;
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
			request.setAttribute("errors", "��ѯ��Ʒ��Ϣʧ��");
			return mapping.findForward("errorpage");
		}
		List mareMsgList = null;
		try {
			mareMsgList = new VenditionWareDAO().queryMareMsg(stuId, stuSub);
			if (mareMsgList.size() == 0) {
				request.setAttribute("errors", "��ѯ��Ʒ��Ϣʧ��");
				return mapping.findForward("errorpage");
			} else {
				request.setAttribute("mareMsgList", mareMsgList);
			}
		} catch (Exception ex) {
			request.setAttribute("errors", "��ѯ��Ʒ��Ϣʧ��");
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
		// �õ�form;
		VenditionQryWareMsgForm mqpf = (VenditionQryWareMsgForm) form;
		// �������;
		String[] st = mqpf.getWareids();
		if (st == null && "".equals(st)) {
			request.setAttribute("errors", "����ѡ����ɾ��");
			return mapping.findForward("errorpage");
		}
		boolean whereflag = false;
		try { // ��ֵ����ҵ���߼������õ�����ֵ;
			whereflag = new VenditionWareDAO().removeWareMsg(st);
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

	public ActionForward upWareMsg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		// �õ�form;
		VenditionQryWareMsgForm mqef = (VenditionQryWareMsgForm) form;
		String st1 = null;
		st1 = new String(mqef.getWareid().getBytes("ISO-8859-1"), "GB2312");
		VenditionWareMsgVO mcvo = null;
		try {// ��ֵ����ҵ���߼������õ�����ֵ;
			mcvo = new VenditionWareDAO().queryOnlyMareMsg(st1);
			request.setAttribute("VenditionWareMsgVO", mcvo);
		} catch (DBException e) {
			request.setAttribute("errors", "������Ʒ��Ϣʧ��");
			return mapping.findForward("errorpage");
		}// ��ҳ���ַ����������;
		VenditionPageNeedVO spnv = new VenditionPageNeedVO();
		spnv.setAddress("/JSP/VenditionUpWareMsgJsp.jsp");
		request.setAttribute("VenditionPageNeedVO", spnv);
		return mapping.findForward("updone");

	}
}
