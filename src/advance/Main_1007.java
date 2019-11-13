package advance;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1007 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		scan.nextLine();
		int[] nums=new int[N];
		int[] dp=new int[N];
		Arrays.fill(dp, Integer.MIN_VALUE);
		int start=0;
		int end=0;
		String line=scan.nextLine();
		String[] strs=line.split(" ");
		nums[0]=Integer.parseInt(strs[0]);
		dp[0]=nums[0];
		int max=dp[0];
		int tmp_start=0;
		int tmp_end=0;
		
		
		for(int i=1;i<N;i++){
			nums[i]=Integer.parseInt(strs[i]);//scan.nextInt();
			tmp_end=i;
			if(dp[i-1]>0){
				dp[i]=nums[i]+dp[i-1];
				if(max<dp[i]){
					max=dp[i];
					start=tmp_start;
					end=tmp_end;
				}
			}
			else{
				dp[i]=nums[i];
				tmp_start=i;
				tmp_end=i;
				if(max<dp[i]){
					max=dp[i];
					start=tmp_start;
					end=tmp_end;
				}
			}
		}
		if(max>=0){
			while(end>start &&dp[end-1]==max){
				end--;
			}
			System.out.println(max+" "+nums[start]+" "+nums[end]);
		}else{
			System.out.println(0+" "+nums[0]+" "+nums[N-1]);
		}
	}

}
