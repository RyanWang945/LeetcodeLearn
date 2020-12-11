package javalearn.网络编程;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * @author Ryan
 * @date 2020/8/17 22:24
 * 查看某个网页的源代码，其背后的知识点是连接url并打开一个输入流，然后通过链接输出
 */
public class Demo1 {
    public static void main(String[] args) {
        try {
            URL u=new URL("http://www.baidu.com");
            InputStream in =u.openStream();
//            in=new BufferedInputStream(in);
//            Reader r=new InputStreamReader(in);
//            int c=0;
//            while((c=r.read())!=-1){
//                System.out.print((char)c);
//            }
            Scanner sc=new Scanner(in);
            while(sc.hasNext()){
                System.out.println(sc.nextLine());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
