package advance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_1020 {
	
	static class node{
		int id;
		node left;
		node right;
		public node(int id){
			this.id=id;
			this.left=null;
			this.right=null;
		}
	}
	
	public node create_tree(int[] poster,int[] inner,int start_1,int end_1,int start_2,int end_2){
		if(start_1>end_1){
			return null;
		}
		node root=new node(poster[end_1]);
		int len=0;
		for(int i=start_2;i<=end_2;i++){
			if(inner[i]==poster[end_1]){
				len=i-start_2;
				break;
			}
		}
		root.left=create_tree(poster,inner,start_1,start_1+len-1,start_2,start_2+len-1);
		root.right=create_tree(poster,inner,start_1+len,end_1-1,start_2+len+1,end_2);
		return root;
	}
	
	public void println(node root){
		System.out.print(root.id);
		List<node> list=new ArrayList<node>();
		if(root.left!=null)
			list.add(root.left);
		if(root.right!=null){
			list.add(root.right);
		}
		while(list.size()>0){
			node tmp=list.get(0);
			System.out.print(" "+tmp.id);
			list.remove(0);
			if(tmp.left!=null)
				list.add(tmp.left);
			if(tmp.right!=null){
				list.add(tmp.right);
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		Main_1020 obj=new Main_1020();
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		
		int[] poster=new int[N];
		int[] inner=new int[N];
		for(int i=0;i<N;i++){
			poster[i]=scan.nextInt();
		}
		for(int i=0;i<N;i++){
			inner[i]=scan.nextInt();
		}
		
		node root=obj.create_tree(poster, inner, 0, N-1, 0, N-1);
		obj.println(root);
		scan.close();
	}
}