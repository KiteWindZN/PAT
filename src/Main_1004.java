import java.util.Scanner;

public class Main_1004 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int total=scan.nextInt();
		scan.nextLine();
		String line="";
		String name_max="";
		String name_min="";
		String id_max="";
		String id_min="";
		int min=101;
		int max=-1;
		for(int i=0;i<total;i++){
			line=scan.nextLine();
			String[] strs=line.split(" ");
			int score=Integer.parseInt(strs[2]);
			if(score<min){
				name_min=strs[0];
				id_min=strs[1];
				min=score;
			}
			if(score>max){
				max=score;
				name_max=strs[0];
				id_max=strs[1];
			}
			
		}
		System.out.println(name_max+" "+id_max);
		System.out.println(name_min+" "+id_min);
		scan.close();
	}

}
