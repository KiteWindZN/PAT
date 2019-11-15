package advance;

import java.util.Scanner;

public class Main_1015 {
    public String num_radix(int num,int radix){
        String res="";
        while(num>0){
            int tmp=num%radix;
            res=res+tmp;
            num=num/radix;
        }
        if(res.length()==0)
            res="0";
        return res;
    }

    public boolean is_prime(int num){
        if(num<=3)
            return num>1;
        if(num%6!=1 && num%6!=5)
            return false;
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0)return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Main_1015 obj=new Main_1015();
        Scanner scan=new Scanner(System.in);
        int N=0;
        int M=0;
        N=scan.nextInt();
        while(N>0){
            M=scan.nextInt();
            if(!obj.is_prime(N)){
                System.out.println("No");
                N=scan.nextInt();
                continue;
            }
            String str_res=obj.num_radix(N,M);
            int res=0;
            for(int i=0;i<str_res.length();i++){
                int tmp=str_res.charAt(i)-'0';
                res=res*M+tmp;
            }
            if(obj.is_prime(res)){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
            N=scan.nextInt();
        }
        scan.close();
    }
}