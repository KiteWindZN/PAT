package basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_1008 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int total=scan.nextInt();
		int k=scan.nextInt();
		k=k%total;
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<total;i++){
			list.add(scan.nextInt());
		}
		if(k<total/2){
			for(int i=0;i<k;i++){
				int num=list.get(total-1);
				list.remove(total-1);
				list.add(0, num);
			}
		}else{
			for(int i=0;i<total-k;i++){
				int num=list.get(0);
				list.remove(0);
				list.add(num);
			}
		}
		
		System.out.print(list.get(0));
		for(int i=1;i<list.size();i++){
			System.out.print(" "+list.get(i));
		}
		System.out.println();
	}

}
