package advance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main_1004 {
	int max_depth=-1;
	static class Node{
		int id;
		List<Integer> children;
		public Node(int id){
			this.id=id;
			children=new ArrayList<Integer>();
		}
	}
	
	
	public void solve(Node root,Node[] node_list,int[] res){
		List<Integer> list=new ArrayList<Integer>();
		List<Node> list_node=new ArrayList<Node>();
		int ret=0;
		list_node.add(root);
		list.add(ret);
		while(list_node.size()>0){
			Node cur_node=list_node.get(0);
			ret=list.get(0);
			if(res[ret]==-1){
				res[ret]=0;
			}
			list_node.remove(0);
			list.remove(0);
			List<Integer> children=cur_node.children;
			if(children.size()==0)
				res[ret]++;
			for(int id:children){
				list_node.add(node_list[id]);
				list.add(ret+1);
			}
		}
		max_depth=ret;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main_1004 obj=new Main_1004();
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		if(N==0){
			System.out.println(1);
			return;
		}
		int M=scan.nextInt();
		Node[] node_list=new Node[101];
		for(int i=1;i<101;i++){
			node_list[i]=new Node(i);
		}
		scan.nextLine();
		
		for(int i=0;i<M;i++){
			int id=scan.nextInt();
			int num=scan.nextInt();
			Node cur=node_list[id];
			for(int j=2;j<num+2;j++){
				int tmp_id=scan.nextInt();
				cur.children.add(tmp_id);
			}
		}
		int[] res=new int[N];
		Arrays.fill(res, -1);
		obj.solve(node_list[1], node_list,res);
		System.out.print(res[0]);
		for(int i=1;i<N;i++){
			if(res[i]==-1)
				break;
			System.out.print(" "+res[i]);
		}
		System.out.println();
		scan.close();
	}

}
