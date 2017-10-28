
var BYTE_CHECK_FLG = 0; 		//0,  文字数は全角計算；　1, 文字数は半角計算


//**********************************************************
// 文字列編集関数群
//**********************************************************

//****************MESSAGE*************************************************//
var G_MSG_FILE_ERR         = "ファイル名エラー。";
var G_MSG_FILENAME_LARGE   = "ファイル名が入力制限バイト数を超えています。";
var G_MSG_NUMBER_ISNULL    = "は数字で入力して下さい。";
var G_MSG_NUMBER_SU_ERR    = "が桁あふれしています。";
//var G_MSG_NUMBER_ZHEN_ERR  = "は正数で入力して下さい。";
var G_MSG_NUMBER_ZHEN_ERR  = "に数値しか入力できません。";
var G_MSG_NUMBER_ISNULL    = "は数値で入力して下さい。";
var G_MSG_CHAR_ISNULL      = "に必須入力項目が入力されていません。";
var G_MSG_CHAR_BANJIAO_ERR = "は半角文字で入力してください。";
var G_MSG_CHAR_LARGE       = "が入力制限バイト数を超えています。";
var G_MSG_EMAIL_ERR        = "が有効なメールアドレスが入力してください。";
var G_MSG_CHAR_ERR         = "に使用出来ない文字(\'\",|@<>#%&+\\=?)が含まれています。";
var G_MSG_CHAR_ERR1		   = "のフォーマットは正しくありません。";

var TVGE1001 = "指定された会員は当該処理を行う権限がありません。";
var TVGE1002 = "対象データは既に登録済みです。";
var TVGE1004 = "対象データは他端末から削除されました｡";
var TVGE1006 = "対象データベースの更新に失敗しました｡";

var TVGQ0001 = "追加しますか？";
var TVGQ0002 = "更新しますか？";
var TVGQ0003 = "削除しますか？";
var TVGQ0004 = "印刷しますか？";
var TVGQ0005 = "実行しますか？";
var TVGQ0007 = "取消しますか？";
var TVGQ0008 = "帳票を作成し、印刷しますか？";
var TVGQ0009 = "ロールの権限が変更します、よろしいですか？";

var TVGE0001 = "{0}に必須入力項目が入力されていません。";
var TVGE0002 = "項目にフル桁入力されていません。";
var TVGE0003 = "項目に日付の入力が不当です。";
var TVGE0004 = "項目に月の入力が不当です。";
var TVGE0005 = "項目に日の入力が不当です。";
var TVGE0006 = "項目に検索キーが入力されていません。";
var TVGE0007 = "項目に範囲指定が不当です。";
var TVGE0008 = "項目に大小関係が誤っています。";
var TVGE0009 = "項目にFrom - TOの入力が不当です。";
var TVGE0010 = "項目に桁溢れています。";
var TVGE0011 = "{0}数値以外は入力できません。";
var TVGE0012 = "{0}は{1}byte以内を設定してください。";
var TVGE0013 = "負数の入力が不当です。";
var TVGE0014 = "小数値の入力が不当です。";;
var TVGE0015 = "印刷を失敗しました。";
var TVGE0016 = "登録してください。";
var TVGE0017 = "のフォーマットは正しくありません。";
var TVGE0018 = "は全角カナで入力して下さい。";
var TVGE0019 = "{0}は英数字以外は入力できません。";

var TVGE0020 = "パスワード確認とパスワードは一致しない。";
var TVGE0021 = "開始時間が結束時間を超えています。";
var TVGE0022 = "セションンがタイムアウト。";
var TVGE0023 = "システムの内部エラー";
var TVGE0024 = "指定ファイルがありません。";
var TVGE0025 = "商品の画像が指定してください。";
var TVGE0026 = "商品コードがありません。";
var TVGE0027 = "入力したユーザーコードとパスワードはいずれか間違っています。";
var TVGE0028 = "はひらがなで入力して下さい。";
var TVGE0029 = "入力が不当です。"
//****************MESSAGE End********************************************//

//  カンマ削除処理関数
// (文字列に含まれるカンマ（,）を削除する)
function trim(sData) 
{
	return sData.replace(/^[\s　]*|[\s　]*$|,/g, "")
}

//  カンマ削除処理関数
// (文字列に含まれるカンマ（,）を削除する)
function delCommer(sData)
{
	return !(sData = sData.replace(/^[\s　]*|[\s　]*$|,/g, "")) ||
		sData + "e+0" - 0 + "" != "NaN" && (sData = sData - 0 + "") != "NaN" ? sData : "ERR";
}

//  カンマ追加処理関数
// (普通の整数を貨幣（3カンマ）フォーマットに変更する)
function addCommer(nData)
{
	var nDot, nLen, nCnt;
	var asData, nCsr, sData;

	if ((sData = delCommer(nData + "")) == "ERR") return "ERR";
	nDot = sData.indexOf(".");
	nLen = nDot  < 0 ? sData.length : nDot;
	nCnt = sData - 0 < 0 ? (nLen - 2) % 3 + 2 : (nLen - 1) % 3 + 1;

	asData = new Array(20); nCsr = 1;
	asData[0] = sData.substr(0, nCnt);
	while (nCnt < nLen) { asData[nCsr++] = sData.substr(nCnt, 3); nCnt += 3; }

	asData[nCsr-1] += sData.substr(nCnt);
	asData.length = nCsr;
	return asData.join(",");
}

//  前ゼロ付加関数
// (指定した桁数になるように前にゼロを付加する)
function fillZero(numData, numFigure)
{
	var strData = numData + "";
	numFigure = numFigure - strData.length - 1;
	if (numFigure >= 0) do { strData = "0" + strData; } while (numFigure--);
	return strData;
}

//**********************************************************
// 文字列チェック関数群
//**********************************************************

//  字数チェック関数
// (字数のチェックを行う)
// nMaxLen	: MAXバイト数
function strLen(sData, nMaxLen)
{	
	if (BYTE_CHECK_FLG == 0)  //文字数全角計算
	{
		var nCsr = 0, nCnt, cData;
		cData = filterCode(sData);
		nCsr = cData.length;
	
		return nCsr <= nMaxLen;
	}
	else					//文字数は半角計算
	{
		return strLenB(sData, nMaxLen)
	}
	
}

//  バイト数チェック関数
// (バイト数のチェックを行う)
// nMaxLen	: MAXバイト数
function strLenB(sData, nMaxLen)
{
	var nCsr = 0, nCnt, cData;
	sData = filterCode(sData);
	for (nCnt = 0; nCnt < sData.length; nCnt++) {
		cData = sData.charCodeAt(nCnt);
		// Shift_JIS: 0x0 ? 0x80, 0xa0  , 0xa1   ? 0xdf  , 0xfd   ? 0xff
		// Unicode  : 0x0 ? 0x80, 0xf8f0, 0xff61 ? 0xff9f, 0xf8f1 ? 0xf8f3
		if ( (cData >= 0x0 && cData < 0x81) || (cData == 0xf8f0) || (cData >= 0xff61 && cData < 0xffa0) || (cData >= 0xf8f1 && cData < 0xf8f4)) {
			nCsr += 1;
		}
		 else {
			nCsr += 2;
		}
    }
	return nCsr <= nMaxLen;
}

// コード範囲チェック関数 (指定されたコードの文字だけの文字列かチェックする)
// nStart	: 開始コード
// nEnd		: 終了コード
// bXor		: 含むかどうか。true:一つも含まれていない、false:全部含まれている
function charCode(sData, nStart, nEnd, bXor)
{
	var nLen = sData.length, nCnt, nCode;
	for (nCnt = 0; nCnt < nLen; nCnt++)
		if (((nCode = sData.charCodeAt(nCnt)) < nStart || nEnd < nCode) ^ bXor) return false;
	return true;
}

//  使用不可文字チェック関数
// (入力文字列に使用不可文字が含まれていないかをチェックする)
function chkNoUse(sData)
{
	return !(sData.split(",").length - 1 || sData.split("'").length - 1 || sData.split("\"").length - 1
		|| sData.split("|").length - 1 || sData.split("@").length - 1 || sData.split("<").length - 1
		|| sData.split(">").length - 1 || sData.split("#").length - 1 || sData.split("%").length - 1
		|| sData.split("&").length - 1 || sData.split("+").length - 1 || sData.split("\\").length - 1
		|| sData.split("=").length - 1 || sData.split("?").length - 1);
}

//  File 使用不可文字チェック関数
// (入力文字列に使用不可文字が含まれていないかをチェックする)
function chkFileNoUse(sData) {
	var rt;
	rt = (  sData.indexOf("\"") >= 0 || sData.indexOf(":") >= 0 || sData.indexOf("/") >= 0
			|| sData.indexOf("|") >= 0 || sData.indexOf("<") >= 0 || sData.indexOf("*") >= 0
			|| sData.indexOf(">") >= 0 || sData.indexOf("\\") >= 0 || sData.indexOf("?") >= 0);
	
	if (rt == true) {
		return false;
	}
	return true;
	
}

// Get File name
//
function getFilename(fnames) {
	var filename = fnames;
	if (trim(filename) != "") {
		filename = filename.replace(/\\/g, "/");
			
		if (filename.lastIndexOf("/") < 0) {
			filename = "";
		}
		filename = filename.substring(filename.lastIndexOf("/") + 1);
	} else {
		filename = "";
	}
	
	return filename;
}

//  File チェック関数
// bNec		: 必須チェック
function chkFileInput(oElmt, sName, nLen, bNec) {
	if (bNec && !chkIsNec(oElmt, sName)) return false;
	
	var filename = oElmt.value
	if (trim(filename) != "") {
		filename = getFilename(filename);
		
		if (!strLen(filename, nLen))
		{ alert(G_MSG_FILENAME_LARGE); oElmt.focus(); return false; }
	
		if (filename == "" || !chkFileNoUse(filename)) {
			alert(G_MSG_FILE_ERR);
			return false;
		}
	}
	return true;
}
//**********************************************************
// 数値チェック関数群
//**********************************************************

//  数値チェック処理
// (入力文字列が指定条件に見合った数値であるかをチェックする)
// sFlag	: フラグ。2:小数点あり、1:整数、以外:正数
function chkNumber(sData, sFlag)
{
	if (sData && !sData.replace(/^[\s　]*/g, "")) return false;
	if ((sData = delCommer(sData)) == "ERR") return false;
	if (sFlag == "2") return true;
	if (sFlag == "1") return !(sData % 1);
	return sData - 0 >= 0 && !(sData % 1);
}

//  小数桁数チェック関数
// (小数部の桁数と整数部の桁数をチェックし、有効な小数数字かをチェックする。)
// nIntLen	: 整数部桁数
// nDecLen	: 小数部桁数
function chkShosu(nData, nIntLen, nDecLen)
{
	var sData = nData + "", asData;
	asData = sData.split(".");
	if (asData[0].length - (nData < 0) > nIntLen) return false;
	if (asData[1] && asData[1].length > nDecLen) return false;
	return true;
}

//**********************************************************
// 日付チェック関数群
//**********************************************************

//  日付存在チェック関数
// (日付の存在チェックを行なう)
function chkDate(sYear, sMon, sDay)
{
	var aTable = new Array(31,28,31,30,31,30,31,31,30,31,30,31);
	if (!sYear && !sMon && !sDay) return true;
	if (!(sYear && sMon && sDay)) return false;
	if (!(chkNumber(sYear) && chkNumber(sMon) && chkNumber(sDay))) return false;
	if (!(sYear % 4) && sYear % 100 || !(sYear % 400)) aTable[1] = 29;
	return 1 <= sMon - 0 && sMon - 0 <= 12 && 1 <= sDay - 0 && sDay - 0 <= aTable[sMon-1];
}

//  日付比較関数
// (日付の比較を行う)
function cmpDate(nYearS, nMonS, nDayS, nYearE, nMonE, nDayE)
{
	if (!(chkDate(nYearS+"", nMonS+"", nDayS+"") && chkDate(nYearE+"", nMonE+"", nDayE+""))) return false;
	return nYearS <  nYearE ||
		   nYearS == nYearE && (nMonS <  nMonE ||
		                        nMonS == nMonE && nDayS <= nDayE);
}

//**********************************************************
// 複合チェック関数群
//**********************************************************

//  必須入力項目チェック関数
// (必須の項目チェックを行う)
function chkIsNec(oElmt, sName)
{
	if (!oElmt.value.replace(/^[\s　]*|[\s　]*$/g, ""))
	{ alert(sName + G_MSG_CHAR_ISNULL); oElmt.focus(); return false; }
	return true;
}

//  整数入力項目チェック関数
// (整数の項目チェックを行う)
// bNec		: 必須チェック
function chkSeisuIn(oElmt, sName, nLen, bNec)
{
	var sData = oElmt.value;
	if (bNec && !chkIsNec(oElmt, sName)) return false;
	if (sData && !sData.replace(/^[\s　]*/g, ""))
	{ alert(sName + G_MSG_NUMBER_ISNULL); oElmt.focus(); return false; }
	if ((sData = delCommer(sData)) == "ERR")
	{ alert(sName + G_MSG_NUMBER_ISNULL); oElmt.focus(); return false; }
	if (!chkNumber(sData, "1"))
	{ alert(sName + G_MSG_NUMBER_ISNULL); oElmt.focus(); return false; }
	if (sData.length - (sData - 0 < 0) > nLen)
	{ alert(sName + G_MSG_NUMBER_SU_ERR); oElmt.focus(); return false; }
	return true;
}

//  正数入力項目チェック関数
// (正数の項目チェックを行う)
// bNec		: 必須チェック
function chkPlusIn(oElmt, sName, nLen, bNec)
{
	var sData = oElmt.value;
	if (bNec && !chkIsNec(oElmt, sName)) return false;
	if (sData && !sData.replace(/^[\s　]*/g, ""))
	{ alert(sName + G_MSG_NUMBER_ISNULL); oElmt.focus(); return false; }
	if ((sData = delCommer(sData)) == "ERR")
	{ alert(sName + G_MSG_NUMBER_ISNULL); oElmt.focus(); return false; }
	if (!chkNumber(sData, "1"))
	{ alert(sName + G_MSG_NUMBER_ISNULL); oElmt.focus(); return false; }
	if (sData - 0 < 0)
	{ alert(sName + G_MSG_NUMBER_ZHEN_ERR); oElmt.focus(); return false; }
	if (sData.length > nLen)
	{ alert(sName + G_MSG_NUMBER_SU_ERR); oElmt.focus(); return false; }
	return true;
}

//  整数入力項目チェック関数２
// (整数の項目チェックを行い、)
// nStart	: 開始数
// nEnd		: 終了数
// bNec		: 必須チェック
function chkLimitIn(oElmt, sName, nStart, nEnd, bNec)
{
	var sData = oElmt.value;
	if (bNec && !chkIsNec(oElmt, sName)) return false;
	if (sData && !sData.replace(/^[\s　]*/g, ""))
	{ alert(sName + G_MSG_NUMBER_ISNULL); oElmt.focus(); return false; }
	if (sData == "") return true;
	if ((sData = delCommer(sData)) == "ERR")
	{ alert(sName + G_MSG_NUMBER_ISNULL); oElmt.focus(); return false; }
	if (!chkNumber(sData, "1"))
	{ alert(sName + G_MSG_NUMBER_ISNULL); oElmt.focus(); return false; }
	if (sData - 0 < nStart || sData - 0 > nEnd)
	{ alert(sName + "は" + nStart + "から" + nEnd + "までの数字で入力して下さい。"); oElmt.focus(); return false; }
	return true;
}

//  実数入力項目チェック関数
// (実数の項目チェックを行う)
// nFore	: 整数部桁数
// nBack	: 小数部桁数
// bNec		: 必須チェック
function chkJisuIn(oElmt, sName, nFore, nBack, bNec)
{
	var sData = oElmt.value;
	if (bNec && !chkIsNec(oElmt, sName)) return false;
	if (sData && !sData.replace(/^[\s　]*/g, ""))
	{ alert(sName + G_MSG_NUMBER_ISNULL); oElmt.focus(); return false; }
	if ((sData = delCommer(sData)) == "ERR")
	{ alert(sName + G_MSG_NUMBER_ISNULL); oElmt.focus(); return false; }
	if (!chkNumber(sData, "2"))
	{ alert(sName + G_MSG_NUMBER_ISNULL); oElmt.focus(); return false; }
	if (!chkShosu(sData-0, nFore, nBack))
	{ alert(sName + G_MSG_NUMBER_SU_ERR); oElmt.focus(); return false; }
	return true;
}

//  入力項目　最終"\"　チェック関数
// (半角英数の項目チェックを行う)
// 
function chkLastCha(oVal)
{
	if (oVal.lastIndexOf("\\") >= 0 && oVal.lastIndexOf("\\") == (oVal.length - 1)) return false;
	return true;
}

//  E-mail入力項目チェック関数
// (E-mailの項目チェックを行う)
// bNec		: 必須チェック
function chkEmail(oElmt, sName, nLen, bNec)
{
	if (bNec && !chkIsNec(oElmt, sName)) return false;
	if (!charCode(oElmt.value, 32, 126, 0))
	{ alert(sName + G_MSG_CHAR_BANJIAO_ERR); oElmt.focus(); return false; }
	if (oElmt.value.length > nLen)
	{ alert(sName + G_MSG_CHAR_LARGE); oElmt.focus(); return false; }
	if (oElmt.value.indexOf("@") <= 0 || oElmt.value.indexOf(".") <= 0) 
	{ alert(sName + TVGE0017); oElmt.focus(); return false; }
	return true;
}

//  半角英数入力項目チェック関数
// (半角英数の項目チェックを行う)
// bNec		: 必須チェック
function chkEisuIn(oElmt, sName, nLen, bNec)
{
	if (bNec && !chkIsNec(oElmt, sName)) return false;
	if (!chkNoUse(oElmt.value))
	{ alert(sName + G_MSG_CHAR_ERR); oElmt.focus(); return false; }
	if (!charCode(oElmt.value, 32, 126, 0))
	{ alert(sName + G_MSG_CHAR_BANJIAO_ERR); oElmt.focus(); return false; }
	if (oElmt.value.length > nLen)
	{ alert(sName + G_MSG_CHAR_LARGE); oElmt.focus(); return false; }
	return true;
}

//  全角カナ入力項目チェック関数
// (全角カナの項目チェックを行う)
// bNec		: 必須チェック
function chkZenkanaIn(oElmt, sName, nLen, bNec)
{
	if (bNec && !chkIsNec(oElmt, sName)) return false;
	if (!chkLastCha(oElmt.value))
	{ alert(sName + "に最終使用出来ない文字(\\)が含まれています。"); oElmt.focus(); return false; }
	if (!charCode(oElmt.value, 12449, 12540, 0))
	{ 
	
	alert(sName + TVGE0018); oElmt.focus(); return false; }
	if (oElmt.value.length*2 > nLen)
	{ alert(sName + G_MSG_CHAR_LARGE); oElmt.focus(); return false; }
	return true;
}

//  ひらがな入力項目チェック関数
// (ひらがなの項目チェックを行う)
// bNec		: 必須チェック
function chkHiraganaIn(oElmt, sName, nLen, bNec)
{
	if (bNec && !chkIsNec(oElmt, sName)) return false;
	if (!chkLastCha(oElmt.value))
	{ alert(sName + "に最終使用出来ない文字(\\)が含まれています。"); oElmt.focus(); return false; }
	if (!charCode(oElmt.value, 12353,12435, 0))
	{ 
	
	alert(sName + TVGE0028); oElmt.focus(); return false; }
	if (oElmt.value.length*2 > nLen)
	{ alert(sName + G_MSG_CHAR_LARGE); oElmt.focus(); return false; }
	return true;
}

//  チェック字符字節数
// (字符字節数チェックを行う)
// bNec		: 必須チェック
function chkByteLen(oElmt, sName, nLen, bNec)
{
	if (bNec && !chkIsNec(oElmt, sName)) return false;
	var sData = oElmt.value;
	if (!strLenB(oElmt.value, nLen))
	{ alert(sName + "は"+nLen+"byte以内を設定してください。"); oElmt.focus(); return false; }
	return true;
}

//  全角入力項目チェック関数--文字
// (全角の項目チェックを行う)
// bNec		: 必須チェック
function chkZenkakuIn(oElmt, sName, nLen, bNec)
{
	if (bNec && !chkIsNec(oElmt, sName)) return false;	
	if (!strLen(oElmt.value, nLen))
	{ alert(sName + G_MSG_CHAR_LARGE); oElmt.focus(); return false; }
	return true;
}

//  四捨五入関数
// (四捨五入を行う)
// numCsr	: どの位で、四捨五入を行なうか。
function mathRound(numVal, numCsr)
{
	if (numCsr)
	{
		numVal = numVal * Math.pow(10, numCsr) - 0;
		if(numVal < 0) numVal -= 0.5;
		else        numVal += 0.5;
		return (numVal - numVal % 1) / Math.pow(10, numCsr);
	}
	numVal = numVal - 0;
	if(numVal < 0) numVal -= 0.5;
	else        numVal += 0.5;
	return numVal - numVal % 1;
}

//  特殊文字置き換え関数
// & " ' , < >
function filterCode(sData)
{
	var tmp = sData;
	if (tmp == null) tmp = "";
	tmp = tmp.replace(/'/g, "’");
	
	//tmp = tmp.replace(/&/g, "&#38;");
	//tmp = tmp.replace(/\"/g, "&#34;");
	//tmp = tmp.replace(/'/g, "&#39;");
	//tmp = tmp.replace(/,/g, "&#44;");
	//tmp = tmp.replace(/</g, "&lt;");
	//tmp = tmp.replace(/>/g, "&gt;");
	
	return tmp;
}

// 特殊文字置き換え関数
// & " ' , < >
function revFilterCode(sData)
{
	var tmp = sData;
	tmp = tmp.replace(/&#38;/g, "&");
	tmp = tmp.replace(/&#34;/g, "\"");
	tmp = tmp.replace(/&#39;/g, "'");
	tmp = tmp.replace(/&#44;/g, ",");
	tmp = tmp.replace(/&lt;/g,  "<");
	tmp = tmp.replace(/&gt;/g,  ">");
	
	return tmp;
}
// 郵便番号
//
function changezipcode(oElmt){
	var temp = oElmt.value.replace(/-/g,"");
	if(temp.length >= 3&&temp.length <= 7){
		temp = temp.substring(0,3) + "-" + temp.substr(3);
		oElmt.value = temp;
	}
}
// TEL FAX
//
function changetel(oElmt){
	var temp = oElmt.value.replace(/-/g,"");
	temp = temp.replace(/-/g,"");
	if(temp.length >= 4 && temp.length < 8){
		temp = temp.substring(0,4) + "-" + temp.substr(4);
		oElmt.value = temp;
	}else if(temp.length >= 8 && temp.length <= 12){
		temp = temp.substring(0,4) + "-" + temp.substring(4,8) + "-" + temp.substr(8);
		oElmt.value = temp;
	}

}

//PASSWORD
function chkPassword(oElmt1,oElmt2){
	var temp1 = oElmt1.value;
	var temp2 = oElmt2.value;
	if(temp1 != temp2){
		alert("パスワード確認とパスワードは一致しない。"); oElmt2.focus(); return false;
	}
	return true;
}

// email
function chkEmail1( oElmt, sName, nLen, bNec){
	var sData = oElmt.value;
	var filter=/(^[a-zA-Z]|^[a-zA-Z][\w-_\.]*[a-zA-Z0-9])@(\w+\.)+\w+$/;
	if (!strLenB(sData, nLen))
	{ alert(sName + "は"+nLen+"byte以内を設定してください。"); oElmt.focus(); return false; }
	if (sData != ""){
		if (!filter.exec(sData)){
			alert(sName + G_MSG_CHAR_ERR1); oElmt.focus(); return false;
		}
	}
	return true;
}

//time
function chkIsdate(oElmt,sName){
	var date = oElmt.value;
	var Year = date.substring(0,4);
	var Mon =  date.substring(5,7);
	var Day =  date.substring(8,10);
	if(!chkDate(Year,Mon,Day)){
		alert(sName + "項目のフォーマットは正しくありません。");
		oElmt.focus();
		return false;
	}
	if(date.substring(4,5)!="/"||date.substring(7,8)!="/"){
		alert(sName + "項目のフォーマットは正しくありません。");
		oElmt.focus();
		return false;
	}
	if(date.length != 10){
		alert(sName + "項目のフォーマットは正しくありません。");
		oElmt.focus();
		return false;
	}
	return true;
}

//Comparison
function comparisonDate(oElmt1,oElmt2){
	var Sdate = oElmt1.value;
	var Edate = oElmt2.value;
	var sYear = Sdate.substring(0,4);var eYear = Edate.substring(0,4);
	var sMon =  Sdate.substring(5,7);var eMon =  Edate.substring(5,7);
	var sDay =  Sdate.substring(8,10);var eDay =  Edate.substring(8,10);
	if(!cmpDate(sYear,sMon,sDay,eYear,eMon,eDay)){
		alert("開始時間が結束時間を超えています。");
		return false;
	}
	return true;
}

//Comparison1
function comparisonDate1(oElmt1,oElmt2){
	var Sdate = oElmt1.value.substring(0,10);
	var Edate = oElmt2.value;
	var sYear = Sdate.substring(0,4);var eYear = Edate.substring(0,4);
	var sMon =  Sdate.substring(5,7);var eMon =  Edate.substring(5,7);
	var sDay =  Sdate.substring(8,10);var eDay =  Edate.substring(8,10);
	if(!cmpDate(sYear,sMon,sDay,eYear,eMon,eDay)){
		alert("開始時間が結束時間を超えています。");
		return false;
	}
	return true;
}

// 郵便番号
function chkZipcd(oElmt, sName, nLen, bNec)
{
	var filter=/^(\d{3})[\-](\d{4})$/;
	if (bNec && !chkIsNec(oElmt, sName)) return false;
	var sData = oElmt.value;
	if (!strLenB(oElmt.value, nLen))
	{ alert(sName + "は"+nLen+"byte以内を設定してください。"); oElmt.focus(); return false; }
	if (sData!=""){
		if (!filter.test(sData)){
			alert(sName + G_MSG_CHAR_ERR1); oElmt.focus(); return false;
		}
	}
	return true;
}

// TEL FAX
function chkTel(oElmt, sName, nLen, bNec)
{
	var filter=/^[0-9\-]+$/;
	if (bNec && !chkIsNec(oElmt, sName)) return false;
	var sData = oElmt.value;
	if (!strLenB(oElmt.value, nLen))
	{ alert(sName + "は"+nLen+"byte以内を設定してください。"); oElmt.focus(); return false; }
	if (sData!=""){
		if (!filter.test(sData)){
			alert(sName + G_MSG_CHAR_ERR1); oElmt.focus(); return false;
		}
	}
	return true;
}

// ユーザーコード
function chkUsercd(oElmt, sName, nLen, bNec)
{
	var filter=/^[A-Z0-9]+$/;
	if (bNec && !chkIsNec(oElmt, sName)) return false;
	var sData = oElmt.value;
	if (!strLenB(oElmt.value, nLen))
	{ alert(sName + "は"+nLen+"byte以内を設定してください。"); oElmt.focus(); return false; }
	if (sData!=""){
		if (!filter.test(sData)){
			alert(sName + G_MSG_CHAR_ERR1); oElmt.focus(); return false;
		}
	}
	return true;
}

// ユーザーコード
function chkCompanycd(oElmt, sName, nLen, bNec)
{
	var filter=/^[A-Z0-9]+$/;
	if (bNec && !chkIsNec(oElmt, sName)) return false;
	var sData = oElmt.value;
	if (!strLenB(oElmt.value, nLen))
	{ alert(sName + "は"+nLen+"byte以内を設定してください。"); oElmt.focus(); return false; }
	if (sData!=""){
		if (!filter.exec(sData)){
			alert(sName + G_MSG_CHAR_ERR1); oElmt.focus(); return false;
		}
	}
	return true;
}

//会社コード
function chkCompanycd(oElmt, sName, nLen, bNec)
{
	var filter=/^[A-Z0-9]+$/;
	if (bNec && !chkIsNec(oElmt, sName)) return false;
	var sData = oElmt.value;
	if (!strLenB(oElmt.value, nLen))
	{ alert(sName + "は"+nLen+"byte以内を設定してください。"); oElmt.focus(); return false; }
	if (sData!=""){
		if (!filter.test(sData)){
			alert(sName + G_MSG_CHAR_ERR1); oElmt.focus(); return false;
		}
	}
	return true;
}



// 掲示板カテゴリー
function chkbbsctgyCd(oElmt, sName, sChar)
{
	var temp=oElmt.value;
	if (temp == sChar)
	{	
		alert(sName + "に必須入力項目が入力されていません。");
		oElmt.selected=false;
		return false;
	}
	return true;
}
function chkCustomer(oElmt, sName, nLen, bNec){
	if (bNec && !chkIsNec(oElmt, sName)) return false;
	if (!chkLastCha(oElmt.value))
	{ alert(sName + "に最終使用出来ない文字(\\)が含まれています。"); oElmt.focus(); return false; }
	if (!(charCode(oElmt.value, 12353,12435, 0)||charCode(oElmt.value, 12449, 12540, 0)))
	{ 
		alert(sName + TVGE0029); oElmt.focus(); return false; }
	if (oElmt.value.length*2 > nLen)
	{ alert(sName + G_MSG_CHAR_LARGE); oElmt.focus(); return false; }
	return true;
}





