
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
    document.venditionQryClientMsgForm.method.value=methodValue;
    document.venditionQryClientMsgForm.submit();
  }
</script>
<body>
<html:form method="post" action="/venditionQryClientMsgAction"
	focus="serveidMsg">
	<input type="hidden" name="method" />
	<table border="0" bgcolor="#ffffff" width="77%" height="20%">
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td align="center"><font size="2">客户编号:</font></td>
			<td><html:text property="clientidMsg" /></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td align="right"><html:button onclick="submitting('qryClientMsg')"
				property="deleteMsg()">查询
			</html:button>&nbsp;<html:button onclick="submitting('creClientMsg')"
				property="deleteMsg()">添加
			</html:button>&nbsp;</td>
		</tr>
	</table>

	<logic:present name="clientList" scope="request">

		<table border="1" bgcolor="#ffffff" width="77%" height="80%">
			<th background="image/vback.jpg" height="20" width="7%"><font
				size="2">序号</font></th>
			<th background="image/vback.jpg" height="20" width="7%"><font
				size="2">选取</font></th>
			<th background="image/vback.jpg" height="20" width="15%"><font
				size="2">客户编号</font></th>
			<th background="image/vback.jpg" height="20"><font size="2">名称</font></th>
			<th background="image/vback.jpg" height="20"><font size="2">地址</font></th>
			<th background="image/vback.jpg" height="20"><font size="2">联系人</font></th>
			<th background="image/vback.jpg" height="20"><font size="2">电话</font></th>
			<th background="image/vback.jpg" height="20"><font size="2">银行</font></th>
			<th background="image/vback.jpg" height="20"><font size="2">卡号</font></th>
			<logic:iterate name="clientList" id="qmsg"
				type="vendition.message.vo.VenditionClientVO" length="15">
				<tr>
					<td height="15" align="center"><bean:write name="qmsg"
						property="mark" /></td>
					<td height="15" align="center"><font size="2"> <html:checkbox
						property="clientids" value="${qmsg.clientid}" /> </font></td>
					<td height="15" align="center"><font size="2"> <html:link
						action="/venditionQryClientMsgAction.do?method=upClientMsg&&clientid=${qmsg.clientid}">
						<bean:write name="qmsg" property="clientid" />
					</html:link></font></td>
					<td height="15" align="center"><font size="2"> <bean:write
						name="qmsg" property="clientname" /> </font></td>
					<td height="15" align="center"><font size="2"> <bean:write
						name="qmsg" property="address" /> </font></td>
					<td height="15" align="center"><font size="2"> <bean:write
						name="qmsg" property="linkman" /> </font></td>
					<td height="15" align="center"><font size="2"> <bean:write
						name="qmsg" property="phone" /> </font></td>
					<td height="15" align="center"><font size="2"> <bean:write
						name="qmsg" property="bank" /> </font></td>
					<td height="15" align="center"><font size="2"> <bean:write
						name="qmsg" property="accounts" /> </font></td>
				</tr>
			</logic:iterate>
			<tr>
				<td align="right" Colspan="11" valign="bottom"><html:button
					onclick="submitting('delClientMsg')" property="deleteMsg()">删除</html:button>&nbsp;</td>
			</tr>
		</table>

	</logic:present>
</html:form>
</body>
</html:html>
