package advance;
import java.util.*;

public class Main_1017 {

    public int cal_second(String str_1,String str_2){
        String[] strs_1=str_1.split(":");
        String[] strs_2=str_2.split(":");
        int hour_1=Integer.parseInt(strs_1[0]);
        int minute_1=Integer.parseInt(strs_1[1]);
        int second_1=Integer.parseInt(strs_1[2]);

        int hour_2=Integer.parseInt(strs_2[0]);
        int minute_2=Integer.parseInt(strs_2[1]);
        int second_2=Integer.parseInt(strs_2[2]);
        int sum=(hour_2*3600)+(minute_2*60)+second_2;
        sum=sum-(hour_1*3600+minute_1*60+second_1);
        return sum;
    }

    public String time_add(String str_1,int minute){
        String[] strs_1=str_1.split(":");
        int hour_1=Integer.parseInt(strs_1[0]);
        int minute_1=Integer.parseInt(strs_1[1]);


        int cn=0;
        int m=(minute_1+minute)%60;
        cn=(minute_1+minute)/60;
        hour_1=hour_1+cn;
        String hh="";
        String mm="";

        if(hour_1<10){
            hh="0"+hour_1;
        }else
            hh=""+hour_1;

        if(m<10){
            mm="0"+m;
        }else
            mm=""+m;

        return hh+":"+mm+":"+strs_1[2];
    }

    public static void main(String[] args) {
        Main_1017 obj=new Main_1017();
        Scanner scan=new Scanner(System.in);
        int N=scan.nextInt();
        int window_num=scan.nextInt();
        Map<String,Integer> map=new TreeMap<String,Integer>();

        scan.nextLine();
        int total=N;
        for(int i=0;i<N;i++){
            String line=scan.nextLine();
            String[] strs=line.split(" ");
            if(strs[0].compareTo("17:00:00")>=0){
                total--;
                continue;
            }
            map.put(strs[0],Integer.parseInt(strs[1]));
        }
        long wait=0;

        Queue<String> window_queue=new PriorityQueue<String>();
        for(int j=0;j<window_num;j++){
            window_queue.add("08:00:00");
        }

        while(!map.isEmpty()){
            for(String key:map.keySet()){
                int process_time=map.get(key);
                String cur_time=window_queue.poll();
                if(key.compareTo(cur_time)<0){
                    wait=wait+obj.cal_second(key,cur_time);
                }
                String finished_time=obj.time_add(cur_time,process_time);
                window_queue.add(finished_time);
                map.remove(key);
                break;
            }
        }


        double tmp=wait/60.0/total;
        System.out.println(String.format("%.1f",tmp));
    }
}