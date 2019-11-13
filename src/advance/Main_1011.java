package advance;

import java.util.Scanner;

public class Main_1011 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		char[] chs={'W','T','L'};
		float res=1;
		for(int i=0;i<3;i++){
			float num_1=scan.nextFloat();
			float num_2=scan.nextFloat();
			float num_3=scan.nextFloat();
			int choose=-1;
			if(num_1>num_2){
				choose=0;
			}else{
				choose=1;
				num_1=num_2;
			}
			if(num_1<num_3){
				choose=2;
				num_1=num_3;
			}
			System.out.print(chs[choose]+" ");
			res=res*num_1;
		}
		res=(float) ((res*0.65-1)*2);
		System.out.println(String.format("%.2f", res));
		scan.close();
	}

}
