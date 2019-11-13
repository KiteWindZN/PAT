package test;

import java.util.Scanner;

public class Main_004 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		String str=scan.nextLine();
		int[] nums=new int[10];
		for(int i=0;i<str.length();i++){
			nums[str.charAt(i)-'0']++;
		}
		
		int flag=1;
		String res="";
		int cn=0;
		for(int i=str.length()-1;i>=0;i--){
			int tmp=str.charAt(i)-'0';
			int num=tmp+tmp+cn;
			cn=num/10;
			num=num%10;
			res=(char)(num+'0') +res;
			nums[num]--;
			if(nums[num]<0){
				flag=0;
			}
		}
		if(cn!=0){
			res=(char)(cn+'0') +res;
			if(nums[cn]<0)
				flag=0;
		}
		if(flag==1)
			System.out.println("Yes");
		else
			System.out.println("No");
		System.out.println(res);
		scan.close();
	}
	

}
