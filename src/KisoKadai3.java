import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class KisoKadai3 {

	public static void main(String[] args) {

		controllFile();

	}
	//メイン操作
	private static void controllFile(){
		System.out.println("コマンドを指定してください。(/create,/write,/read,/exit)");

		BufferedReader input = new BufferedReader (new InputStreamReader (System.in));

		try {
			String str = input.readLine( );

			switch(str){
			case "/create":
				System.out.println("ファイル・フォルダの作成を開始します。");
				creation();
				break;
			case "/write":
				System.out.println("ファイルの書き込みを開始します。");
				writeFile();
				break;
			case "/read" :
				System.out.println("ファイルの読み込みを開始します。");
				readFile();
				break;
			case "/exit":
				System.out.println("お疲れ様でした。");
				System.exit(0);
				break;
			default :
				System.out.println("コマンドが不正です。");
				controllFile();
				break;
			}

		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	//ファイル、フォルダの作成
	private static void creation(){
		System.out.println("作成する対象を指定してください。(/file,/folder)");

		BufferedReader input = new BufferedReader (new InputStreamReader (System.in));

		try{
			String choise = input.readLine( );

			switch(choise){
			case "/file":
				System.out.println("ファイル作成を選択しました。\nファイルの名前を入力してください。");
				String file_name = input.readLine( );
				File file = new File(file_name);

				if(!(file.exists())){
					if (file.createNewFile()){
						System.out.println("ファイルの作成に成功しました。");
					}
				}else{
					System.out.println("ファイルの作成に失敗しました。");
				}
				controllFile();
				break;
			case "/folder":
				System.out.println("フォルダ作成を選択しました。\nフォルダ名を入力してください。");
				String folder_name = input.readLine( );
				File folder = new File(folder_name);

				if(!(folder.exists())){
					if (folder.mkdirs()){
						System.out.println("フォルダの作成に成功しました。");
					}
				}else{
					System.out.println("フォルダの作成に失敗しました。");
				}
				controllFile();
				break;
			default:
				System.out.println("コマンドが不正です。");
				controllFile();
			}
		}catch(IOException e){
			System.out.println(e);
		}
	}

	//書き込み
	private static void writeFile(){

		BufferedReader input = new BufferedReader (new InputStreamReader (System.in));

		System.out.println("追記または上書きを選んでください。(/add,/over)");

		boolean isChoise = false;

		try{
			String choise = input.readLine( );

			switch(choise){
			case "/over":
				isChoise = false;
				System.out.println("上書きを選択しました。");
				break;
			case "/add":
				isChoise= true;
				System.out.println("追記を選択しました。");
				break;
			default:
				System.out.println("コマンドが不正です。");
				controllFile();
			}

			System.out.println("ファイル名を指定してください。");
			String file_name = input.readLine( );
			File file = new File(file_name);
			if (checkBeforeWritefile(file)){
				FileWriter fw = new FileWriter(file ,isChoise);
				PrintWriter pw = new PrintWriter(new BufferedWriter(fw));

				System.out.println("追記または上書きする内容を入力してください。");
				String str = input.readLine( );
				pw.println(str);
				pw.close();
				System.out.println("更新しました。");
				controllFile();
			}else{
				System.out.println("ファイルに書き込めません。");
				controllFile();
			}

		}catch(IOException e){
			System.out.println(e);
		}
	}

	//読み込み
	private static void readFile(){
		System.out.println("ファイルを指定してください。");

		BufferedReader input = new BufferedReader (new InputStreamReader (System.in));

		try{
			String file_name = input.readLine( );

			File file = new File(file_name);

			if (checkBeforeReadfile(file)){
				BufferedReader br = new BufferedReader(new FileReader(file));

				String str;
				while((str = br.readLine()) != null){
					System.out.println(str);
				}

				br.close();

				controllFile();
			}else{
				System.out.println("ファイルが見つからないか開けません。");
				controllFile();
			}
		}catch(FileNotFoundException e){
			System.out.println(e);
		}catch(IOException e){
			System.out.println(e);
		}
	}

	//書き込みチェック
	private static boolean checkBeforeWritefile(File file){
		if (file.exists()){
			if (file.isFile() && file.canWrite()){
				return true;
			}
		}

		return false;
	}

	//読み込みチェック
	private static boolean checkBeforeReadfile(File file){
		if (file.exists()){
			if (file.isFile() && file.canRead()){
				return true;
			}
		}
		return false;
	}
}
