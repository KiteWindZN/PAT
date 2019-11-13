package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_002 {

	public boolean is_sushu(int num){
		if(num<=3)
			return num>2;
		if(num%6!=1 && num%6 !=5)
			return false;
		for(int i=2;i<=Math.sqrt(num);i++){
			if(num%i==0)
				return false;
		}
		return true;
	} 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main_002 obj=new Main_002();
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		List<Integer> list=new ArrayList<Integer>();
		int total=0;
		for(int i=2;i<=N;i++){
			if(obj.is_sushu(i)){
				if(list.size()!=0){
					int tmp=i-list.get(list.size()-1);
					if(tmp==2)
						total++;
				}
				list.add(i);
			}
		}
		System.out.println(total);
	}

}
