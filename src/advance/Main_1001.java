package advance;

import java.util.Scanner;

public class Main_1001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int num1=scan.nextInt();
		int num2=scan.nextInt();
		int num=num1+num2;
		String res=String.valueOf(num);
		
		StringBuilder sb=new StringBuilder();
		int start=0;
		if(res.startsWith("-")){
			sb.append("-");
			start=1;
		}
		for(int i=start;i<res.length();i++){
			sb.append(res.charAt(i));
			if(i<(res.length()-1) && (res.length()-1-i)%3==0){
				sb.append(",");
			}
			
		}
		System.out.println(sb.toString());
		scan.close();
	}

}
