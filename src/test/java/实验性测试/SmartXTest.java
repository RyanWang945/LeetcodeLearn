package 实验性测试;

//import com.sun.org.apache.xpath.internal.operations.String;
import org.junit.Test;

import java.util.*;

/**
 * @author Ryan
 * @date 2020/12/2 20:48
 * 如果一个单词通过循环右移获得的单词，我们称这些单词都为一种循环单词。 例如：picture 和 turepic 就是属于同一种循环单词。现在给出 n 个单词，需要统计这 n 个单词中有多少种循环单词。例如，给定单词组 ["picture", "turepic", "icturep", "word", "ordw"]，他们包含了 2 种循环单词，分别是 ["picture", "turepic", "icturep"] 和 ["word", "ordw"]。这时你的函数应该返回 2
 */
public class SmartXTest {

    @Test
    public void test3(){
        int x=3000;
        int target=3;
        int n=0;
        int xx=x;
        while(xx>0){
            xx/=10;
            n++;
        }
        int ans=0;
        for(int i=0;i<n;i++){
            int a=(int)Math.pow(10,i+1);
            int b=(int)Math.pow(10,i);
            int cur=(x%a)/b;
            if(cur>target){
                if(i==0)
                    ans+=x/a+1;
                else if(i==n-1){
                    ans+=b;
                }else{
                    ans+=(x/a+1)*b;
                }
            }else if(cur==target){
                if(i==0)
                    ans+=x/a+1;
                else if(i==n-1){
                    ans+=(x%b)+1;
                }else{
                    ans+=x/a*b+x%b+1;
                }
            }else{
                if(i==0)
                    ans+=x/a;
                else if(i==n-1){

                }else{
                    ans+=x/a*b;
                }
            }

        }
        System.out.println(ans);
    }
    @Test
    public void test4(){
        //813
        int x=3000;
        int sum=0;
        char target='3';
        for(int i=0;i<=x;i++){
            int temp=i;
            String s=String.valueOf(temp);
            for(char c:s.toCharArray()){
                if(c==target){
                    sum++;
                }
            }
        }
        System.out.println(sum);
    }
    volatile int a=0;
    @Test
    public void test5(){
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                while(a<1000){
                    if((a%3)==0){
                        System.out.println('A');
                        a++;
                    }
                }
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                while(a<1000){
                    if((a%3)==1){
                        System.out.println('B');
                        a++;
                    }
                }
            }
        });
        Thread t3=new Thread(new Runnable() {
            @Override
            public void run() {
                while(a<1000){
                    if((a%3)==2){
                        System.out.println('C');
                        a++;
                    }
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
    @Test
    public void test6(){
        int x=((int)Math.random())*54;
    }
}
