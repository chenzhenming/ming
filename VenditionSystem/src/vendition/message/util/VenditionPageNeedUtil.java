package vendition.message.util;

public class VenditionPageNeedUtil {
	public String addressMsg(String pageName) {
		String address = null;
		if (pageName.equals("商品基本信息")) {
			address = "/JSP/VenditionWareMsgJsp.jsp";
		}
		if (pageName.equals("供应商基本信息")) {
			address = "/JSP/VenditionServeMsgJsp.jsp";
		}
		if (pageName.equals("客户基本信息")) {
			address = "/JSP/VenditionClientMsgJsp.jsp";
		}
		if (pageName.equals("进货管理")) {
			address = "/JSP/VenditionStockMsgJsp.jsp";
		}
		if (pageName.equals("销售管理")) {
			address = "/JSP/VenditionSellMsgJsp.jsp";
		}
		if (pageName.equals("库存管理")) {
			address = "/JSP/VenditionRepertoryMsgJsp.jsp";
		}
		return address;
	}
}
