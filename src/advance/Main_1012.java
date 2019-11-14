package advance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main_1012 {
	
	static class Grades{
		int c=0;
		int m=0;
		int e=0;
		int a=0;
		public Grades(int c,int m,int e,int a){
			this.c=c;
			this.m=m;
			this.e=e;
			this.a=a;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int[] ids=new int[1000110];
		int N=scan.nextInt();
		int M=scan.nextInt();
		List<Integer> list_C=new ArrayList<Integer>();
		List<Integer> list_M=new ArrayList<Integer>();
		List<Integer> list_E=new ArrayList<Integer>();
		List<Integer> list_A=new ArrayList<Integer>();
		Map<String,Grades> map=new HashMap<String,Grades>();
		scan.nextLine();
		
		for(int i=0;i<N;i++){
			String line=scan.nextLine();
			String[] strs=line.split(" ");
			String id=strs[0];
			ids[Integer.parseInt(id)]=1;
			int c=Integer.parseInt(strs[1]);
			int m=Integer.parseInt(strs[2]);
			int e=Integer.parseInt(strs[3]);
			int a=(c+m+e)/3;
			map.put(id, new Grades(c,m,e,a));
			list_C.add(c);
			list_M.add(m);
			list_E.add(e);
			list_A.add(a);
		}
		Collections.sort(list_C,Collections.reverseOrder());
		Collections.sort(list_M,Collections.reverseOrder());
		Collections.sort(list_E,Collections.reverseOrder());
		Collections.sort(list_A,Collections.reverseOrder());
		char[] chs={'C','M','E','A'};
		for(int i=0;i<M;i++){
			String line=scan.nextLine();
			if(ids[Integer.parseInt(line)]==1){
				Grades g=map.get(line);
				int c=g.c;
				int m=g.m;
				int e=g.e;
				int a=g.a;
				int rank=N+1;
				int choose=-1;
				if(rank>list_A.indexOf(a)+1){
					choose=3;
					rank=list_A.indexOf(a)+1;
				}

				if(rank>list_C.indexOf(c)+1){
					choose=0;
					rank=list_C.indexOf(c)+1;
				}

				if(rank>list_M.indexOf(m)+1){
					choose=1;
					rank=list_M.indexOf(m)+1;
				}

				if(rank>list_E.indexOf(e)+1){
					choose=2;
					rank=list_E.indexOf(e)+1;
				}
				
				System.out.println(rank+" "+chs[choose]);
			}else{
				System.out.println("N/A");
			}
		}
	}

}
