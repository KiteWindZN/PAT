package advance;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main_1002 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Map<Integer, Float> map = new TreeMap<Integer, Float>(new Comparator<Integer>() {
			public int compare(Integer obj1, Integer obj2) {
				return obj2.compareTo(obj1);
			}
		});
		for (int j = 0; j < 2; j++) {
			int num = scan.nextInt();
			for (int i = 0; i < num; i++) {
				int num_1 = scan.nextInt();
				float num_2 = scan.nextFloat();
				if (map.containsKey(num_1)) {
					map.put(num_1, map.get(num_1) + num_2);
				} else {
					map.put(num_1, num_2);
				}
			}
		}
		
		Iterator<Integer> it=map.keySet().iterator();
		while(it.hasNext()){
			int key=it.next();
			if(map.get(key)==0)
				it.remove();
		}
		System.out.print(map.keySet().size());
		for(int key:map.keySet()){
			if(map.get(key)==0)
				continue;
			System.out.print(" "+key+" "+String.format("%.1f",map.get(key)));
		}
		System.out.println();
	}

}
