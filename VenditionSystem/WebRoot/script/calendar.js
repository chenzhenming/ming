function puchi(year,month,date,youbi,cellname,cellnum){

	var stdyear =  year;
	var stdmonth = month;
	var stddate = date;
	var stdyoubi = youbi;

	//基準日(クライアントで設定された今日の日付)
	var today = new Date();
	var thisyear =  today.getFullYear();
	var thismonth = (today.getMonth()+1);
	var thisdate = today.getDate();

	//曜日、月末日設定
	var youbi = new Array('','月','','水','木','金','土');
	var misoka = new Array('','31','28','31','30','31','30','31','31','30','31','30','31');
	if ( ((stdyear%4)==0 && (stdyear%100)!=0) || (stdyear%400)==0 )
	misoka[2] = 29;

	//一日処理
	var fstdate = stddate;
	var fstyoubi = stdyoubi;
	while(fstdate >= 2){
		fstyoubi = (fstyoubi-1);
		if(fstyoubi < 0){fstyoubi=6;}
		fstdate = (fstdate-1);
	}

	//先月処理
	if(stdmonth-1 < 1){
		lastyear = stdyear-1;
		lastmonth = 12;
		lastdate = misoka[lastmonth];
		if((fstyoubi-1) < 0){lastyoubi = 6;}else{lastyoubi = fstyoubi-1;};
	}else{
		lastyear = stdyear;
		lastmonth = stdmonth-1;
		lastdate = misoka[lastmonth];
		if((fstyoubi-1) < 0){lastyoubi = 6;}else{lastyoubi = fstyoubi-1;};
	}
	
	//先月晦日
	lastdate = misoka[lastmonth];

	//来月処理
	if(stdmonth == 12){
		var nextmonth = 1;
		var nextyear = stdyear*1+1;
	}else{
		var nextmonth = stdmonth*1+1;
		var nextyear= stdyear;
	}
	//テーブル開始
	calhtml = '<table style="border:outset 3px #eeeeee; background:#999999;"><tr>';
	calhtml += '<td colspan="6" style="border:solid #bbbbbb;border-width:2px 0px 2px 2px;background:#223388;" onMousedown=(flag=1,fstx=event.offsetX,fsty=event.offsetY)></td><td style="border:solid #bbbbbb;border-width:2px 2px 2px 0px;background:#223388;text-align:right;">';
	calhtml += '<input type="button" class="button" style="border:outset 1px #dddddd;font:11px bold;height:13px;width:13px;background:#bbbbbb;" value="×" onClick="hidecal()"></td>';

	calhtml += '</tr><tr>';
	calhtml += '<td title="去年"><input type="button" class="button" value="<<" onCLick=lastYear("'+cellname+'","'+cellnum+'")></td>';
	calhtml += '<td title="先月"><input type="button" class="button" value="<" onClick=lastMonth("'+cellname+'","'+cellnum+'")></td>';
	calhtml += '<td colspan="3"><input type="button"  class="button" style="font:12px;text-align:center;width:100%;" value="'+stdyear+'/'+stdmonth+'"></td>';
	calhtml += '<td title="来月"><input type="button" class="button" value=">" onClick=nextMonth("'+cellname+'","'+cellnum+'")></td>';
	calhtml += '<td title="来年"><input type="button" class="button" value=">>" onCLick=nextYear("'+cellname+'","'+cellnum+'")></td>';
	calhtml += '</tr><tr>';

	//曜日
	i=0;
	for(i=0;i<=6;i++){
		if(i==0){color="#eeccdd";}else{color="#ccddee";}
		calhtml += '<td><input type="button" style="font:10px;border:solid 1px '+ color +';background:'+ color +';text-align:center;height:20px;width:20px;" value="'+youbi[i]+'"></td>';
	}
	calhtml += '</tr><tr>';

	//先月末表示
	for(i=1;i<=(fstyoubi);i++){
		calhtml += '<td title="'+lastyear+'/'+lastmonth+'/'+(lastdate-fstyoubi+i)+'"><input class="bm" type="button" value="'+ (lastdate-fstyoubi+i) +'" onClick=getvalue("'+lastyear+'","'+lastmonth+'","'+(lastdate-fstyoubi+i)+'","'+cellname+'","'+cellnum+'")></td>';
	}

	//出力用　曜日
	var countdate = 1;
	var countyoubi = fstyoubi;

	//日時出力
	//countyoubi が７になると改行
	while(countdate-1 != misoka[stdmonth]){
		if((thisyear==stdyear)&&(thismonth == stdmonth)&&(thisdate == countdate)){color="#ee9922";}else{color="#ffffff";}
		calhtml += '<td title="'+stdyear+'/'+stdmonth+'/'+countdate+'"><input class="tm" style="background:'+color+';" type="button" value="'+countdate+'" onClick=getvalue("'+stdyear+'","'+stdmonth+'","'+countdate+'","'+cellname+'","'+cellnum+'")></td>';
		countdate++;
		countyoubi++;
		if(countyoubi == 7){
			countyoubi = 0;
			calhtml += '</tr><tr>';
		}
	}

	//来月１日
	var nextdate = 1;
	var nextyoubi = eval(fstyoubi) + misoka[stdmonth]%7;
	if(nextyoubi > 6){nextyoubi = nextyoubi-7;};

	while(countyoubi < 7){
		countyoubi += 1;
		calhtml += '<td><input class="bm" type="button" value="'+nextdate+'" onClick=getvalue("'+nextyear+'","'+nextmonth+'","'+nextdate+'","'+cellname+'","'+cellnum+'")></td>';
		nextdate += 1;
	}

	calhtml += '</tr></table>';

	document.op.by.value=lastyear;
	document.op.bm.value=lastmonth;
	document.op.bd.value=lastdate;
	document.op.byo.value=lastyoubi;

	document.op.y.value=stdyear;
	document.op.m.value=stdmonth;
	document.op.d.value=fstdate;
	document.op.yo.value=fstyoubi;

	document.op.ny.value=nextyear;
	document.op.nm.value=nextmonth;
	document.op.nd.value=1;
	document.op.nyo.value=nextyoubi;
	//来年に移動する時に来年が閏年か判定する
	//来年が閏年で来年の2月をまたぐ場合
	//一年は３６６日になるので、日付のずれは２日になる。
	//前年の３月～２月に年移動する場合は２日
	//それ以外の場合は１日ずれることになる。
	uy=document.op.y.value;
	um=document.op.m.value;
	ud=document.op.d.value;
	uyo=document.op.yo.value;
	ippo = 1;
	backer = 1;

	//来年が閏年の場合で加年の処理
	if ( (((uy*1+1)%4)==0 && ((uy*1+1)%100)!=0) || ((uy*1+1)%400)==0 ){
		if(stdmonth > 2){ippo = 2;}
	}
	//今年が閏年の場合で加年の処理
	if ( ((uy%4)==0 && (uy%100)!=0) || (uy%400)==0 ){
		if(stdmonth <= 2){ippo = 2;}
	}
	//今年が閏年の場合で減年の処理
	if ( ((uy%4)==0 && (uy%100)!=0) || (uy%400)==0 ){
		if(stdmonth > 2){backer = 2;}
	}
	//去年が閏年の場合で減年の処理
	if ( (((uy*1-1)%4)==0 && ((uy*1-1)%100)!=0) || ((uy*1-1)%400)==0 ){
		if(stdmonth <= 2){backer = 2;}
	}

	nuyo = uyo*1+ippo*1
	if(nuyo > 6){nuyo = nuyo-7;}
	document.op.nny.value = uy*1+1;
	document.op.nnm.value = um;
	document.op.nnd.value = 1;
	document.op.nnyo.value = nuyo;

	buyo = uyo*1-backer*1
	if(buyo < 0){buyo = buyo+7;}
	document.op.bby.value = uy*1-1;
	document.op.bbm.value = um;
	document.op.bbd.value = 1;
	document.op.bbyo.value = buyo;

	return calhtml;
}
function getCalendar(y,m,d,yo,cellname,cellnum){
	document.getElementById('cell').innerHTML = puchi(y,m,d,yo,cellname,cellnum);
}
function lastMonth(cellname,cellnum){
	y=document.op.by.value;
	m=document.op.bm.value;
	d=document.op.bd.value;
	yo=document.op.byo.value;
	getCalendar(y,m,d,yo,cellname,cellnum);
}
function nextMonth(cellname,cellnum){
	y=document.op.ny.value;
	m=document.op.nm.value;
	d=document.op.nd.value;
	yo=document.op.nyo.value;
	getCalendar(y,m,d,yo,cellname,cellnum);
}
function nextYear(cellname,cellnum){
	y=document.op.nny.value;
	m=document.op.nnm.value;
	d=document.op.nnd.value;
	yo=document.op.nnyo.value;
	getCalendar(y,m,d,yo,cellname,cellnum);
	
}
function lastYear(cellname,cellnum){
	y=document.op.bby.value;
	m=document.op.bbm.value;
	d=document.op.bbd.value;
	yo=document.op.bbyo.value;
	getCalendar(y,m,d,yo,cellname,cellnum);
	
}
function getvalue(y,m,d,cellname,cellnum){
	if(d<10){d="0"+d;}else{d=d;}
	if(m<10){m="0"+m;}else{m=m;}
	
	document.getElementsByName(cellname)[cellnum].innerText = y + "/" + m + "/" + d;
	document.getElementById('cell').style.display = 'none';
}
function hidecal(){
	document.getElementById('cell').style.display = 'none';
}
function showCalendar(cellname,cellnum){
	//基準日(クライアントで設定された今日の日付)
	var today = new Date();
	var clientyear =  today.getFullYear();
	var clientmonth = (today.getMonth()+1);
	var clientdate = today.getDate();
	var clientyoubi = today.getDay();

	var calenderbody = document.getElementById('cell');
	calenderbody.style.top = event.y+document.body.scrollTop+10;
	calenderbody.style.left = event.x+document.body.scrollLeft+10;
	calenderbody.style.display = 'block';
	
	getCalendar(clientyear,clientmonth,clientdate,clientyoubi,cellname,cellnum);
}


flag=2;
fstx='';
fsty='';
function movecell(x,y){
	if(flag%2 != 0){
		var gotox = x+document.body.scrollLeft-fstx;
		var gotoy = y+document.body.scrollTop-fsty;
		document.getElementById('cell').style.left = gotox;
		document.getElementById('cell').style.top = gotoy;
	}
}
function fun1(){
alert("afasdfsadf");
}