package vendition.message.util;

public class VenditionPageNeedUtil {
	public String addressMsg(String pageName) {
		String address = null;
		if (pageName.equals("��Ʒ������Ϣ")) {
			address = "/JSP/VenditionWareMsgJsp.jsp";
		}
		if (pageName.equals("��Ӧ�̻�����Ϣ")) {
			address = "/JSP/VenditionServeMsgJsp.jsp";
		}
		if (pageName.equals("�ͻ�������Ϣ")) {
			address = "/JSP/VenditionClientMsgJsp.jsp";
		}
		if (pageName.equals("��������")) {
			address = "/JSP/VenditionStockMsgJsp.jsp";
		}
		if (pageName.equals("���۹���")) {
			address = "/JSP/VenditionSellMsgJsp.jsp";
		}
		if (pageName.equals("������")) {
			address = "/JSP/VenditionRepertoryMsgJsp.jsp";
		}
		return address;
	}
}
