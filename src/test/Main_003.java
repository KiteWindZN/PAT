package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_003 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int k=scan.nextInt();
		k=k%N;
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<N-k;i++){
			list.add(scan.nextInt());
		}
		for(int i=0;i<k;i++){
			list.add(i, scan.nextInt());
		}
		System.out.print(list.get(0));
		for(int i=1;i<N;i++){
			System.out.print(" "+list.get(i));
		}
		System.out.println();
	}

}
