/**
 *
 */
//数字出力問題
//問１
function q1(){
	var max=30;
	for(var i=1; i<=max; i++){
		document.write(i+" ");
	}
}
//問２
function q2(){
	var max=30;
	for(var i=1; i<=max; i++){
		if(i%3 == 0){
			document.write(i+" ");
		}
	}
}
//問３
function q3(){
	var max=100;
	var count=0;

	for(var i=1; i<=max; i++){
		if(i%3 == 0){
			document.write(i+" ");
			count++;
		}
		if(count==30)break;
	}
}
//問４
function q4(){
	var max=100;
	var count=0;

	for(var i=1; i<=max; i++){
		if(i%3 == 0){
			document.write(i+" ");
			count++;
		}
		if(count !=0 && count%10 == 0)document.write("<br>");
		if(count==30)break;
	}
}
//追加問題
function ex4(){
	var max=100;
	var count=0;
	var limit=10;
	var num=5;

	for(var i=1; i<=max; i++){
		if(i%num == 0){
			document.write(i+" ");
			count++;
		}
		if(count !=0 && count%10 == 0)document.write("<br>");
		if(count==limit)break;
	}
}

//★★出力問題
//問１
function q5(){
	var max=5;
	for(var i=1; i<=max; i++){
		document.write("★");
	}
}
//問２
function q6(){
	var max=25;
	var count=0;

	for(var i=1; i<=max; i++){
		document.write("★");
		count++;
			if(count !=0 && count%5 == 0){
				document.write("<br>");
			}
	}
}
//問３
function q7(){
	var max=25;
	var count=0;

	for(var i=1; i<=max; i++){
		if(i%2 == 0){
			document.write("☆");
			count++;
		}else{
			document.write("★");
			count++;
		}
		if(count !=0 && count%5 == 0)document.write("<br>");
	}
}
//問４
function q8(){
	var max=25;
	var count=0;

	for(var i=1; i<=max; i++){
		if(i == 1 || i%6 == 1){
			document.write("☆");
			count++;
		}else{
			document.write("★");
			count++;
		}
		if(count !=0 && count%5 == 0)document.write("<br>");
	}
}
//問５
function q9(){
	var max=5;
	var count=0;

	for(var i=1; i<=max; i++){
		for(var j=1; j<=max; j++){
			if(j<=i){
				document.write("★");
				count++;
			}else{
				document.write(" ");
				count++;
			}
		}
	if(count !=0 && count%5 == 0)document.write("<br>");
	}
}
//問６
function q10(){
	var max=5;
	var count=0;

	for(var i=1; i<=max; i++){
		for(var j=1; j<=max; j++){
			if(j == i){
				document.write("☆");
				count++;
			}else if(j<=i){
				document.write("★");
				count++;
			}else{
				document.write(" ");
				count++;
			}
		}
	if(count !=0 && count%5 == 0)document.write("<br>");
	}
}
//問７
function q11(){
	var max=5;
	var count=0;

	for(var i=1; i<=max; i++){
		for(var j=1; j<=max; j++){
			if(j+i <= 6){
				document.write("★");
				count++;
			}else{
				document.write(" ");
				count++;
			}
		}
	if(count !=0 && count%5 == 0)document.write("<br>");
	}
}

//素数問題
//問１
function q12(){
	var max=100;
	for(var i=2; i<=max; i++){
		if(i == 2 || i == 3|| i == 5|| i == 7){
			document.write(i+" ");
		}else if(i%2 != 0 && i%3 != 0 && i%5 != 0 && i%7 != 0){
			document.write(i+" ");
		}
	}
}
//問２
function q13(){
	var max=60;
	var count=0;
	for(var i=2; i<=max; i++){
		if(i == 2 || i == 3|| i == 5|| i == 7){
			count++;
			document.write(i+" ");
		}else if(i%2 != 0 && i%3 != 0 && i%5 != 0 && i%7 != 0){
			count++;
			document.write(i+" ");
		}
	}
	document.write("<br>"+max+"までの中に素数は"+count+"個");
}

//自動販売機問題
//問１
function q14(){
	var purse=110;
	document.write("所持金は"+purse+"円です");
}
//問２
function q15(){
	var products = [	["水",100],
	                	["コーラ",150],
	                	["ポカリ",110]
					];

	document.write(products[0][0]+products[0][1]+"円。"+
				   products[1][0]+products[1][1]+"円。"+
				   products[2][0]+products[2][1]+"円。"
					);
}
//問３
function q16(){
	var purse=110;

	var products = [	["水",100],
	                	["コーラ",150],
	                	["ポカリ",110]
					];

	if(purse >= products[0][1]){
			document.write(products[0][0]+"です。ありがとうございました。");
	}else{
			document.write("代金が不足しています。");
	}
}
//追加問題1
function ex1(){
	var products = [	["水",100],
	                	["コーラ",150],
	                	["ポカリ",110]
					];

	var pick =0;

	if(pick == 0)document.write(products[pick][0]+products[pick][1]+"円。");
}
//追加問題2
function ex2(){
	var products = [	["水",100],
	                	["コーラ",150],
	                	["ポカリ",110]
					];
	var purse=110;
	var pick=2;

	switch (pick){
	case 0:
		if(purse >= products[pick][1])document.write("水です。ありがとうございました。");
		else document.write("代金が不足しています。");
		break;
	case 1:
		if(purse >= products[pick][1])document.write("コーラです。ありがとうございました。");
		else document.write("代金が不足しています。");
		break;
	case 2:
		if(purse >= products[pick][1])document.write("ポカリです。ありがとうございました。");
		else document.write("代金が不足しています。");
		break;
		}
}
//追加問題３
function ex3(){
	var products = [	["水",100],
	                	["コーラ",150],
	                	["ポカリ",110]
					];
	var purse=150;
	var pick=4;

	switch (pick){
	case 0:
		if(purse >= products[pick][1])document.write("水です。ありがとうございました。");
		else document.write("代金が不足しています。");
		break;
	case 1:
		if(purse >= products[pick][1])document.write("コーラです。ありがとうございました。");
		else document.write("代金が不足しています。");
		break;
	case 2:
		if(purse >= products[pick][1])document.write("ポカリです。ありがとうございました。");
		else document.write("代金が不足しています。");
		break;
	default :
		document.write("商品がありません。");
		break;
	}
}
//ハート出力問題
//問１
function q17(){
	var date = [
	           [1, 2, 3, 2, 1],
	           [0, 4, 1, 4],
	           [0, 9],
	           [0, 9],
	           [0, 9],
	           [1, 7, 1],
	           [2, 5, 2],
	           [3, 3, 3],
	           [4, 1, 4]
	         ];

	var count=0;

	for(var i=0; i<=8; i++){
		for(var j=0; j<=4; j++){
			for(var star=0; star<date[i][j]; star++){
				if(i == 0 && date[i][j] == 1 || i == 0 && date[i][j] == 3){
				document.write(" "+"★");
				count++;
			}else if(i == 1 && date[i][j] == 1){
				document.write(" "+"★");
				count++;
			}else if(i == 5 && date[i][j] == 1){
				document.write(" "+"★");
				count++;
			}else if(i == 6 && date[i][j] == 2){
				document.write(" "+"★");
				count++;
			}else if(i == 7 && j == 0 || i == 7 && j == 2){
				document.write(" "+"★");
				count++;
			}else if(i == 8 && date[i][j] == 4){
				document.write(" "+"★");
				count++;
			}else{
				document.write(" "+"☆");
				count++;
			}
				if(count%9 == 0)document.write("<br>");
			}
		}
	}
}