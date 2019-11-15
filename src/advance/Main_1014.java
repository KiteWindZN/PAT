package advance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_1014 {

	public String get_time(int num){
		String res="";
		int hour=num/60;
		int m=num%60;
		hour+=8;
		if(hour<10){
			res="0"+hour+":";
		}else{
			res=""+hour+":";
		}
		if(m==0){
			res=res+"00";
		}else if(m<10){
			res=res+"0"+m;
		}else
			res=res+m;
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main_1014 obj=new Main_1014();
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int M=scan.nextInt();
		int K=scan.nextInt();
		int Q=scan.nextInt();
		scan.nextLine();
		String line=scan.nextLine();
		String[] strs_1=line.split(" ");
		int[] process_time=new int[K+1];
		int[] finish_time=new int[K+1];
		int[] process_time_1=new int[K+1];
		List<List<Integer>> window_list=new ArrayList<List<Integer>>();
		int start=1;
		for(int i=0;i<N;i++){
			window_list.add(new ArrayList<Integer>());
			if(start<=K){
				window_list.get(i).add(start);
				start++;
			}
		}
		for(int i=1;i<M;i++){
			for(int j=0;j<N;j++){
				if(start<=K){
					window_list.get(j).add(start++);
				}else{
					break;
				}
			}
		}
		
		for(int i=0;i<K;i++){
			process_time[i+1]=Integer.parseInt(strs_1[i]);
			process_time_1[i+1]=Integer.parseInt(strs_1[i]);
		}
		
		for(int i=1;i<=540;i++){
			for(int j=0;j<N;j++){
				if(window_list.get(j).size()==0)
					continue;
				int cur=window_list.get(j).get(0);
				process_time[cur]--;
				if(process_time[cur]==0){
					window_list.get(j).remove(0);
					finish_time[cur]=i;
					if(start<=K){
						window_list.get(j).add(start++);
					}
				}
			}
		}

		for(int i=0;i<N;i++){
			if(window_list.get(i).size()==0)
				continue;
			int cur=window_list.get(i).get(0);
			if(process_time[cur]==process_time_1[cur]){
				continue;
			}
			if(process_time[cur]>59)
				continue;
			finish_time[cur]=process_time[cur]+540;
		}

		line=scan.nextLine();
		String[] strs_2=line.split(" ");
		for(int i=0;i<Q;i++){
			int tmp=Integer.parseInt(strs_2[i]);
			int time=finish_time[tmp];
			if(time==0){
				System.out.println("Sorry");
				continue;
			}
			String res=obj.get_time(time);
			System.out.println(res);
		}
		
		scan.close();
	}

}
