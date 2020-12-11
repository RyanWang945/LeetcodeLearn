package javalearn.IO编程;

import java.io.IOException;

/**
 * @author Ryan
 * @date 2020/8/13 10:59
 */
public class 基本输入流缓冲 {
    public static void main(String[] args) throws IOException {
        int br=0;
        int btr=1024;
        byte[] input=new byte[btr];
        while(br<btr){
            br+=System.in.read(input,br,btr-br);
        }
    }
    //前面的程序有一个bug，就是说，如果实在没有数据的话，整个程序会卡死
    //为此，下面的程序有了一些更改，就是说，先获取到底读取了多少个字节，如果没读取到，直接break；
    public static void main2(String[] args) throws IOException {
        int br=0;
        int btr=1024;
        byte[] input=new byte[btr];
        while(br<btr){
            int result=System.in.read(input,br,btr-br);
            if(result==-1) break;
            br+=result;
        }
    }
    //如果想获取一定字节后直接就用，可以用available方法在不阻塞的情况下看有多少个字节可以读取，然后返回
    //可以读取的字节数，然后用这个数简历byte数组，然后直接read进byte数组
    //int byteAvailable= in.available();
    //byte[] input=new byte[byteAvailable];
    //int byteRead=in.read(input,0,byteAvailable);

}
