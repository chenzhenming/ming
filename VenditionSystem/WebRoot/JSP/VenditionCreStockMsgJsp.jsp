
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
    document.venditionCreStockMsgForm.method.value=methodValue;
    document.venditionCreStockMsgForm.submit();
  }
</script>
</head>

<body>
<html:form action="/venditionCreStockMsgAction" method="post"
	focus="wareid">
	<input type="hidden" name="method" />
	<table border="0" width="77%" height="100%" bgcolor="#ffffff">
		<tr>
			<td width="17%" height="10">&nbsp;</td>
			<td width="17%" height="10">&nbsp;</td>
		</tr>
		<tr>
			<td width="17%" height="25"><font size="2">商品名称:</font></td>
			<td width="50%" height="25"><logic:present name="wareList"
				scope="request">
				<html:select property="warename" style="height:18"
					onchange="submitting('changeStockMsg')">
					<html:option value=" ">请选择</html:option>
					<logic:iterate name="wareList" id="qmsg"
						type="vendition.message.vo.VenditionWareMsgVO">
						<html:option value="${qmsg.wareid}">${qmsg.warename}</html:option>
					</logic:iterate>
				</html:select>
			</logic:present></td>
		</tr>
		<tr>
			<td width="17%" height="25"><font size="2">规格:</font></td>
			<td width="50%" height="25"><html:text property="standard"
				value="${VenditionWareMsgVO.standard}" readonly="true" /></td>
		</tr>
		<tr>
			<td width="17%" height="25"><font size="2">单位</font></td>
			<td width="50%" height="25"><html:text property="unit"
				value="${VenditionWareMsgVO.unit}" readonly="true" /></td>
		</tr>
		<tr>
			<td width="17%" height="25"><font size="2">单价(/元)</font></td>
			<td width="50%" height="25"><html:text property="rate"
				value="${VenditionWareMsgVO.rate}" readonly="true" /></td>
		</tr>
		<tr>
			<td width="17%" height="25"><font size="2">进货日期</font></td>
			<td width="50%" height="25"><html:text property="stockdateYear"
				size="4" /><font size="2">年</font>&nbsp;<html:text
				property="stockdateMon" size="2" /><font size="2">月</font>&nbsp;<html:text
				property="stockdateDay" size="2" /><font size="2">日</font> <font
				size="2">（如:19xx年xx月xx月）</font></td>
		</tr>
		<tr>
			<td width="17%" height="25"><font size="2">进货数量</font></td>
			<td width="50%" height="25"><html:text property="stockamount" /></td>
		</tr>
		<tr>
			<td width="17%" height="25"><font size="2">金额合计</font></td>
			<td width="50%" height="25"><html:text property="moneysum"
				value="${VenditionStockMoneyVO.someMoney}" readonly="true" /><html:button
				onclick="submitting('stockMoneyMsg')" property="deleteMsg()">金额合计
			</html:button></td>
		</tr>
		<tr>
			<td width="17%" height="10">&nbsp;</td>
			<td width="17%" height="10">&nbsp;</td>
		</tr>
		<tr>
			<td width="17%" height="10">&nbsp;</td>
			<td width="17%" height="10">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="2" align="right" height="30%" valign="bottom"><html:button
				onclick="submitting('venditionCreStockMsg')" property="deleteMsg()">确定
			</html:button>&nbsp;<html:button onclick="submitting('backfun')"
				property="deleteMsg()">返回
			</html:button>&nbsp;</td>
		</tr>
	</table>
</html:form>
</body>
</html:html>
