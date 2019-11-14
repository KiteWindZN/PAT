package basic;

import java.util.Scanner;

public class Main_1006 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int num=scan.nextInt();
		int count=0;
		String res="";
		while(num>0){
			int tmp=num%10;
			switch(count){
			case 0:
				String str="";
				for(int i=1;i<=tmp;i++){
					char ch=(char)(i+'0');
					str+=ch;
				}
				res=str+res;
				break;
			case 1:
				for(int i=0;i<tmp;i++){
					res="S"+res;
				}
				break;
			case 2:
				for(int i=0;i<tmp;i++){
					res="B"+res;
				}
				break;
			}
			count++;
			num=num/10;
		}
		System.out.println(res);
	}
}
