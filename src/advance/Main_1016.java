package advance;

import java.util.*;


public class Main_1016 {

    static class node{
        int time=0;
        int cost=0;
        public node(int time,int cost){
            this.time=time;
            this.cost=cost;
        }
    }

    public node cal_cost(String start,String end,int[] costs){
        String[] strs_start=start.split(":");
        String[] strs_end=end.split(":");
        int day_1=Integer.parseInt(strs_start[1]);
        int hour_1=Integer.parseInt(strs_start[2]);
        int minute_1=Integer.parseInt(strs_start[3]);

        int day_2=Integer.parseInt(strs_end[1]);
        int hour_2=Integer.parseInt(strs_end[2]);
        int minute_2=Integer.parseInt(strs_end[3]);

        int total_cost=0;
        int total_min=0;
        int total_hour=(day_2-day_1)*24+(hour_2-hour_1-1);

        total_cost=(60-minute_1)*costs[hour_1];
        if(day_1<day_2) {
            total_cost=total_cost+(day_2-day_1-1)*cost_day(costs);
            for (int i = hour_1 + 1; i < 24; i++) {
                total_cost = total_cost + 60 * costs[i];
            }
            for (int i = 0; i < hour_2; i++) {
                total_cost = total_cost + 60 * costs[i];
            }
        }else{
            for (int i = hour_1 + 1; i < hour_2; i++) {
                total_cost = total_cost + 60 * costs[i];
            }
        }
        total_cost=total_cost+costs[hour_2]*minute_2;
        total_min=total_hour*60+(60-minute_1)+minute_2;
        node nn=new node(total_min,total_cost);
        return nn;
    }

    public int cost_day(int[] costs){
        int res=0;
        for(int i=0;i<24;i++){
            res=res+60*costs[i];
        }
        return res;
    }
    public static void main(String[] args) {
        Main_1016 obj=new Main_1016();
        Scanner scan=new Scanner(System.in);
        Map<String,List<String>> map=new TreeMap<String,List<String>>();
        int[] costs=new int[24];
        for(int i=0;i<24;i++){
            costs[i]=scan.nextInt();
        }
        int N=scan.nextInt();
        scan.nextLine();
        for(int i=0;i<N;i++){
            String line=scan.nextLine();
            String[] strs=line.split(" ");
            if(map.containsKey(strs[0])){
                map.get(strs[0]).add(strs[1]+" "+strs[2]);
            }else{
                map.put(strs[0],new ArrayList<String>());
                map.get(strs[0]).add(strs[1]+" "+strs[2]);
            }
        }

        for(String key:map.keySet()){
            Collections.sort(map.get(key));
            List<String> list=map.get(key);
            int flag=1;
            for(int i=0;i<list.size();i++){
                String str=list.get(i);
                if(flag==1&& str.contains("off-line")){
                    list.remove(i);
                    i--;
                }else if(flag==-1 && str.contains("on-line")){
                    list.remove(i-1);
                    i--;
                }else
                    flag=flag*(-1);
            }
            if(list.size()%2==1){
                list.remove(list.size()-1);
            }
        }

        for(String key: map.keySet()){
            List<String> list=map.get(key);
            String month=list.get(0).split(" ")[0].substring(0,2);
            System.out.println(key+" "+month);
            int cost=0;
            for(int i=0;i<list.size();i+=2){
                String start=list.get(i).split(" ")[0];
                String end=list.get(i+1).split(" ")[0];
                node nn=obj.cal_cost(start,end,costs);
                int total_cost=nn.cost;
                int total_time=nn.time;
                cost+=total_cost;
                System.out.println(start.substring(3)+" "+end.substring(3)+" "+total_time+" $"+String.format("%.2f",total_cost/100.0));
            }
            System.out.println("Total amount: $"+String.format("%.2f",cost/100.0));
        }
        scan.close();
    }
}