
var BYTE_CHECK_FLG = 0; 		//0,  �������͑S�p�v�Z�G�@1, �������͔��p�v�Z


//**********************************************************
// ������ҏW�֐��Q
//**********************************************************

//****************MESSAGE*************************************************//
var G_MSG_FILE_ERR         = "�t�@�C�����G���[�B";
var G_MSG_FILENAME_LARGE   = "�t�@�C���������͐����o�C�g���𒴂��Ă��܂��B";
var G_MSG_NUMBER_ISNULL    = "�͐����œ��͂��ĉ������B";
var G_MSG_NUMBER_SU_ERR    = "�������ӂꂵ�Ă��܂��B";
//var G_MSG_NUMBER_ZHEN_ERR  = "�͐����œ��͂��ĉ������B";
var G_MSG_NUMBER_ZHEN_ERR  = "�ɐ��l�������͂ł��܂���B";
var G_MSG_NUMBER_ISNULL    = "�͐��l�œ��͂��ĉ������B";
var G_MSG_CHAR_ISNULL      = "�ɕK�{���͍��ڂ����͂���Ă��܂���B";
var G_MSG_CHAR_BANJIAO_ERR = "�͔��p�����œ��͂��Ă��������B";
var G_MSG_CHAR_LARGE       = "�����͐����o�C�g���𒴂��Ă��܂��B";
var G_MSG_EMAIL_ERR        = "���L���ȃ��[���A�h���X�����͂��Ă��������B";
var G_MSG_CHAR_ERR         = "�Ɏg�p�o���Ȃ�����(\'\",|@<>#%&+\\=?)���܂܂�Ă��܂��B";
var G_MSG_CHAR_ERR1		   = "�̃t�H�[�}�b�g�͐���������܂���B";

var TVGE1001 = "�w�肳�ꂽ����͓��Y�������s������������܂���B";
var TVGE1002 = "�Ώۃf�[�^�͊��ɓo�^�ς݂ł��B";
var TVGE1004 = "�Ώۃf�[�^�͑��[������폜����܂����";
var TVGE1006 = "�Ώۃf�[�^�x�[�X�̍X�V�Ɏ��s���܂����";

var TVGQ0001 = "�ǉ����܂����H";
var TVGQ0002 = "�X�V���܂����H";
var TVGQ0003 = "�폜���܂����H";
var TVGQ0004 = "������܂����H";
var TVGQ0005 = "���s���܂����H";
var TVGQ0007 = "������܂����H";
var TVGQ0008 = "���[���쐬���A������܂����H";
var TVGQ0009 = "���[���̌������ύX���܂��A��낵���ł����H";

var TVGE0001 = "{0}�ɕK�{���͍��ڂ����͂���Ă��܂���B";
var TVGE0002 = "���ڂɃt�������͂���Ă��܂���B";
var TVGE0003 = "���ڂɓ��t�̓��͂��s���ł��B";
var TVGE0004 = "���ڂɌ��̓��͂��s���ł��B";
var TVGE0005 = "���ڂɓ��̓��͂��s���ł��B";
var TVGE0006 = "���ڂɌ����L�[�����͂���Ă��܂���B";
var TVGE0007 = "���ڂɔ͈͎w�肪�s���ł��B";
var TVGE0008 = "���ڂɑ召�֌W������Ă��܂��B";
var TVGE0009 = "���ڂ�From - TO�̓��͂��s���ł��B";
var TVGE0010 = "���ڂɌ����Ă��܂��B";
var TVGE0011 = "{0}���l�ȊO�͓��͂ł��܂���B";
var TVGE0012 = "{0}��{1}byte�ȓ���ݒ肵�Ă��������B";
var TVGE0013 = "�����̓��͂��s���ł��B";
var TVGE0014 = "�����l�̓��͂��s���ł��B";;
var TVGE0015 = "��������s���܂����B";
var TVGE0016 = "�o�^���Ă��������B";
var TVGE0017 = "�̃t�H�[�}�b�g�͐���������܂���B";
var TVGE0018 = "�͑S�p�J�i�œ��͂��ĉ������B";
var TVGE0019 = "{0}�͉p�����ȊO�͓��͂ł��܂���B";

var TVGE0020 = "�p�X���[�h�m�F�ƃp�X���[�h�͈�v���Ȃ��B";
var TVGE0021 = "�J�n���Ԃ��������Ԃ𒴂��Ă��܂��B";
var TVGE0022 = "�Z�V���������^�C���A�E�g�B";
var TVGE0023 = "�V�X�e���̓����G���[";
var TVGE0024 = "�w��t�@�C��������܂���B";
var TVGE0025 = "���i�̉摜���w�肵�Ă��������B";
var TVGE0026 = "���i�R�[�h������܂���B";
var TVGE0027 = "���͂������[�U�[�R�[�h�ƃp�X���[�h�͂����ꂩ�Ԉ���Ă��܂��B";
var TVGE0028 = "�͂Ђ炪�Ȃœ��͂��ĉ������B";
var TVGE0029 = "���͂��s���ł��B"
//****************MESSAGE End********************************************//

//  �J���}�폜�����֐�
// (������Ɋ܂܂��J���}�i,�j���폜����)
function trim(sData) 
{
	return sData.replace(/^[\s�@]*|[\s�@]*$|,/g, "")
}

//  �J���}�폜�����֐�
// (������Ɋ܂܂��J���}�i,�j���폜����)
function delCommer(sData)
{
	return !(sData = sData.replace(/^[\s�@]*|[\s�@]*$|,/g, "")) ||
		sData + "e+0" - 0 + "" != "NaN" && (sData = sData - 0 + "") != "NaN" ? sData : "ERR";
}

//  �J���}�ǉ������֐�
// (���ʂ̐������ݕ��i3�J���}�j�t�H�[�}�b�g�ɕύX����)
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

//  �O�[���t���֐�
// (�w�肵�������ɂȂ�悤�ɑO�Ƀ[����t������)
function fillZero(numData, numFigure)
{
	var strData = numData + "";
	numFigure = numFigure - strData.length - 1;
	if (numFigure >= 0) do { strData = "0" + strData; } while (numFigure--);
	return strData;
}

//**********************************************************
// ������`�F�b�N�֐��Q
//**********************************************************

//  �����`�F�b�N�֐�
// (�����̃`�F�b�N���s��)
// nMaxLen	: MAX�o�C�g��
function strLen(sData, nMaxLen)
{	
	if (BYTE_CHECK_FLG == 0)  //�������S�p�v�Z
	{
		var nCsr = 0, nCnt, cData;
		cData = filterCode(sData);
		nCsr = cData.length;
	
		return nCsr <= nMaxLen;
	}
	else					//�������͔��p�v�Z
	{
		return strLenB(sData, nMaxLen)
	}
	
}

//  �o�C�g���`�F�b�N�֐�
// (�o�C�g���̃`�F�b�N���s��)
// nMaxLen	: MAX�o�C�g��
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

// �R�[�h�͈̓`�F�b�N�֐� (�w�肳�ꂽ�R�[�h�̕��������̕����񂩃`�F�b�N����)
// nStart	: �J�n�R�[�h
// nEnd		: �I���R�[�h
// bXor		: �܂ނ��ǂ����Btrue:����܂܂�Ă��Ȃ��Afalse:�S���܂܂�Ă���
function charCode(sData, nStart, nEnd, bXor)
{
	var nLen = sData.length, nCnt, nCode;
	for (nCnt = 0; nCnt < nLen; nCnt++)
		if (((nCode = sData.charCodeAt(nCnt)) < nStart || nEnd < nCode) ^ bXor) return false;
	return true;
}

//  �g�p�s�����`�F�b�N�֐�
// (���͕�����Ɏg�p�s�������܂܂�Ă��Ȃ������`�F�b�N����)
function chkNoUse(sData)
{
	return !(sData.split(",").length - 1 || sData.split("'").length - 1 || sData.split("\"").length - 1
		|| sData.split("|").length - 1 || sData.split("@").length - 1 || sData.split("<").length - 1
		|| sData.split(">").length - 1 || sData.split("#").length - 1 || sData.split("%").length - 1
		|| sData.split("&").length - 1 || sData.split("+").length - 1 || sData.split("\\").length - 1
		|| sData.split("=").length - 1 || sData.split("?").length - 1);
}

//  File �g�p�s�����`�F�b�N�֐�
// (���͕�����Ɏg�p�s�������܂܂�Ă��Ȃ������`�F�b�N����)
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

//  File �`�F�b�N�֐�
// bNec		: �K�{�`�F�b�N
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
// ���l�`�F�b�N�֐��Q
//**********************************************************

//  ���l�`�F�b�N����
// (���͕����񂪎w������Ɍ����������l�ł��邩���`�F�b�N����)
// sFlag	: �t���O�B2:�����_����A1:�����A�ȊO:����
function chkNumber(sData, sFlag)
{
	if (sData && !sData.replace(/^[\s�@]*/g, "")) return false;
	if ((sData = delCommer(sData)) == "ERR") return false;
	if (sFlag == "2") return true;
	if (sFlag == "1") return !(sData % 1);
	return sData - 0 >= 0 && !(sData % 1);
}

//  ���������`�F�b�N�֐�
// (�������̌����Ɛ������̌������`�F�b�N���A�L���ȏ������������`�F�b�N����B)
// nIntLen	: ����������
// nDecLen	: ����������
function chkShosu(nData, nIntLen, nDecLen)
{
	var sData = nData + "", asData;
	asData = sData.split(".");
	if (asData[0].length - (nData < 0) > nIntLen) return false;
	if (asData[1] && asData[1].length > nDecLen) return false;
	return true;
}

//**********************************************************
// ���t�`�F�b�N�֐��Q
//**********************************************************

//  ���t���݃`�F�b�N�֐�
// (���t�̑��݃`�F�b�N���s�Ȃ�)
function chkDate(sYear, sMon, sDay)
{
	var aTable = new Array(31,28,31,30,31,30,31,31,30,31,30,31);
	if (!sYear && !sMon && !sDay) return true;
	if (!(sYear && sMon && sDay)) return false;
	if (!(chkNumber(sYear) && chkNumber(sMon) && chkNumber(sDay))) return false;
	if (!(sYear % 4) && sYear % 100 || !(sYear % 400)) aTable[1] = 29;
	return 1 <= sMon - 0 && sMon - 0 <= 12 && 1 <= sDay - 0 && sDay - 0 <= aTable[sMon-1];
}

//  ���t��r�֐�
// (���t�̔�r���s��)
function cmpDate(nYearS, nMonS, nDayS, nYearE, nMonE, nDayE)
{
	if (!(chkDate(nYearS+"", nMonS+"", nDayS+"") && chkDate(nYearE+"", nMonE+"", nDayE+""))) return false;
	return nYearS <  nYearE ||
		   nYearS == nYearE && (nMonS <  nMonE ||
		                        nMonS == nMonE && nDayS <= nDayE);
}

//**********************************************************
// �����`�F�b�N�֐��Q
//**********************************************************

//  �K�{���͍��ڃ`�F�b�N�֐�
// (�K�{�̍��ڃ`�F�b�N���s��)
function chkIsNec(oElmt, sName)
{
	if (!oElmt.value.replace(/^[\s�@]*|[\s�@]*$/g, ""))
	{ alert(sName + G_MSG_CHAR_ISNULL); oElmt.focus(); return false; }
	return true;
}

//  �������͍��ڃ`�F�b�N�֐�
// (�����̍��ڃ`�F�b�N���s��)
// bNec		: �K�{�`�F�b�N
function chkSeisuIn(oElmt, sName, nLen, bNec)
{
	var sData = oElmt.value;
	if (bNec && !chkIsNec(oElmt, sName)) return false;
	if (sData && !sData.replace(/^[\s�@]*/g, ""))
	{ alert(sName + G_MSG_NUMBER_ISNULL); oElmt.focus(); return false; }
	if ((sData = delCommer(sData)) == "ERR")
	{ alert(sName + G_MSG_NUMBER_ISNULL); oElmt.focus(); return false; }
	if (!chkNumber(sData, "1"))
	{ alert(sName + G_MSG_NUMBER_ISNULL); oElmt.focus(); return false; }
	if (sData.length - (sData - 0 < 0) > nLen)
	{ alert(sName + G_MSG_NUMBER_SU_ERR); oElmt.focus(); return false; }
	return true;
}

//  �������͍��ڃ`�F�b�N�֐�
// (�����̍��ڃ`�F�b�N���s��)
// bNec		: �K�{�`�F�b�N
function chkPlusIn(oElmt, sName, nLen, bNec)
{
	var sData = oElmt.value;
	if (bNec && !chkIsNec(oElmt, sName)) return false;
	if (sData && !sData.replace(/^[\s�@]*/g, ""))
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

//  �������͍��ڃ`�F�b�N�֐��Q
// (�����̍��ڃ`�F�b�N���s���A)
// nStart	: �J�n��
// nEnd		: �I����
// bNec		: �K�{�`�F�b�N
function chkLimitIn(oElmt, sName, nStart, nEnd, bNec)
{
	var sData = oElmt.value;
	if (bNec && !chkIsNec(oElmt, sName)) return false;
	if (sData && !sData.replace(/^[\s�@]*/g, ""))
	{ alert(sName + G_MSG_NUMBER_ISNULL); oElmt.focus(); return false; }
	if (sData == "") return true;
	if ((sData = delCommer(sData)) == "ERR")
	{ alert(sName + G_MSG_NUMBER_ISNULL); oElmt.focus(); return false; }
	if (!chkNumber(sData, "1"))
	{ alert(sName + G_MSG_NUMBER_ISNULL); oElmt.focus(); return false; }
	if (sData - 0 < nStart || sData - 0 > nEnd)
	{ alert(sName + "��" + nStart + "����" + nEnd + "�܂ł̐����œ��͂��ĉ������B"); oElmt.focus(); return false; }
	return true;
}

//  �������͍��ڃ`�F�b�N�֐�
// (�����̍��ڃ`�F�b�N���s��)
// nFore	: ����������
// nBack	: ����������
// bNec		: �K�{�`�F�b�N
function chkJisuIn(oElmt, sName, nFore, nBack, bNec)
{
	var sData = oElmt.value;
	if (bNec && !chkIsNec(oElmt, sName)) return false;
	if (sData && !sData.replace(/^[\s�@]*/g, ""))
	{ alert(sName + G_MSG_NUMBER_ISNULL); oElmt.focus(); return false; }
	if ((sData = delCommer(sData)) == "ERR")
	{ alert(sName + G_MSG_NUMBER_ISNULL); oElmt.focus(); return false; }
	if (!chkNumber(sData, "2"))
	{ alert(sName + G_MSG_NUMBER_ISNULL); oElmt.focus(); return false; }
	if (!chkShosu(sData-0, nFore, nBack))
	{ alert(sName + G_MSG_NUMBER_SU_ERR); oElmt.focus(); return false; }
	return true;
}

//  ���͍��ځ@�ŏI"\"�@�`�F�b�N�֐�
// (���p�p���̍��ڃ`�F�b�N���s��)
// 
function chkLastCha(oVal)
{
	if (oVal.lastIndexOf("\\") >= 0 && oVal.lastIndexOf("\\") == (oVal.length - 1)) return false;
	return true;
}

//  E-mail���͍��ڃ`�F�b�N�֐�
// (E-mail�̍��ڃ`�F�b�N���s��)
// bNec		: �K�{�`�F�b�N
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

//  ���p�p�����͍��ڃ`�F�b�N�֐�
// (���p�p���̍��ڃ`�F�b�N���s��)
// bNec		: �K�{�`�F�b�N
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

//  �S�p�J�i���͍��ڃ`�F�b�N�֐�
// (�S�p�J�i�̍��ڃ`�F�b�N���s��)
// bNec		: �K�{�`�F�b�N
function chkZenkanaIn(oElmt, sName, nLen, bNec)
{
	if (bNec && !chkIsNec(oElmt, sName)) return false;
	if (!chkLastCha(oElmt.value))
	{ alert(sName + "�ɍŏI�g�p�o���Ȃ�����(\\)���܂܂�Ă��܂��B"); oElmt.focus(); return false; }
	if (!charCode(oElmt.value, 12449, 12540, 0))
	{ 
	
	alert(sName + TVGE0018); oElmt.focus(); return false; }
	if (oElmt.value.length*2 > nLen)
	{ alert(sName + G_MSG_CHAR_LARGE); oElmt.focus(); return false; }
	return true;
}

//  �Ђ炪�ȓ��͍��ڃ`�F�b�N�֐�
// (�Ђ炪�Ȃ̍��ڃ`�F�b�N���s��)
// bNec		: �K�{�`�F�b�N
function chkHiraganaIn(oElmt, sName, nLen, bNec)
{
	if (bNec && !chkIsNec(oElmt, sName)) return false;
	if (!chkLastCha(oElmt.value))
	{ alert(sName + "�ɍŏI�g�p�o���Ȃ�����(\\)���܂܂�Ă��܂��B"); oElmt.focus(); return false; }
	if (!charCode(oElmt.value, 12353,12435, 0))
	{ 
	
	alert(sName + TVGE0028); oElmt.focus(); return false; }
	if (oElmt.value.length*2 > nLen)
	{ alert(sName + G_MSG_CHAR_LARGE); oElmt.focus(); return false; }
	return true;
}

//  �`�F�b�N�������ߐ�
// (�������ߐ��`�F�b�N���s��)
// bNec		: �K�{�`�F�b�N
function chkByteLen(oElmt, sName, nLen, bNec)
{
	if (bNec && !chkIsNec(oElmt, sName)) return false;
	var sData = oElmt.value;
	if (!strLenB(oElmt.value, nLen))
	{ alert(sName + "��"+nLen+"byte�ȓ���ݒ肵�Ă��������B"); oElmt.focus(); return false; }
	return true;
}

//  �S�p���͍��ڃ`�F�b�N�֐�--����
// (�S�p�̍��ڃ`�F�b�N���s��)
// bNec		: �K�{�`�F�b�N
function chkZenkakuIn(oElmt, sName, nLen, bNec)
{
	if (bNec && !chkIsNec(oElmt, sName)) return false;	
	if (!strLen(oElmt.value, nLen))
	{ alert(sName + G_MSG_CHAR_LARGE); oElmt.focus(); return false; }
	return true;
}

//  �l�̌ܓ��֐�
// (�l�̌ܓ����s��)
// numCsr	: �ǂ̈ʂŁA�l�̌ܓ����s�Ȃ����B
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

//  ���ꕶ���u�������֐�
// & " ' , < >
function filterCode(sData)
{
	var tmp = sData;
	if (tmp == null) tmp = "";
	tmp = tmp.replace(/'/g, "�f");
	
	//tmp = tmp.replace(/&/g, "&#38;");
	//tmp = tmp.replace(/\"/g, "&#34;");
	//tmp = tmp.replace(/'/g, "&#39;");
	//tmp = tmp.replace(/,/g, "&#44;");
	//tmp = tmp.replace(/</g, "&lt;");
	//tmp = tmp.replace(/>/g, "&gt;");
	
	return tmp;
}

// ���ꕶ���u�������֐�
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
// �X�֔ԍ�
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
		alert("�p�X���[�h�m�F�ƃp�X���[�h�͈�v���Ȃ��B"); oElmt2.focus(); return false;
	}
	return true;
}

// email
function chkEmail1( oElmt, sName, nLen, bNec){
	var sData = oElmt.value;
	var filter=/(^[a-zA-Z]|^[a-zA-Z][\w-_\.]*[a-zA-Z0-9])@(\w+\.)+\w+$/;
	if (!strLenB(sData, nLen))
	{ alert(sName + "��"+nLen+"byte�ȓ���ݒ肵�Ă��������B"); oElmt.focus(); return false; }
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
		alert(sName + "���ڂ̃t�H�[�}�b�g�͐���������܂���B");
		oElmt.focus();
		return false;
	}
	if(date.substring(4,5)!="/"||date.substring(7,8)!="/"){
		alert(sName + "���ڂ̃t�H�[�}�b�g�͐���������܂���B");
		oElmt.focus();
		return false;
	}
	if(date.length != 10){
		alert(sName + "���ڂ̃t�H�[�}�b�g�͐���������܂���B");
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
		alert("�J�n���Ԃ��������Ԃ𒴂��Ă��܂��B");
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
		alert("�J�n���Ԃ��������Ԃ𒴂��Ă��܂��B");
		return false;
	}
	return true;
}

// �X�֔ԍ�
function chkZipcd(oElmt, sName, nLen, bNec)
{
	var filter=/^(\d{3})[\-](\d{4})$/;
	if (bNec && !chkIsNec(oElmt, sName)) return false;
	var sData = oElmt.value;
	if (!strLenB(oElmt.value, nLen))
	{ alert(sName + "��"+nLen+"byte�ȓ���ݒ肵�Ă��������B"); oElmt.focus(); return false; }
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
	{ alert(sName + "��"+nLen+"byte�ȓ���ݒ肵�Ă��������B"); oElmt.focus(); return false; }
	if (sData!=""){
		if (!filter.test(sData)){
			alert(sName + G_MSG_CHAR_ERR1); oElmt.focus(); return false;
		}
	}
	return true;
}

// ���[�U�[�R�[�h
function chkUsercd(oElmt, sName, nLen, bNec)
{
	var filter=/^[A-Z0-9]+$/;
	if (bNec && !chkIsNec(oElmt, sName)) return false;
	var sData = oElmt.value;
	if (!strLenB(oElmt.value, nLen))
	{ alert(sName + "��"+nLen+"byte�ȓ���ݒ肵�Ă��������B"); oElmt.focus(); return false; }
	if (sData!=""){
		if (!filter.test(sData)){
			alert(sName + G_MSG_CHAR_ERR1); oElmt.focus(); return false;
		}
	}
	return true;
}

// ���[�U�[�R�[�h
function chkCompanycd(oElmt, sName, nLen, bNec)
{
	var filter=/^[A-Z0-9]+$/;
	if (bNec && !chkIsNec(oElmt, sName)) return false;
	var sData = oElmt.value;
	if (!strLenB(oElmt.value, nLen))
	{ alert(sName + "��"+nLen+"byte�ȓ���ݒ肵�Ă��������B"); oElmt.focus(); return false; }
	if (sData!=""){
		if (!filter.exec(sData)){
			alert(sName + G_MSG_CHAR_ERR1); oElmt.focus(); return false;
		}
	}
	return true;
}

//��ЃR�[�h
function chkCompanycd(oElmt, sName, nLen, bNec)
{
	var filter=/^[A-Z0-9]+$/;
	if (bNec && !chkIsNec(oElmt, sName)) return false;
	var sData = oElmt.value;
	if (!strLenB(oElmt.value, nLen))
	{ alert(sName + "��"+nLen+"byte�ȓ���ݒ肵�Ă��������B"); oElmt.focus(); return false; }
	if (sData!=""){
		if (!filter.test(sData)){
			alert(sName + G_MSG_CHAR_ERR1); oElmt.focus(); return false;
		}
	}
	return true;
}



// �f���J�e�S���[
function chkbbsctgyCd(oElmt, sName, sChar)
{
	var temp=oElmt.value;
	if (temp == sChar)
	{	
		alert(sName + "�ɕK�{���͍��ڂ����͂���Ă��܂���B");
		oElmt.selected=false;
		return false;
	}
	return true;
}
function chkCustomer(oElmt, sName, nLen, bNec){
	if (bNec && !chkIsNec(oElmt, sName)) return false;
	if (!chkLastCha(oElmt.value))
	{ alert(sName + "�ɍŏI�g�p�o���Ȃ�����(\\)���܂܂�Ă��܂��B"); oElmt.focus(); return false; }
	if (!(charCode(oElmt.value, 12353,12435, 0)||charCode(oElmt.value, 12449, 12540, 0)))
	{ 
		alert(sName + TVGE0029); oElmt.focus(); return false; }
	if (oElmt.value.length*2 > nLen)
	{ alert(sName + G_MSG_CHAR_LARGE); oElmt.focus(); return false; }
	return true;
}





