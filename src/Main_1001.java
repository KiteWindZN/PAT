import java.util.Scanner;

public class Main_1001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int count=0;
		while(n!=1){
			if(n%2==0)
				n=n/2;
			else
				n=(n*3+1)/2;
			count++;
		}
		System.out.println(count);
	}

}
