package advance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_1019 {
	public List<String> solve(int N,int radix){
		List<String> res=new ArrayList<String>();
		if(N<radix){
			res.add(""+N);
			return res;
		}
		while(N>0){
			int tmp=N%radix;
			N=N/radix;
			res.add(0,""+tmp);
		}
		
		return res;
	}
	
	public boolean is_p(List<String> str){
		int len=str.size();
		int start=0;
		int end=len-1;
		while(start<=end){
			if(!str.get(start).equals(str.get(end)))
				return false;
			start++;
			end--;
		}
		return true;
	}
	public static void main(String[] args){
		Main_1019 obj=new Main_1019();
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int radix=scan.nextInt();
		List<String> res=obj.solve(N, radix);
		if(obj.is_p(res)){
			System.out.println("Yes");
		}else{
			System.out.println("No");
		}
		System.out.print(res.get(0));
		for(int i=1;i<res.size();i++){
			System.out.print(" "+res.get(i));
		}
		scan.close();
	}
}