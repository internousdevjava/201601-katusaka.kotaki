import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KisoKadai2 {

	public static void main(String[] args) throws IOException{

		try{

		int ram = (int)(Math.random()*100+1);

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("数当てゲームです。\n1から100までの数字を入力してください。");

        String str = buf.readLine();
       int num = Integer.parseInt(str);

        while(true){
        	if (ram == num){
	        	System.out.println("正解です。おめでとうございます。");
	        	break;
	        }else if(ram < num){
	        	System.out.println("入力した数より小さい数です。");
	        	str = buf.readLine();
	            num = Integer.parseInt(str);
	        }else{
	        	System.out.println("入力した数より大きい数です。");
	        	str = buf.readLine();
	            num = Integer.parseInt(str);
	            }
        	}
		}catch (NumberFormatException e){
   		 System.out.println(e);
   		 }
	}
}

