package advance;

import java.util.Scanner;

public class Main_1010 {
    public long transform_decimal(String str,long radix){
        long res=0;
        long start=radix;
        for(int i=0;i<str.length();i++){
            int tmp=(str.charAt(i)>='0' && str.charAt(i)<='9') ?str.charAt(i)-'0':str.charAt(i)-'a'+10;
            res=res*start+tmp;
        }
        return res;
    }

    public static void main(String[] args) {
        Main_1010 obj=new Main_1010();
        Scanner scan=new Scanner(System.in);
        String line=scan.nextLine();
        String[] strs=line.split(" ");
        String str_n1=strs[0];
        String str_n2=strs[1];
        int tag=Integer.parseInt(strs[2]);
        int radix=Integer.parseInt(strs[3]);
        int flag=0;
        if(tag==2){
            String tmp_s=str_n1;
            str_n1=str_n2;
            str_n2=tmp_s;
        }

        long num_1=obj.transform_decimal(str_n1,radix);
        long min_radix=0;
        for(int i=0;i<str_n2.length();i++){
            int tmp=(str_n2.charAt(i)>='0' && str_n2.charAt(i)<='9') ?str_n2.charAt(i)-'0':str_n2.charAt(i)-'a'+10;
            min_radix=Math.max(tmp+1,min_radix);
        }
        long max_radix=Math.max(num_1,min_radix);

        long choose=0;
        while(min_radix<=max_radix){
            choose=(min_radix+max_radix)/2;
            long num_2=obj.transform_decimal(str_n2,choose);
            if(num_2>num_1 || num_2<0){
                max_radix=choose-1;
            }
            else if(num_2<num_1){
                min_radix=choose+1;
            } else {
                flag=1;
                break;
            }
        }

        if(flag==0){
            System.out.println("Impossible");
        }else{
            System.out.println(choose);
        }
        scan.close();

    }
}