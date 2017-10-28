
<%@ page language="java" pageEncoding="GB2312" isELIgnored="false"%>

<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"
	prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"
	prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic"
	prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html locale="true">
<head>
<script language="javascript" type="text/javascript">
  function submitting(methodValue){
    document.venditionQryStockMsgForm.method.value=methodValue;
    document.venditionQryStockMsgForm.submit();
  }
</script>
<body>
<html:form method="post" action="/venditionQryStockMsgAction"
	focus="wareidMsg">
	<input type="hidden" name="method" />
	<table border="0" bgcolor="#ffffff" width="77%" height="20%">
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td align="center"><font size="2">��Ʒ���:</font></td>
			<td><html:text property="wareidMsg" /></td>
			<td></td>
		</tr>
		<tr>
			<td align="center"><font size="2">��Ʒ����:</font></td>
			<td><html:text property="warenameMsg" /></td>
			<td></td>
		</tr>
		<tr>
			<td align="center"><font size="2">��������:</font></td>
			<td><html:text property="stockdateYear" size="4" /><font size="2">��</font>&nbsp;<html:text
				property="stockdateMon" size="2" /><font size="2">��</font>&nbsp;<html:text
				property="stockdateDay" size="2" /><font size="2">��</font></td>
			<td><font size="2">����:19xx��xx��xx�£�</font></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td align="right"><html:button onclick="submitting('qryStockMsg')"
				property="deleteMsg()">��ѯ
			</html:button>&nbsp;<html:button onclick="submitting('creStockMsg')"
				property="deleteMsg()">���
			</html:button>&nbsp;</td>
		</tr>
	</table>

	<logic:present name="stockList" scope="request">

		<table border="1" bgcolor="#ffffff" width="77%" height="76%">
			<th background="image/vback.jpg" height="20"><font size="2">��������</font></th>
			<th background="image/vback.jpg" height="20"><font size="2">��Ʒ���</font></th>
			<th background="image/vback.jpg" height="20"><font size="2">��Ʒ����</font></th>
			<th background="image/vback.jpg" height="20"><font size="2">���</font></th>
			<th background="image/vback.jpg" height="20"><font size="2">��λ</font></th>
			<th background="image/vback.jpg" height="20"><font size="2">����</font></th>
			<th background="image/vback.jpg" height="20"><font size="2">��������</font></th>
			<th background="image/vback.jpg" height="20"><font size="2">��������</font></th>
			<th background="image/vback.jpg" height="20"><font size="2">���ϼ�</font></th>
			<th background="image/vback.jpg" height="20"><font size="2">����Ա</font></th>
			<logic:iterate name="stockList" id="qmsg"
				type="vendition.message.vo.venditionStockVO" length="15">
				<tr>
					<td height="15" align="center"><font size="2"> <html:link
						action="/venditionQryStockMsgAction.do?method=upStockMsg&&stockid=${qmsg.stockid}">
						<bean:write name="qmsg" property="stockid" />
					</html:link></font></td>
					<td height="15" align="center"><font size="2"> <bean:write
						name="qmsg" property="wareid" /> </font></td>
					<td height="15" align="center"><font size="2"> <bean:write
						name="qmsg" property="warename" /> </font></td>
					<td height="15" align="center"><font size="2"> <bean:write
						name="qmsg" property="standard" /> </font></td>
					<td height="15" align="center"><font size="2"> <bean:write
						name="qmsg" property="unit" /> </font></td>
					<td height="15" align="center"><font size="2"> <bean:write
						name="qmsg" property="rate" /> </font></td>
					<td height="15" align="center"><font size="2"> <bean:write
						name="qmsg" property="stockdate" /> </font></td>
					<td height="15" align="center"><font size="2"> <bean:write
						name="qmsg" property="stockamount" /> </font></td>
					<td height="15" align="center"><font size="2"> <bean:write
						name="qmsg" property="moneysum" /> </font></td>
					<td height="15" align="center"><font size="2"> <bean:write
						name="qmsg" property="operator" /> </font></td>
				</tr>
			</logic:iterate>
			<tr>
				<td align="right" Colspan="11" valign="bottom">&nbsp;</td>
			</tr>
		</table>

	</logic:present>
</html:form>
</body>
</html:html>
