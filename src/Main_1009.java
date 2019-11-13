import java.util.Scanner;

public class Main_1009 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		String line=scan.nextLine();
		String[] strs=line.split(" ");
		int len=strs.length;
		System.out.print(strs[len-1]);
		for(int i=len-2;i>=0;i--){
			System.out.print(" "+strs[i]);
		}
		System.out.println();
		scan.close();
	}

}
