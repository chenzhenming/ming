
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
    document.venditionQryWareMsgForm.method.value=methodValue;
    document.venditionQryWareMsgForm.submit();
  }
</script>
<body>
<html:form method="post" action="/venditionQryWareMsgAction"
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
			<td></td>
			<td></td>
			<td align="right"><html:button onclick="submitting('qryWareMsg')"
				property="deleteMsg()">��ѯ
			</html:button>&nbsp;<html:button onclick="submitting('creWareMsg')"
				property="deleteMsg()">���
			</html:button>&nbsp;</td>
		</tr>
	</table>

	<logic:present name="mareMsgList" scope="request">

		<table border="1" bgcolor="#ffffff" width="77%" height="80%">
			<th background="image/vback.jpg" height="20" width="7%"><font
				size="2">���</font></th>
			<th background="image/vback.jpg" height="20" width="7%"><font
				size="2">ѡȡ</font></th>
			<th background="image/vback.jpg" height="20" width="16%"><font
				size="2">��Ʒ���</font></th>
			<th background="image/vback.jpg" height="20" width="16%"><font
				size="2">��Ʒ����</font></th>
			<th background="image/vback.jpg" height="20" width="16%"><font
				size="2">���</font></th>
			<th background="image/vback.jpg" height="20" width="16%"><font
				size="2">��λ</font></th>
			<th background="image/vback.jpg" height="20" width="16%"><font
				size="2">����(/Ԫ)</font></th>
			<logic:iterate name="mareMsgList" id="qmsg"
				type="vendition.message.vo.VenditionWareMsgVO" length="15">
				<tr>
					<td height="15" align="center"><bean:write name="qmsg"
						property="mark" /></td>
					<td height="15" align="center"><font size="2"> <html:checkbox
						property="wareids" value="${qmsg.wareid}" /> </font></td>
					<td height="15" align="center"><font size="2"> <html:link
						action="/venditionQryWareMsgAction.do?method=upWareMsg&&wareid=${qmsg.wareid}">
						<bean:write name="qmsg" property="wareid" />
					</html:link></font></td>
					<td height="15" align="center"><font size="2"> <bean:write
						name="qmsg" property="warename" /> </font></td>
					<td height="15" align="center"><font size="2"> <bean:write
						name="qmsg" property="standard" /> </font></td>
					<td height="15" align="center"><font size="2"> <bean:write
						name="qmsg" property="unit" /> </font></td>
					<td height="15" align="center"><font size="2"> <bean:write
						name="qmsg" property="rate" /> </font></td>
				</tr>
			</logic:iterate>
			<tr>
				<td align="right" Colspan="11" valign="bottom"><html:button
					onclick="submitting('delWareMsg')" property="deleteMsg()">ɾ��</html:button>&nbsp;</td>
			</tr>
		</table>

	</logic:present>
</html:form>
</body>
</html:html>
