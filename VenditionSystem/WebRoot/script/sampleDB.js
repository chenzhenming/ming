function accDB(){
	accDB = [[],[]];
	accDB[0][1] = "アカウントコード";
	accDB[0][2] = "アカウント区分";
	accDB[0][3] = "氏名";
	accDB[0][4] = "氏名カナ";
	accDB[0][5] = "パスワード";
	accDB[0][6] = "パスワード発行日";
	accDB[0][7] = "チェーンコード";
	accDB[0][8] = "店舗コード";
	accDB[0][9] = "メーカーコード";
	accDB[0][10] = "郵便番号";
	accDB[0][11] = "住所1";
	accDB[0][12] = "住所2";
	accDB[0][13] = "TEL";
	accDB[0][14] = "携帯TEL";
	accDB[0][15] = "FAX";
	accDB[0][16] = "メールアドレス";
	accDB[0][17] = "備考";
	accDB[0][18] = "アカウント開始日";
	accDB[0][19] = "アカウント終了日";
	accDB[0][20] = "アカウント停止フラグ";
	accDB[0][21] = "最終ログイン日時";

	accDB[1][1] = "coo1";
	accDB[1][2] = "組合";
	accDB[1][3] = "css";
	accDB[1][4] = "シーエスエス";
	accDB[1][5] = "001";
	accDB[1][6] = "2005/11/8 15:15:15";
	accDB[1][7] = "---";
	accDB[1][8] = "---";
	accDB[1][9] = "---";
	accDB[1][10] = "%郵便番号";
	accDB[1][11] = "%住所1";
	accDB[1][12] = "%住所2";
	accDB[1][13] = "%TEL";
	accDB[1][14] = "%携帯TEL";
	accDB[1][15] = "%FAX";
	accDB[1][16] = "@メールアドレス";
	accDB[1][17] = "備考";
	accDB[1][18] = "%アカウント開始日";
	accDB[1][19] = "%アカウント終了日";
	accDB[1][20] = "%アカウント停止フラグ";
	accDB[1][21] = "%最終ログイン日時";
}

function sampleDB_BBS(){
	bbstext0 = new Array();
	bbstext0[0] = "掲示板番号";
	bbstext0[1] = "カテゴリ";
	bbstext0[2] = "タイトル";
	bbstext0[3] = "内容";
	bbstext0[4] = "添付ファイル";
	bbstext0[5] = "掲示期日";
	bbstext0[6] = "JAN";
	bbstext0[7] = "MD区分";
	bbstext0[8] = "FL区分";
	bbstext0[9] = "記入者";
	
	bbstext1 = new Array("1","商品案内","PS3発売日のお知らせ","あのＰＳ２の後継機ＰＳ３がついに発売されます。値段は198000円。<br><img src='./img/ps3.jpg'","2005/11/5","123-456-78900","0","0","山田太郎");
}

function DB(){
	DB = [[],[],[],[]];

	DB[0][0] = "JAN";
	DB[0][1] = "タイトル";
	DB[0][2] = "メーカー";
	DB[0][3] = "中分類";
	DB[0][4] = "小分類";
	DB[0][5] = "発売日";
	DB[0][6] = "本体価格";
	DB[0][7] = "テスト期間";
	DB[0][8] = "テスト店数";
	DB[0][9] = "状態";
	DB[0][10] = "実績情報";
	DB[0][11] = "店舗情報";
	DB[0][12] = "設定情報";

	DB[1][0] = "1111111111";
	DB[1][1] = "ゲームソフトＡ";
	DB[1][2] = "ＡＡＡＡＡＡ";
	DB[1][3] = "ＡＡＡＡ";
	DB[1][4] = "ＡＡＡＡ";
	DB[1][5] = "2005/3/31";
	DB[1][6] = "4,800";
	DB[1][7] = "3ヶ月";
	DB[1][8] = "30";
	DB[1][9] = "実施";
	DB[1][10] = '<a href="./FLPerf.html">照会</a>';
	DB[1][11] = "<a href='./FLShop.html'>登録</a>";
	DB[1][12] = "<a href='./FLConf.html'>設定</a>";

	DB[2][0] = "2222222222";
	DB[2][1] = "ゲームソフトＢ";
	DB[2][2] = "ＢＢＢＢＢＢ";
	DB[2][3] = "ＢＢＢＢ";
	DB[2][4] = "ＢＢＢＢ";
	DB[2][5] = "2005/4/10";
	DB[2][6] = "5,800";
	DB[2][7] = "2ヶ月";
	DB[2][8] = "0";
	DB[2][9] = "仮登録";

	DB[3][0] = "3333333333";
	DB[3][1] = "ゲームソフトＣ";
	DB[3][2] = "ＣＣＣＣＣＣ";
	DB[3][3] = "ＣＣＣＣ";
	DB[3][4] = "ＣＣＣＣ";
	DB[3][5] = "2005/3/10";
	DB[3][6] = "5,200";
	DB[3][7] = "3ヶ月";
	DB[3][8] = "15";
	DB[3][9] = "実施";
}

function FLDB(){
	FLDB = [[],[],[],[]];

	FLDB[1][0] = "03/31";	//期間
	FLDB[1][1] = "968";	//新品　販売数
	FLDB[1][2] = "96800";	//販売金額
	FLDB[1][3] = "1877";	//仕入数
	FLDB[1][4] = "93850";	//仕入金額
	FLDB[1][5] = "-23";	//調整数
	FLDB[1][6] = "1610";	//調整金額
	FLDB[1][7] = "0";	//中古　販売数
	FLDB[1][8] = "0";	//販売金額
	FLDB[1][9] = "5";	//買取数
	FLDB[1][10] = "400";	//買取金額
	FLDB[1][11] = "3";	//調整数
	FLDB[1][12] = "300";	//調整金額

	FLDB[2][0] = "04/01";	//期間
	FLDB[2][1] = "1";	//新品　販売数
	FLDB[2][2] = "1";	//販売金額
	FLDB[2][3] = "1";	//仕入数
	FLDB[2][4] = "1";	//仕入金額
	FLDB[2][5] = "1";	//調整数
	FLDB[2][6] = "1";	//調整金額
	FLDB[2][7] = "1";	//中古　販売数
	FLDB[2][8] = "1";	//販売金額
	FLDB[2][9] = "1";	//買取数
	FLDB[2][10] = "1";	//買取金額
	FLDB[2][11] = "1";	//調整数
	FLDB[2][12] = "1";	//調整金額

	FLDB[3][0] = "週合計";	//期間
	FLDB[3][1] = "1";	//新品　販売数
	FLDB[3][2] = "1";	//販売金額
	FLDB[3][3] = "1";	//仕入数
	FLDB[3][4] = "1";	//仕入金額
	FLDB[3][5] = "1";	//調整数
	FLDB[3][6] = "1";	//調整金額
	FLDB[3][7] = "1";	//中古　販売数
	FLDB[3][8] = "1";	//販売金額
	FLDB[3][9] = "1";	//買取数
	FLDB[3][10] = "1";	//買取金額
	FLDB[3][11] = "1";	//調整数
	FLDB[3][12] = "1";	//調整金額
}

function setRS(num){
	FLDBdate	= FLDB[num][0];
	new_sell	= FLDB[num][1];
	new_sellMony	= FLDB[num][2];
	new_stock	= FLDB[num][3];
	new_stockMony	= FLDB[num][4];
	new_adjus	= FLDB[num][5];
	new_adjusMony	= FLDB[num][6];
	use_sell	= FLDB[num][7];
	use_sellMony	= FLDB[num][8];
	use_buy		= FLDB[num][9];
	use_buyMony	= FLDB[num][10];
	use_adjus	= FLDB[num][11];
	use_adjusMony	= FLDB[num][12];

	result = new Array();
	result[0] = FLDBdate;
	result[1] = new_sell;
	result[2] = new_sellMony;
	result[3] = (new_sellMony/new_sell);
	result[4] = new_stock;
	result[5] = new_adjus;
	result[6] = Math.round(new_sell/new_adjus);
	result[7] = (new_stock-new_sell+new_adjus*1);
	result[8] = use_sell;
	result[9] = use_sellMony;
	result[10] = (use_sellMony/use_sell);
	result[11] = use_buy;
	result[12] = use_buyMony;
	result[13] = (use_buyMony/use_buy);
	result[14] = use_buy;
	result[15] = "sample";
	result[16] = "sample";
	result[17] = "sample";
	result[18] = "sample";
	result[19] = "sample";
	result[20] = "sample";
	result[21] = "sample";
	result[22] = "sample";
	result[23] = "sample";
	result[24] = "sample";
	result[25] = "sample";
}

function syohinMas(){
	sitem = [[],[],[]];
	sitem[0][0] = "ＪＡＮコード";
	sitem[0][1] = "商品名称";
	sitem[0][2] = "商品名称カナ";
	sitem[0][3] = "商品名称２";
	sitem[0][4] = "商品名称２カナ";
	sitem[0][5] = "アーティスト名";
	sitem[0][6] = "アーティスト名カナ";
	sitem[0][7] = "商品サブタイトル";
	sitem[0][8] = "商品正式名称";
	sitem[0][9] = "商品付属品情報";
	sitem[0][10] = "大分類コード";
	sitem[0][11] = "中分類コード";
	sitem[0][12] = "小分類コード";
	sitem[0][13] = "規格番号";
	sitem[0][14] = "メーカーコード";
	sitem[0][15] = "発売日";
	sitem[0][16] = "発売日名称";
	sitem[0][17] = "本体価格";
	sitem[0][18] = "税込価格";
	sitem[0][19] = "オープン価格区分";
	sitem[0][20] = "製造中止フラグ";
	sitem[0][21] = "商品コメント";

	sitem[1][0] = "111 1111 1111";
	sitem[1][1] = "ＡＡＡＡＡＡ";
	sitem[1][2] = "エー６";
	sitem[1][3] = "aaaaaa";
	sitem[1][4] = "エー⑥";
	sitem[1][5] = "ＣＳＳ";
	sitem[1][6] = "シーエスエス";
	sitem[1][7] = "サブタイＡ";
	sitem[1][8] = "正式ＡＡＡＡＡＡ";
	sitem[1][9] = "ポスター";
	sitem[1][10] = "大分類:ＸＸＸ";
	sitem[1][11] = "中分類:プレステ";
	sitem[1][12] = "小分類:ｘｘｘ";
	sitem[1][13] = "規格番号:ｘｘ";
	sitem[1][14] = "メーカーコード:111";
	sitem[1][15] = "2005/11/8";
	sitem[1][16] = "11月上旬";
	sitem[1][17] = "5890";
	sitem[1][18] = "6200";
	sitem[1][19] = "オープン価格区分";
	sitem[1][20] = "製造中止フラグ";
	sitem[1][21] = "商品コメント:コメント";

	sitem[2][0] = "HELP:ＪＡＮコード";
	sitem[2][1] = "HELP:商品名称";
	sitem[2][2] = "HELP:商品名称カナ";
	sitem[2][3] = "HELP:商品名称２";
	sitem[2][4] = "HELP:商品名称２カナ";
	sitem[2][5] = "HELP:アーティスト名";
	sitem[2][6] = "HELP:アーティスト名カナ";
	sitem[2][7] = "HELP:商品サブタイトル";
	sitem[2][8] = "HELP:商品正式名称";
	sitem[2][9] = "HELP:商品付属品情報";
	sitem[2][10] = "HELP:大分類コード";
	sitem[2][11] = "HELP:中分類コード";
	sitem[2][12] = "HELP:小分類コード";
	sitem[2][13] = "HELP:規格番号";
	sitem[2][14] = "HELP:メーカーコード";
	sitem[2][15] = "HELP:発売日";
	sitem[2][16] = "HELP:発売日名称";
	sitem[2][17] = "HELP:本体価格";
	sitem[2][18] = "HELP:税込価格";
	sitem[2][19] = "HELP:オープン価格区分";
	sitem[2][20] = "HELP:製造中止フラグ";
	sitem[2][21] = "HELP:商品コメント";
}

function MDDBEnt(){
	MDDBEnt = [[],[],[]];
	MDDBEnt[0][0] = 'タイトル';
	MDDBEnt[0][1] = 'メーカー';
	MDDBEnt[0][2] = '中分類';
	MDDBEnt[0][3] = '小分類';
	MDDBEnt[0][4] = '発売日';
	MDDBEnt[0][5] = '本体価格';
	MDDBEnt[0][6] = 'マークダウン設定';
	MDDBEnt[0][7] = 'マークダウン登録';

	MDDBEnt[1][0] = 'ゲームＡ';
	MDDBEnt[1][1] = 'ＡＡＡＡＡＡ';
	MDDBEnt[1][2] = 'ＡＡＡＡ';
	MDDBEnt[1][3] = 'ｘｘｘ';
	MDDBEnt[1][4] = '2005/3/31';
	MDDBEnt[1][5] = '4800';
	MDDBEnt[1][6] = '-';
	MDDBEnt[1][7] = '<a href="./MDconEdit.html">登録</a>';
}
function MDDBRef(){
	MDDB = [[],[],[]];
	MDDB[0][0] = "タイトル";
	MDDB[0][1] = "メーカー";
	MDDB[0][2] = "中分類";
	MDDB[0][3] = "小分類";
	MDDB[0][4] = "発売日";
	MDDB[0][5] = "本体価格";
	MDDB[0][6] = "テスト期間";
	MDDB[0][7] = "テスト店数";
	MDDB[0][8] = "補填状態<br>(最終集計表)";
	MDDB[0][9] = "実績照会";
	MDDB[0][10] = "店舗情報";
	MDDB[0][11] = "設定情報";
	MDDB[0][12] = "補填状況";

	MDDB[1][0] = "ＡＡＡＡＡＡ";
	MDDB[1][1] = "ＡＡＡＡ";
	MDDB[1][2] = "プレステ";
	MDDB[1][3] = "ｘｘｘ";
	MDDB[1][4] = "未定";
	MDDB[1][5] = "4800";
	MDDB[1][6] = "3ヶ月8週";
	MDDB[1][7] = "30";
	MDDB[1][8] = "実施(2週～04/14)";
}