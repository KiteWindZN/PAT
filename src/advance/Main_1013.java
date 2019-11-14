package advance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_1013 {
    static class node{
        int id;
        List<Integer> list=new ArrayList<Integer>();
        public node(int id){
           this.id=id;
        }
    }

    public void dfs(node[] nodes,int choose,int[] visited){
        visited[choose]=1;
        List<Integer> nabor=nodes[choose].list;
        for(int id: nabor){
            if(visited[id]==0)
                dfs(nodes,id,visited);
        }
    }


    public static void main(String[] args) {
        Main_1013 obj=new Main_1013();
        Scanner scan=new Scanner(System.in);
        int N=scan.nextInt();
        int M=scan.nextInt();
        int K=scan.nextInt();
        node[] nodes=new node[N+1];
        for(int i=1;i<=N;i++){
            nodes[i]=new node(i);
        }
        scan.nextLine();

        for(int i=0;i<M;i++){
            String line=scan.nextLine();
            String[] strs=line.split(" ");
            int start=Integer.parseInt(strs[0]);
            int end=Integer.parseInt(strs[1]);
            nodes[start].list.add(end);
            nodes[end].list.add(start);
        }
        String line=scan.nextLine();
        String[] strs=line.split(" ");
        for(int i=0;i<K;i++){
            int choose=Integer.parseInt(strs[i]);
            int[] visited=new int[N+1];
            visited[choose]=1;
            int sum=0;
            for(int j=1;j<=N;j++) {
                if(visited[j]==0) {
                    sum++;
                    obj.dfs(nodes,j,visited);
                }
            }
            System.out.println(sum-1);
        }
        scan.close();
    }
}