import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main_1005 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int[] label=new int[101];
		int total=scan.nextInt();
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<total;i++){
			int n=scan.nextInt();
			list.add(n);
			while(n!=1){
				if(n%2==0)
					n=n/2;
				else
					n=(n*3+1)/2;
				if(n<=100)
				label[n]=1;
			}
		}
		List<Integer> res=new ArrayList<Integer>();
		for(int n:list){
			if(label[n]==0)
				res.add(n);
		}
		
		Collections.sort(res,Collections.reverseOrder());
		System.out.print(res.get(0));
		for(int i=1;i<res.size();i++){
			System.out.print(" "+res.get(i));
		}
		System.out.println();
		scan.close();
	}
//10
//	3 5 6 7 8 11 2 4 15 10
}
