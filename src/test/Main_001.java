package test;

import java.util.Scanner;

public class Main_001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		String line=scan.nextLine();
		String[] strs=line.split(" ");
		
		int N=Integer.parseInt(strs[0]);
		
		int[] lavel=new int[N+1];
		lavel[1]=1;
		int l=1;
		int column_num=3;
		for(int i=1;i<=N;){
			for(int j=i;j<i+2*column_num;j++){
				if(j>N)
					break;
				lavel[j]=l;
			}
			l++;
			i=i+column_num*2;
			column_num+=2;
		}
		l=lavel[N];
		for(int i=l;i>0;i--){
			int total=i*2-1;
			int ept=l-i;
			for(int j=0;j<ept;j++){
				System.out.print(" ");
			}
			for(int j=0;j<total;j++){
				System.out.print(strs[1]);
			}
			System.out.println();
		}
		
		for(int i=2;i<=l;i++){
			int total=i*2-1;
			int ept=l-i;
			for(int j=0;j<ept;j++){
				System.out.print(" ");
			}
			for(int j=0;j<total;j++){
				System.out.print(strs[1]);
			}
			System.out.println();
		}
		int last=0;
		for(int i=N-1;i>=0;i--){
			if(lavel[i]==l)
				last++;
			else
				break;
		}
		System.out.println(last);
	}

}
