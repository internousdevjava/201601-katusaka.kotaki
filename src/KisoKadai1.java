public class KisoKadai1 {

	public static void main(String[] args) {

		int x = 9;
		int y = 9;

		for(int i=1; i<=x; i++){
			System.out.print(i+"の段: ");
			for(int j=1; j<=y; j++){
				System.out.print(i*j+" ");
			}
			System.out.println("");
		}
	}
}
