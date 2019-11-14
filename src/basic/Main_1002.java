package basic;

import java.util.Scanner;

public class Main_1002 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		String line=scan.nextLine();
		int sum=0;
		String[] nums_str={"ling","yi","er","san","si","wu","liu","qi","ba","jiu"};
		for(int i=0;i<line.length();i++){
			sum+=line.charAt(i)-'0';
		}
		
		String res="";
		
		while(sum>0){
			int tmp=sum%10;
			sum=sum/10;
			res=" "+nums_str[tmp]+res;
		}
		if(res.length()==0){
			res="ling";
		}else
		res=res.substring(1);
		
		System.out.println(res);
		scan.close();
	}

}
