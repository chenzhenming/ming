
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
<title>Ö÷Ò³Ãæ</title>
<script type="text/javascript" src="script/function_move.js"></script>
<script type="text/javascript" src="script/check.js"></script>
<script type="text/javascript" src="script/calendar.js"></script>
</head>

<body background="image/background7.gif" onLoad="clockon()">
<table width="760" height="739" border="0" align="center"
	bgcolor="#CCFFFF">
	<tr bgcolor="#CCFFFF">
		<td width="760" height="58" bgcolor="#FFFFcc">
		<table width="100%" height="124" border="0" align="center"
			bgcolor="#FFFFCC">
			<tr bgcolor="#FFFFCC">
				<td width="771" height="124" align="center"><img
					src="image/vtop.jpg" width="100%" height="100%" align="center" /></td>
			</tr>
		</table>
		</td>
	</tr>
	<tr>
		<td height="520" bgcolor="#FFFFCC"><jsp:include
			page="/JSP/VenditionLeftJsp.jsp" flush="true" /> <logic:present
			name="errors" scope="request">
			<bean:write name="errors" />
		</logic:present></td>
	</tr>
	<tr>
		<td height="40" bgcolor="#FFFFCC">
		<table width="100%" height="100%" border="0" align="center"
			bgcolor="#ffffff" background="image/vbottom.jpg">
			<tr>
				<td width="126" height="30">&nbsp;</td>
				<td width="495" height="30">
				<div align="center"><font size="2" color="#ffffff">v1.0&nbsp;<br>
				@?????????&nbsp;<br>
				</font></div>
				</td>
				<td width="126" align="center"></td>
			</tr>
		</table>
		</td>
	</tr>
</table>
</body>
</html:html>
