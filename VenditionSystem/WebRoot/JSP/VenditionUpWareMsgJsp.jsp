
<%@ page language="java" pageEncoding="GB2312" isELIgnored="false"%>

<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"
	prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"
	prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic"
	prefix="logic"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html locale="true">
<head>
<script language="javascript" type="text/javascript">
  function submitting(methodValue){
    document.venditionUpWareMsgForm.method.value=methodValue;
    document.venditionUpWareMsgForm.submit();
  }
</script>
</head>

<body>
<html:form action="/venditionUpWareMsgAction" method="post"
	focus="wareid">
	<input type="hidden" name="method" />
	<table border="0" width="77%" height="100%" bgcolor="#ffffff">
		<tr>
			<td width="17%" height="10">&nbsp;</td>
			<td width="17%" height="10">&nbsp;</td>
		</tr>
		<tr>
			<td width="17%" height="25"><font size="2">商品编号:</font></td>
			<td width="50%" height="25"><html:text property="wareid"
				value="${VenditionWareMsgVO.wareid}" readonly="true" /></td>
		</tr>
		<tr>
			<td width="17%" height="25"><font size="2">商品名称:</font></td>
			<td width="50%" height="25"><html:text property="warename"
				value="${VenditionWareMsgVO.warename}" /></td>
		</tr>
		<tr>
			<td width="17%" height="25"><font size="2">规格:</font></td>
			<td width="50%" height="25"><html:text property="standard"
				value="${VenditionWareMsgVO.standard}" /></td>
		</tr>
		<tr>
			<td width="17%" height="25"><font size="2">单位</font></td>
			<td width="50%" height="25"><html:text property="unit"
				value="${VenditionWareMsgVO.unit}" /></td>
		</tr>
		<tr>
			<td width="17%" height="25"><font size="2">单价(/元)</font></td>
			<td width="50%" height="25"><html:text property="rate"
				value="${VenditionWareMsgVO.rate}" /></td>
		</tr>
		<tr>
			<td width="17%" height="25"><font size="2"></font></td>
			<td width="50%" height="25"></td>
		</tr>
		<tr>
			<td width="17%" height="25"><font size="2"></font></td>
			<td width="50%" height="25"></td>
		</tr>
		<tr>
			<td width="17%" height="25"><font size="2"></font></td>
			<td width="50%" height="25"></td>
		</tr>

		<tr>
			<td colspan="2" align="right" height="30%" valign="bottom"><html:button
				onclick="submitting('venditionUpWareMsg')" property="deleteMsg()">确定
			</html:button>&nbsp;<html:button onclick="submitting('backfun')"
				property="deleteMsg()">返回
			</html:button>&nbsp;</td>
		</tr>
	</table>
</html:form>
</body>
</html:html>
