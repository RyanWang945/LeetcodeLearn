package javalearn.userMethod;

/**
 * @author Ryan
 * @date 2020/8/11 15:23
 */
public class Fibonacci {
    public static void main(String[] args) {
        if(args.length==0){
            return;
        }
        int a=Integer.parseInt(args[0]);
        System.out.println(a+10);
    }
}
