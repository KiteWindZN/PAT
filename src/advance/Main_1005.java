package advance;

import java.util.Scanner;

public class Main_1005 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		String[] strs={"zero","one","two","three","four","five","six","seven","eight","nine","ten"};
		String line=scan.nextLine();
		int sum=0;
		for(int i=0;i<line.length();i++){
			sum= sum + line.charAt(i)-'0';
		}
		String res="";
		int tmp=sum%10;
		sum=sum/10;
		res=strs[tmp];
		while(sum>0){
			tmp=sum%10;
			sum=sum/10;
			res=strs[tmp]+" "+res;
		}
		System.out.println(res);
		scan.close();
	}

}
