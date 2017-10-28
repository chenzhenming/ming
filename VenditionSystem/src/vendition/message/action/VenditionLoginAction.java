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
	// 登陆action;
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 编码转换;
		request.setCharacterEncoding("GB2312");
		VenditionLoginForm vf = (VenditionLoginForm) form;
		String userId = new VenditionZHCNChangeUtil()
				.ZHCNChange(vf.getUserId());
		String password = new VenditionZHCNChangeUtil().ZHCNChange(vf
				.getPassword());
		// 定义变量;
		int count = 0;
		try {
			// 把值传到业务逻辑处理并得到返回值;
			count = new VenditionLoginDAO().queryUserMsg(userId, password);
			request.getSession().setAttribute("VenditionLoginForm", vf);
			// 判断反回值;
			if (count == 0) {
				// 无值的话转到错误页面;
				request.setAttribute("errors", "此管理员不存在");
				return mapping.findForward("errorpage");
			}// 异常处理
		} catch (Exception ex) {
			request.setAttribute("errors", "查询管理员信息失败");
			return mapping.findForward("errorpage");
		}// 返回;
		return mapping.findForward("done");
	}
}
