
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
<body>
<html:form method="post" action="/venditionQryReperAction"
	focus="wareidMsg">
	<table border="0" bgcolor="#ffffff" width="77%" height="20%">
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td align="center"><font size="2">商品编号:</font></td>
			<td><html:text property="wareidMsg" /></td>
			<td></td>
		</tr>
		<tr>
			<td align="center"><font size="2">商品名称:</font></td>
			<td><html:text property="warenameMsg" /></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td align="right"><html:submit>查询</html:submit>&nbsp;</td>
		</tr>
	</table>

	<logic:present name="reperList" scope="request">

		<table border="1" bgcolor="#ffffff" width="77%" height="80%">
			<th background="image/vback.jpg" height="20" width="7%"><font
				size="2">序号</font></th>
			<th background="image/vback.jpg" height="20" width="16%"><font
				size="2">商品编号</font></th>
			<th background="image/vback.jpg" height="20" width="16%"><font
				size="2">商品名称</font></th>
			<th background="image/vback.jpg" height="20" width="16%"><font
				size="2">单位</font></th>
			<th background="image/vback.jpg" height="20" width="16%"><font
				size="2">单价(/元)</font></th>
			<th background="image/vback.jpg" height="20" width="16%"><font
				size="2">库存量</font></th>
			<logic:iterate name="reperList" id="qmsg"
				type="vendition.message.vo.VenditionRepertoryVO" length="15">
				<tr>
					<td height="15" align="center"><bean:write name="qmsg"
						property="mark" /></td>
					<td height="15" align="center"><font size="2"> <bean:write
						name="qmsg" property="wareid" /> </font></td>
					<td height="15" align="center"><font size="2"> <bean:write
						name="qmsg" property="warename" /> </font></td>
					<td height="15" align="center"><font size="2"> <bean:write
						name="qmsg" property="unit" /> </font></td>
					<td height="15" align="center"><font size="2"> <bean:write
						name="qmsg" property="rate" /> </font></td>
					<td height="15" align="center"><font size="2"> <bean:write
						name="qmsg" property="storage" /> </font></td>
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
