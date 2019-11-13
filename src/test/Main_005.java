package test;

import java.util.Scanner;

public class Main_005 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int[] nums=new int[55];
		for(int i=1;i<55;i++){
			nums[i]=scan.nextInt();
		}
		
		String[] strs_1=new String[55];
		String[] strs_2=new String[55];
		for(int i=1;i<55;i++){
			if(i<=13){
				strs_1[i]="S"+(i%14);
			}else if(i<=26){
				strs_1[i]="H"+((i-13)%14);
			}else if(i<=39){
				strs_1[i]="C"+((i-26)%14);
			}else if(i<=52){
				strs_1[i]="D"+((i-39)%14);
			}else{
				strs_1[i]="J"+(i%13);
			}
		}
		int flag=0;
		for(int i=0;i<N;i++){
			if(flag==0){
				for(int j=1;j<55;j++){
					strs_2[nums[j]]=strs_1[j];
				}
				flag=1;
			}else{
				for(int j=1;j<55;j++){
					strs_1[nums[j]]=strs_2[j];
				}
				flag=0;
			}
		}
		if(flag==0){
			System.out.print(strs_1[1]);
			for(int j=2;j<55;j++){
				System.out.print(" "+strs_1[j]);
			}
		}else{
			System.out.print(strs_2[1]);
			for(int j=2;j<55;j++){
				System.out.print(" "+strs_2[j]);
			}
		}
		System.out.println();
		scan.close();
	}

}
