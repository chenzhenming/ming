
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
    document.venditionCreWareMsgForm.method.value=methodValue;
    document.venditionCreWareMsgForm.submit();
  }
</script>
</head>

<body>
<html:form action="/venditionCreWareMsgAction" method="post"
	focus="wareid">
	<input type="hidden" name="method" />
	<table border="0" width="77%" height="100%" bgcolor="#ffffff">
		<tr>
			<td width="17%" height="10">&nbsp;</td>
			<td width="17%" height="10">&nbsp;</td>
		</tr>
		<tr>
			<td width="17%" height="25"><font size="2">��Ʒ���:</font></td>
			<td width="50%" height="25"><html:text property="wareid" /></td>
		</tr>
		<tr>
			<td width="17%" height="25"><font size="2">��Ʒ����:</font></td>
			<td width="50%" height="25"><html:text property="warename" /></td>
		</tr>
		<tr>
			<td width="17%" height="25"><font size="2">���:</font></td>
			<td width="50%" height="25"><html:text property="standard" /></td>
		</tr>
		<tr>
			<td width="17%" height="25"><font size="2">��λ</font></td>
			<td width="50%" height="25"><html:text property="unit" /></td>
		</tr>
		<tr>
			<td width="17%" height="25"><font size="2">����(/Ԫ)</font></td>
			<td width="50%" height="25"><html:text property="rate" /></td>
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
				onclick="submitting('venditionCreWareMsg')" property="deleteMsg()">ȷ��
			</html:button>&nbsp;<html:button onclick="submitting('backfun')"
				property="deleteMsg()">����
			</html:button>&nbsp;</td>
		</tr>
	</table>
</html:form>
</body>
</html:html>
