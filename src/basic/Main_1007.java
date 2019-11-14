package basic;

import java.util.Scanner;

public class Main_1007 {

	public boolean is_sushu(int num){
		for(int i=2;i<=Math.sqrt(num);i++){
			if(num%i==0)
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main_1007 obj=new Main_1007();
		Scanner scan=new Scanner(System.in);
		int num=scan.nextInt();
		int[] label=new int[num+1];
		if(num>=2)
			label[2]=1;
		
		int count=0;
		for(int i=3;i<=num;i+=2){
			if(obj.is_sushu(i)){
				label[i]=1;
				if(label[i-2]==1)
					count++;
				
			}
		}
		System.out.println(count);
		scan.close();
	}

}
