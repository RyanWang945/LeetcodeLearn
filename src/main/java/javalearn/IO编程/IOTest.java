package javalearn.IO编程;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Ryan
 * @date 2020/8/12 15:01
 */
public class IOTest {
    public static void main(String[] args) throws IOException {
        //test1();
        test2();
    }
    public static void test1() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char c;
        c=(char) bf.read();
        System.out.println(c);
    }
    public static void test2() throws IOException {
        InputStream in=System.in;
        BufferedReader bf=new BufferedReader(new InputStreamReader(in));
        String str=bf.readLine();
        System.out.println(str);
    }
}
