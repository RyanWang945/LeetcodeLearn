package 刷题.牛客;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Ryan
 * @date 2020/8/1 18:13
 */
public class _08_01_03 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        PriorityQueue<Integer> queue=new PriorityQueue<Integer>(Comparator.naturalOrder());
        for(int i=0;i<n;i++){
            queue.offer(sc.nextInt());
        }
        int sum=0;
        if(queue.size()==1) System.out.println(queue.poll());
        while(queue.size()>=2){
            int a=queue.poll();
            int b=queue.poll();
            sum=sum+a+b;
            queue.offer(a+b);
            //System.out.print(sum+" ");
        }
        System.out.println(sum);
    }
}
