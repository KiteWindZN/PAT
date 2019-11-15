package test;

import java.util.PriorityQueue;
import java.util.Queue;

public class test {
    public static void main(String[] args) {
        Queue<String> queue=new PriorityQueue<String>();
        queue.add("003");
        queue.add("001");
        queue.add("002");
        while (queue.size()>0){
            System.out.println(queue.poll());
        }
    }
}