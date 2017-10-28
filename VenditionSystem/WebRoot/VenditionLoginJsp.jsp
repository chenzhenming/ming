
<%@ page language="java" pageEncoding="GB2312"%>

<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"
	prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"
	prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic"
	prefix="logic"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html locale="true">
<head>
<title>登陆页面</title>
</head>

<body bgcolor="#CCCCCC" background="image/background7.gif"
	TEXT="#000000">
<br>
<br>
<br>
<table width="59%" height="70%" border="0" align="center"
	bgcolor="#EFFCF5">
	<tr>
		<td height="126" colspan="2" align="center"><img src="image/vtop.jpg"
			width="800" height="124" align="top" /></td>
	</tr>
	<tr>
		<td colspan="2"></td>
	</tr>
	<tr>
		<td width="40%"></td>
		<td width="430" height="106"><html:form action="/venditionLoginAction"
			method="post" focus="userId">
			<table width="394" height="75" border="0" align="right">
				<tr>
					<td width="171">
					<div align="right">用户ID：</div>
					</td>
					<td><html:text property="userId" size="20" /></td>
				</tr>
				<tr>
					<td>
					<div align="right">密&nbsp;&nbsp;码：</div>
					</td>
					<td><html:password property="password" size="20" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>
					<div align="center"><html:submit>
						确定
					</html:submit> &nbsp; <html:reset>
						重填
					</html:reset></div>
					</td>
				</tr>
			</table>
		</html:form></td>
	</tr>
	<tr>
		<td colspan="2"></td>
	</tr>
	<tr>
		<td height="58" colspan="2">
		<center><logic:present name="errors" scope="request">
			<bean:write name="errors" />
		</logic:present></center>
		<div align="right"><font size="2">v1.0&nbsp;<br>
		@商业进销存管理系统&nbsp;<br>
		@2012-11-13&nbsp;</font><br/>
		程序共享:<font color=ref>双鱼林</font>&nbsp;QQ1:<font color=red>287307421</font>&nbsp;QQ2:<font color=red>254540457</font>&nbsp;更多设计到:<a href='http://www.shuangyulin.com' target="_blank">http://www.shuangyulin.com</a>
		</div>
		</td>
	</tr>
</table>

</body>
</html:html>
