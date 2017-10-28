
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
    document.venditionCreServeMsgForm.method.value=methodValue;
    document.venditionCreServeMsgForm.submit();
  }
</script>
</head>

<body>
<html:form action="/venditionCreServeMsgAction" method="post"
	focus="serveid">
	<input type="hidden" name="method" />
	<table border="0" width="77%" height="100%" bgcolor="#ffffff">
		<tr>
			<td width="17%" height="10">&nbsp;</td>
			<td width="17%" height="10">&nbsp;</td>
		</tr>
		<tr>
			<td width="17%" height="25"><font size="2">供应商编号:</font></td>
			<td width="50%" height="25"><html:text property="serveid" /></td>
		</tr>
		<tr>
			<td width="17%" height="25"><font size="2">名称:</font></td>
			<td width="50%" height="25"><html:text property="servename" /></td>
		</tr>
		<tr>
			<td width="17%" height="25"><font size="2">地址:</font></td>
			<td width="50%" height="25"><html:text property="address" /></td>
		</tr>
		<tr>
			<td width="17%" height="25"><font size="2">联系人</font></td>
			<td width="50%" height="25"><html:text property="linkman" /></td>
		</tr>
		<tr>
			<td width="17%" height="25"><font size="2">电话</font></td>
			<td width="50%" height="25"><html:text property="phone" /></td>
		</tr>
		<tr>
			<td width="17%" height="25"><font size="2">银行</font></td>
			<td width="50%" height="25"><html:text property="bank" /></td>
		</tr>
		<tr>
			<td width="17%" height="25"><font size="2">卡号</font></td>
			<td width="50%" height="25"><html:text property="accounts" /></td>
		</tr>
		<tr>
			<td width="17%" height="25"><font size="2"></font></td>
			<td width="50%" height="25"></td>
		</tr>

		<tr>
			<td colspan="2" align="right" height="30%" valign="bottom"><html:button
				onclick="submitting('venditionCreServeMsg')" property="deleteMsg()">确定
			</html:button>&nbsp;<html:button onclick="submitting('backfun')"
				property="deleteMsg()">返回
			</html:button>&nbsp;</td>
		</tr>
	</table>
</html:form>
</body>
</html:html>
