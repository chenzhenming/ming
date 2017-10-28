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
		// ����ת��;
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
			request.setAttribute("errors", "��ѯ��Ӧ����Ϣʧ��");
			return mapping.findForward("errorpage");
		}
		List serveList = null;
		try {
			serveList = new VenditionServeDAO().queryServeMsg(stuId);
			if (serveList.size() == 0) {
				request.setAttribute("errors", "��ѯ��Ӧ����Ϣʧ��");
				return mapping.findForward("errorpage");
			} else {
				request.setAttribute("serveList", serveList);
			}
		} catch (Exception ex) {
			request.setAttribute("errors", "��ѯ��Ӧ����Ϣʧ��");
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
		// �õ�form;
		VenditionQryServeMsgForm mqpf = (VenditionQryServeMsgForm) form;
		// �������;
		String[] st = mqpf.getServeids();
		if (st == null && "".equals(st)) {
			request.setAttribute("errors", "����ѡ����ɾ��");
			return mapping.findForward("errorpage");
		}
		boolean whereflag = false;
		try { // ��ֵ����ҵ���߼������õ�����ֵ;
			whereflag = new VenditionServeDAO().removeServeMsg(st);
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

	public ActionForward upServeMsg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		// �õ�form;
		VenditionQryServeMsgForm mqef = (VenditionQryServeMsgForm) form;
		String st1 = null;
		st1 = new String(mqef.getServeid().getBytes("ISO-8859-1"), "GB2312");
		VenditionServeVO mcvo = null;
		try {// ��ֵ����ҵ���߼������õ�����ֵ;
			mcvo = new VenditionServeDAO().queryOnlyServeMsg(st1);
			request.setAttribute("VenditionServeVO", mcvo);
		} catch (DBException e) {
			request.setAttribute("errors", "���¹�Ӧ����Ϣʧ��");
			return mapping.findForward("errorpage");
		}// ��ҳ���ַ����������;
		VenditionPageNeedVO spnv = new VenditionPageNeedVO();
		spnv.setAddress("/JSP/VenditionUpServeMsgJsp.jsp");
		request.setAttribute("VenditionPageNeedVO", spnv);
		return mapping.findForward("updone");
	}
}
