package advance;

import java.util.Scanner;

public class Main_1006 {

	public boolean compare(String time1,String time2){
		String[] strs_1=time1.split(":");
		int hh_1=Integer.parseInt(strs_1[0]);
		int mm_1=Integer.parseInt(strs_1[1]);
		int ss_1=Integer.parseInt(strs_1[2]);
		
		String[] strs_2=time2.split(":");
		int hh_2=Integer.parseInt(strs_2[0]);
		int mm_2=Integer.parseInt(strs_2[1]);
		int ss_2=Integer.parseInt(strs_2[2]);
		
		if(hh_1<hh_2){
			return false;
		}else if(hh_1>hh_2){
			return true;
		}else{
			if(mm_1<mm_2){
				return false;
			}else if(mm_1>mm_2){
				return true;
			}else{
				if(ss_1<ss_2){
					return false;
				}else if(ss_1>ss_2){
					return true;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main_1006 obj=new Main_1006();
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		String[] ids=new String[N];
		scan.nextLine();
		int in=-1;
		int out=-1;
		String max="00:00:00";
		String min="23:59:59";
		for(int i=0;i<N;i++){
			String line=scan.nextLine();
			String[] strs=line.split(" ");
			ids[i]=strs[0];
			String tmp_in=strs[1];
			String tmp_out=strs[2];
			if(obj.compare(min, tmp_in)){
				min=tmp_in;
				in=i;
			}
			if(!obj.compare(max, tmp_out)){
				max=tmp_out;
				out=i;
			}
		}
		System.out.println(ids[in]+" "+ids[out]);
		scan.close();
	}

}
