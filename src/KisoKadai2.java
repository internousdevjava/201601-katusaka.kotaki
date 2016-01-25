import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KisoKadai2 {

	static int score;

	//メイン
	public static void main(String[] args) {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int playing = 0;
		System.out.println("数当てゲームです。\n1から100までの数字を入力して当ててください。");
		System.out.println("ゲームの中断は1111と入力してください。");
		System.out.println("1:スタート 2:終了");

		try {
			while(playing == 0){
				String choise = buf.readLine();
				switch(choise){
				case "1":
					Playing(playing);
					break;
				case"2":
					System.out.println("ゲームを終了します。");
					System.exit(0);
					break;
				default:
					System.out.println("1～2を入力してください。");
					break;
				}
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	//数当てゲーム
	private static void Playing(int state){

		int ran = (int)(Math.random()*100+1);
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		String str;
		int num;

		System.out.println("ゲームスタート");

		while(state == 0){
			try {
				str = buf.readLine();
				num = Integer.parseInt(str);

				if(num == ran){
					System.out.println("正解です。おめでとうございます。");
					score += 10;
					Playing(state);
				}else if( num == 1111 ){
					GameOver(state,ran);
				}else if( (num <= 0) || (100 < num) ){
					System.out.println("値が不正です。\n1から100までの数字を入力してください。");
				}else if(num > ran){
					System.out.println(num +"より小さい数です。");
				}else if(num < ran){
					System.out.println(num +"より大きい数です。");
				}else{
					System.out.println("数字を入力してください。");
					break;
				}
			} catch (NumberFormatException e){
				System.out.println(e);
			} catch (IOException e) {
				System.out.println(e);
			}
		}
	}

	//ゲームオーバー
	public static void GameOver(int state ,int answer){

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		state = 1;
		String choise;

		System.out.println("正解は" + answer + "でした。");
		System.out.println("スコア："+ score);
		System.out.println("1:リトライ 2:終了");

		try {
			while(state == 1){
				choise = buf.readLine();
				switch(choise){
				case "1":
					state = 0;
					score = 0;
					Playing(state);
				case "2":
					System.out.println("ゲームを終了します。");
					System.exit(0);
				default:
					System.out.println("1～2を入力してください。");
					break;
				}
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}