package advance;

import java.util.Scanner;

public class Main_1008 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int start=0;
		int res=0;
		for(int i=0;i<N;i++){
			int tmp=scan.nextInt();
			if(tmp>start){
				res=res+(tmp-start)*6+5;
			}else{
				res=res+(start-tmp)*4+5;
			}
			start=tmp;
		}
		System.out.println(res);
		scan.close();
	}

}
