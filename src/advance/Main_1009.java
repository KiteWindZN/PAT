package advance;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main_1009 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		Map<Integer,Float> map=new TreeMap<Integer,Float>(
			new Comparator<Integer>(){
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o2.compareTo(o1);
				}
			}
		);
		Map<Integer,Float> map_1=new HashMap<Integer,Float>();
		
		int N1=scan.nextInt();
		for(int i=0;i<N1;i++){
			int e=scan.nextInt();
			float c=scan.nextFloat();
			map_1.put(e, c);
		}
		scan.nextLine();
		N1=scan.nextInt();
		for(int i=0;i<N1;i++){
			int e=scan.nextInt();
			float c=scan.nextFloat();
			for(int k:map_1.keySet()){
				float tmp_c=map_1.get(k);
				int tmp_e=k;
				tmp_c=tmp_c*c;
				tmp_e=tmp_e+e;
				if(map.containsKey(tmp_e)){
					map.put(tmp_e, map.get(tmp_e)+tmp_c);
				}else{
					map.put(tmp_e,tmp_c);
				}
			}
		}
		int size=map.size();
		for(int e:map.keySet()){
			if(map.get(e)==0)
				size--;
		}
		System.out.print(size);
		for(int e:map.keySet()){
			if(map.get(e)==0)
				continue;
			System.out.print(" "+e+" "+String.format("%.1f", map.get(e)));
		}
		
		System.out.println();
		scan.close();
	}

}
