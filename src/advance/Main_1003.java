package advance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_1003 {
	static class node{
		int id;
		List<Dis> nabor=new ArrayList<Dis>();
		public node(int id){
			this.id=id;
		}
	}
	static class Dis{
		int id;
		int dis;
		public Dis(int id,int dis){
			this.id=id;
			this.dis=dis;
		}
	}
	
	public int[] spfa(node[] nodes,int index,int[] max_teams,int[] road,int[] teams){
		int N=nodes.length;
		List<Integer> list=new ArrayList<Integer>();
		int[] visited=new int[N];
		road[index]=1;
		
		int[] dis=new int[N];
		for(int i=0;i<N;i++){
			dis[i]=Integer.MAX_VALUE;
			max_teams[i]=Integer.MIN_VALUE;
		}
		dis[index]=0;
		list.add(index);
		visited[index]=1;
		max_teams[index]=teams[index];
		
		while(list.size()>0){
			int cur=list.get(0);
			list.remove(0);
			visited[cur]=0;
			List<Dis> dis_l=nodes[cur].nabor;
			for(Dis d:dis_l){
				int id=d.id;
				int d_dis=d.dis;
				if(dis[id]>dis[cur]+d_dis){
					dis[id]=dis[cur]+d_dis;
					road[id]=road[cur];
					max_teams[id]=max_teams[cur]+teams[id];
					
					if(visited[id]==0){
						list.add(id);
						visited[id]=1;
					}
				}else{
					if(dis[id]==dis[cur]+d_dis){
						road[id]+=road[cur];
						if(max_teams[id]<(max_teams[cur]+teams[id])){
							max_teams[id]=(max_teams[cur]+teams[id]);
						}
					}
				}
			}
		}
		return dis;
	}
	
	
	public void Dijstra(node[] nodes,int index,int[] teams,int[] road_num,int[] max_teams){
		int N=nodes.length;
		int[] flag=new int[N];
		
		int[] dis=new int[N];
		for(int i=0;i<N;i++){
			dis[i]=100000000;
		}
		dis[index]=0;
		int start=index;
		for(int i=0;i<N;i++){
			int v=-1;
			int min=Integer.MAX_VALUE;
			for(int j=0;j<N;j++){
				if(flag[j]==0 && min>dis[j]){
					min=dis[j]+dis[start];
					v=j;
				}
			}
			if(v==-1)
				break;
			flag[v]=1;
			List<Dis> nabor=nodes[v].nabor;
			for(Dis d:nabor){
				int id=d.id;
				int dd=d.dis;
				if(flag[id]==0 && dis[id]>dis[v]+dd){
					dis[id]=dis[v]+dd;
					road_num[id]=road_num[v];
					max_teams[id]=max_teams[v]+teams[id];
				}else if(flag[id]==0 && dis[id]==dis[v]+dd){
					road_num[id]+=road_num[v];
					max_teams[id]=Math.max(max_teams[id],max_teams[v]+teams[id]);
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main_1003 obj=new Main_1003();
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int M=scan.nextInt();
		int start=scan.nextInt();
		int end=scan.nextInt();
		int[] teams=new int[N];
		node[] nodes=new node[N];
		for(int i=0;i<N;i++){
			teams[i]=scan.nextInt();
			nodes[i]=new node(i);
		}
		
		for(int i=0;i<M;i++){
			int c1=scan.nextInt();
			int c2=scan.nextInt();
			int dis=scan.nextInt();
			nodes[c1].nabor.add(new Dis(c2,dis));
			nodes[c2].nabor.add(new Dis(c1,dis));
		}
		
		int[] road_num=new int[N];
		int[] max_teams=new int[N];
		road_num[start]=1;
		max_teams[start]=teams[start];
		//obj.spfa(nodes, start,max_teams,road_num,teams);
		obj.Dijstra(nodes, start, teams, road_num, max_teams);
		System.out.println(road_num[end]+" "+max_teams[end]);
		scan.close();
	}
}
