package basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_1010 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		List<Integer> list=new ArrayList<Integer>();
		
		int flag=0;
		while(scan.hasNext()){
			int num1=scan.nextInt();
			int num2=scan.nextInt();
			if(num1*num2==0)
				continue;
			if(flag==1)
				System.out.print(" ");
			System.out.print(num1*num2+" "+(num2-1));
			flag=1;
		}
		
		if(flag==0){
			System.out.println("0 0");
			scan.close();
			return;
		}
		
		System.out.println();
		scan.close();
	}

}
