//�T�u�E�B���h�E�I�[�v��
//(�E�B���h�E�̃^�C�g���A���e�A�E�B���h�E�̍����A���A�E�B���h�E�l�[��)
function Open_Subwin(title,msg,h,w,wn){
	newWin = window.open("",wn,"height="+h+",width="+w+",scrollbars=1,resizable=1","");
	newWin.document.open('text/html');
	newWin.document.writeln('<html><head>');
	newWin.document.writeln('<meta name="robots" content="noindex,nofollow">');
	newWin.document.writeln('<meta http-equix="Content-Type" content="text/html; charset=shift_jis">');
	newWin.document.writeln('<meta http-equiv="Content-Style-Type" content="text/css">');
	newWin.document.writeln('<meta http-equiv="Content-Script-Type" content="text/javascript">');
	newWin.document.writeln('<link rel="stylesheet" href="styleset_basic.css" type="text/css">');
	newWin.document.writeln('<title>'+ title +'</title>\n</head>\n<body>');
	newWin.document.writeln('<table style="width:100%;background:#ffffff;margin:0px;">');
	newWin.document.writeln(msg);
	newWin.document.writeln('</table>');
	newWin.document.writeln('</body></html>');
	newWin.document.close();
	newWin.focus();
}
//�}�X�^�����e�n�e�[�u���J��
function ent(){
	if(j=='0'){
	document.getElementById("entry").style.display = "block";j=1;
	}else{
	document.getElementById("entry").style.display = "none";j=0;
	}
}

function opengazou(id,flag){
	tf = flag;
	if(flag = tf){
	document.getElementById(id+'0').style.display = "block";
	document.getElementById(id+'1').style.display = "block";
	}else{
	document.getElementById(id+'0').style.display = "none";
	document.getElementById(id+'1').style.display = "none";
	}
}

//���j���[�쐬
//(�y�[�W���)
function MakeMenu(pval){
	Link_Array();
	var str = '<!-- �l�d�m�t���� -->'+
	'<div id="menu" class="menu_list" style="width:123;height:100%;text-align:right;">'+
	'<span id="mbar1" class="menu_title">�f����</span><br>'+
	'<a href="'+ Link_Array[0][2] +'">'+ Link_Array[1][2] +'</a><br>'+
	'<a href="'+ Link_Array[0][1] +'">'+ Link_Array[1][1] +'</a><br>'+

	'<span id="mbar2" class="menu_title">�}�[�N�_�E��</span><br>'+
	'<a href="'+ Link_Array[0][3] +'">'+ Link_Array[1][3] +'</a><br>'+
	'<a href="'+ Link_Array[0][5] +'">'+ Link_Array[1][5] +'</a><br>'+

	'<span id="mbar3" class="menu_title">�t�����C���i�b�v</span><br>'+
	'<a href="'+ Link_Array[0][11] +'">'+ Link_Array[1][11] +'</a><br>'+
	'<a href="'+ Link_Array[0][13] +'">'+ Link_Array[1][13] +'</a><br>'+

	'<span id="mbar4" class="menu_title">���i�Ǘ�</span><br>'+
	'<a href="'+ Link_Array[0][19] +'">'+ Link_Array[1][19] +'</a><br>'+
	'<a href="'+ Link_Array[0][18] +'">'+ Link_Array[1][18] +'</a><br>'+
	'<a href="'+ Link_Array[0][25] +'">'+ Link_Array[1][25] +'</a><br>'+
	'<a href="'+ Link_Array[0][20] +'">'+ Link_Array[1][20] +'</a><br>'+
	'<a href="'+ Link_Array[0][21] +'">'+ Link_Array[1][21] +'</a><br>'+

	'<span id="mbar5" class="menu_title">�}�X�^�Ǘ�</span><br>'+
	'<a href="'+ Link_Array[0][22] +'">'+ Link_Array[1][22] +'</a><br>'+
	'<a href="'+ Link_Array[0][23] +'">'+ Link_Array[1][23] +'</a><br>'+
	'<a href="'+ Link_Array[0][24] +'">'+ Link_Array[1][24] +'</a><br>'+
	'<a href="'+ Link_Array[0][28] +'">'+ Link_Array[1][28] +'</a><br>'+

	'<span id="mbar6" class="menu_title">�V�X�e���Ǘ�</span><br>'+
	'<a href="'+ Link_Array[0][27] +'">'+ Link_Array[1][27] +'</a><br>'+
	'<a href="'+ Link_Array[0][29] +'">'+ Link_Array[1][29] +'</a><br>'+
	'<a href="'+ Link_Array[0][30] +'">'+ Link_Array[1][30] +'</a><br>'+
	'<a href="'+ Link_Array[0][31] +'">'+ Link_Array[1][31] +'</a><br>'+
	'</div>';

	document.write(str);
	if(pval == 'bbs'){pnum = 1;}
	if(pval == 'MD'){pnum = 2;}
	if(pval == 'FL'){pnum = 3;}
	if(pval == 'Item'){pnum = 4;}
	if(pval == 'Mas'){pnum = 5;}
	if(pval == 'Sys'){pnum = 6;}
	document.getElementById('mbar'+pnum).style.backgroundColor = "#669977";
	document.getElementById('mbar'+pnum).style.color = "#ffffff";
}

//�����N��ɃW�����v
//(�����N��̔ԍ�Link_Array���Q�ƁA�p�����[�^�[�̃^�O�A�p�����[�^�[)
function Link_Act(num,tag,param){
	if(tag == ''){
		uri = Link_Array[0][num];
	}else{
		uri = Link_Array[0][num] + '?' + tag + '=' + param;
	}
	location.href = uri;
}

//�T�[�`�o�[
//(�y�[�W���)
function Search_Bar(page_num){
	document.write('<a name="top"><table width="256" class="bar"><tr>');
	document.write('<td class="bar" colspan="6">'+Link_Array[1][page_num]+'</td>');
	document.write('</tr></table>');
}

//�e�[�u���J�t�@���N�V����
//(�J�������I�u�W�F�N�g�̂h�c�A����s��)
function Tab_Action(idname,num){
	if(l==1){
		for(i=1;i<=num;i++){
			document.getElementById(idname+'['+ i +']').style.display = "none";
		}
		l=0;
	}else{
		for(i=1;i<=num;i++){
			document.getElementById(idname+'['+ i +']').style.display = "block";
		}
		l=1;
	}
}

//�U�{�^���쐬
//(�F��ς���I�u�W�F�N�g�A���̐F�A�������Ƃ��̐F)
function Push_button(id,defcol,pushcol){
	document.getElementById(id).style.backgroundColor = pushcol;
}
//�U�{�^���쐬
function Up_button(id,defcol,pushcol){
	document.getElementById(id).style.backgroundColor = defcol;
}

//���i�R�[�h�������y�[�W
//var objItemCd;
/*function openSearch(obj)
{
 objItemCd = obj;
 window.open('ItemSearch.html','searchData', 'height=330, width=450, top=260, left=530, toolbar=no, menubar=no, scrollbars=yes, resizable=no,location=n o, status=yes');
}*/
//���i�R�[�h�������y�[�W
var objJanCd;
function openSearchItem(obj)
{
 objJanCd = obj;
 window.open('ItemSearchAction.do?method=find_blank','searchData', 'height=330, width=650, top=260, left=330, toolbar=no, menubar=no, scrollbars=yes, resizable=no,location=n o, status=yes');
}
//�X�܃R�[�h�������y�[�W
var objShopCd;
function openSearchShop(obj)
{
 objShopCd = obj;
 window.open('ShopListAction.do?method=find_blank','searchData', 'height=410, width=450, top=260, left=530, toolbar=no, menubar=no, scrollbars=yes, resizable=no,location=n o, status=yes');
}
//�e�[�u���J�t�@���N�V����
//(�J�������I�u�W�F�N�g�̂h�c�A����s��,�t���O)
function Tab_Action1(idname,num,flag){
	if(flag%2!=0){
		for(i=1;i<=num;i++){
			document.getElementById(idname+'['+ i +']').style.display = "none";
			document.getElementById(idname+'_point').innerHTML = '�J����';
		}
		
	}else{
		for(i=1;i<=num;i++){
			document.getElementById(idname+'['+ i +']').style.display = "block";

			document.getElementById(idname+'_point').innerHTML = '����~';
		}
	}
}

//�U�{�^���쐬
//(�F��ς���I�u�W�F�N�g�A���̐F�A�������Ƃ��̐F)
function Push_button(id,num){
	tag_span = document.getElementById(id);
	//�����
	if(num == 1){
			tag_span.style.borderWidth = '1px 1px 1px 1px';
			tag_span.style.borderColor = '#fff #555 #555 #fff';
	}
	//������
	if(num == 2){
			tag_span.style.borderWidth = '1px 1px 1px 1px';
			tag_span.style.borderColor = '#555 #fff #fff #555';
	}
	//������
	if(num == 3){
			tag_span.style.borderWidth = '1px 1px 1px 1px';
			tag_span.style.borderColor = '#fff #555 #555 #fff';
	}
	//���ꂽ
	if(num == 4){
			tag_span.style.borderWidth = '1px 1px 1px 1px';
			tag_span.style.borderColor = '#fff #555 #555 #fff';
	}
}