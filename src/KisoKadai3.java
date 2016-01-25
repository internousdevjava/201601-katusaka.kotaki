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

		ControllFile();

	}

	//メインメニュー
	private static void ControllFile(){

		BufferedReader input = new BufferedReader (new InputStreamReader (System.in));

		System.out.println("メニューを選択してください。");
		System.out.println("1:ファイル・フォルダの作成 2:ファイルの書き込み 3:ファイルの読み込み 4:終了");

		try {
			String menu = input.readLine( );

			switch(menu){
			case "1":
				System.out.println("ファイル・フォルダの作成を開始します。");
				CreateFile();
				break;
			case "2":
				System.out.println("ファイルの書き込みを開始します。");
				WriteFile();
				break;
			case "3" :
				System.out.println("ファイルの読み込みを開始します。");
				ReadFile();
				break;
			case "4":
				System.out.println("システムを終了します。お疲れ様でした。");
				System.exit(0);
			default :
				System.out.println("1～4を入力してください。");
				ControllFile();
				break;
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	//ファイル、フォルダの作成
	private static void CreateFile(){

		BufferedReader input = new BufferedReader (new InputStreamReader (System.in));

		System.out.println("作成する対象を選択してください。");
		System.out.println("1:ファイル 2:フォルダー 3:メニューへ戻る");

		try{
			String choise = input.readLine( );

			switch(choise){
			case "1":
				System.out.println("パスとファイル名を入力してください。");

				String fileName = input.readLine( );
				File file = new File(fileName);

				if(!(file.exists())){
					if (file.createNewFile()){
						System.out.println("ファイルの作成に成功しました。\n");
					}
				}else{
					System.out.println("すでに存在するか名前が正しくありません。\n");
				}
				CreateFile();
				break;

			case "2":
				System.out.println("パスとフォルダ名を入力してください。");

				String folderName = input.readLine( );
				File folder = new File(folderName);

				if(!(folder.exists())){
					if (folder.mkdirs()){
						System.out.println("フォルダの作成に成功しました。\n");
					}
				}else{
					System.out.println("すでに存在するか名前が正しくありません。\n");
				}
				CreateFile();
				break;

			case "3":
				ControllFile();
				break;

			default:
				System.out.println("1～3を入力してください。\n");
				CreateFile();
				break;
			}

		}catch(IOException e){
			System.out.println(e);
		}
	}

	//書き込み
	private static void WriteFile(){

		BufferedReader input = new BufferedReader (new InputStreamReader (System.in));

		boolean isChoise = false;

		System.out.println("追記または上書きを選択してください。");
		System.out.println("1:追記 2:上書き 3:メニューへ戻る");

		try{
			String choise = input.readLine( );

			switch(choise){
			case "1":
				isChoise= true;
				System.out.println("追記を選択しました。\n");
				break;
			case "2":
				isChoise = false;
				System.out.println("上書きを選択しました。\n");
				break;
			case "3":
				ControllFile();
				break;
			default:
				System.out.println("1～3を入力してください。\n");
				WriteFile();
				break;
			}

			System.out.println("パスとファイル名を入力してください。");

			String fileName = input.readLine( );
			File file = new File(fileName);

			if (checkBeforeWritefile(file)){
				PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file ,isChoise)));

				System.out.println("追記または上書きする内容を入力してください。");

				String text = input.readLine();

				printWriter.println(text);
				printWriter.close();

				System.out.println("更新しました。\n");
				ControllFile();
			}else{
				System.out.println("ファイルに書き込めません。\n");
				WriteFile();
			}
		}catch(IOException e){
			System.out.println(e);
		}
	}

	//読み込み
	private static void ReadFile(){

		BufferedReader input = new BufferedReader (new InputStreamReader (System.in));

		System.out.println("1:読み込み 2:メニューへ戻る");

		try{
			String choise = input.readLine();

			switch(choise){
			case "1" :
				System.out.println("パスとファイル名を入力してください。");

				String fileName = input.readLine( );
				File file = new File(fileName);

				if (checkBeforeReadfile(file)){

					BufferedReader bReader = new BufferedReader(new FileReader(file));

					String text;

					while((text = bReader.readLine()) != null){
						System.out.println(text);
					}

					System.out.println("\n読み込みを完了しました。\n");

					bReader.close();
					ControllFile();
				}else{
					System.out.println("ファイルが見つからないか開けません。\n");
					ReadFile();
				}
				break;
			case "2" :
				ControllFile();
				break;
			default:
				System.out.println("1～2を入力してください。\n");
				ReadFile();
				break;
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
