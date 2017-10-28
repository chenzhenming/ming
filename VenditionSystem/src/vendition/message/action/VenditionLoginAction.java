package vendition.message.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import vendition.message.dao.VenditionLoginDAO;
import vendition.message.form.VenditionLoginForm;
import vendition.message.util.VenditionZHCNChangeUtil;

public class VenditionLoginAction extends Action {
	// ��½action;
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// ����ת��;
		request.setCharacterEncoding("GB2312");
		VenditionLoginForm vf = (VenditionLoginForm) form;
		String userId = new VenditionZHCNChangeUtil()
				.ZHCNChange(vf.getUserId());
		String password = new VenditionZHCNChangeUtil().ZHCNChange(vf
				.getPassword());
		// �������;
		int count = 0;
		try {
			// ��ֵ����ҵ���߼������õ�����ֵ;
			count = new VenditionLoginDAO().queryUserMsg(userId, password);
			request.getSession().setAttribute("VenditionLoginForm", vf);
			// �жϷ���ֵ;
			if (count == 0) {
				// ��ֵ�Ļ�ת������ҳ��;
				request.setAttribute("errors", "�˹���Ա������");
				return mapping.findForward("errorpage");
			}// �쳣����
		} catch (Exception ex) {
			request.setAttribute("errors", "��ѯ����Ա��Ϣʧ��");
			return mapping.findForward("errorpage");
		}// ����;
		return mapping.findForward("done");
	}
}
