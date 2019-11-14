package basic;

import java.util.Scanner;

public class Main_1003 {

	public boolean solve(String line){
		if(line.charAt(0)=='P'){
			int len=line.length();
			if(line.charAt(len-1)!='T'){
				return false;
			}
			int num=0;
			for(int i=1;i<len-1;i++){
				if(line.charAt(i)!='A'){
					return false;
				}
				num++;
			}
			if(num==0)
				return false;
		}else if(line.charAt(0)=='A'){
			int len=line.length();
			int i=0;
			int num_1=0;
			int num_2=0;
			int num_3=0;
			while(line.charAt(i)=='A')
				i++;
			num_1=i;
			if(line.charAt(i)!='P')
				return false;
			i=i+1;
			while(line.charAt(i)=='A'){
				i++;
				num_2++;
			}
			if(line.charAt(i)!='T')
				return false;
			i=i+1;
			while(i<len){
				if(line.charAt(i)!='A')
					return false;
				i++;
				num_3++;
			}
			
			if(num_1*num_2!=num_3){
				return false;
			}
			
		}else{
			return false;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		Main_1003 obj=new Main_1003();
		int num=scan.nextInt();
		scan.nextLine();
		String line="";
		for(int i=0;i<num;i++){
			line=scan.nextLine();
			if(obj.solve(line)){
				System.out.println("YES");
			}else
				System.out.println("NO");
		}
	}

}
