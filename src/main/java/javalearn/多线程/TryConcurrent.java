package javalearn.多线程;

import java.util.concurrent.TimeUnit;

/**
 * @author Ryan
 * @date 2020/9/30 12:42
 */
public class TryConcurrent {
    public static void main(String[] args) {
        new Thread(TryConcurrent::enjoyMusic,"另一个线程").start();
        browseNews();
    }
    private static void browseNews(){
        while(true){
            System.out.println("thw good news");
            sleep(1);
        }
    }
    private static void enjoyMusic(){
        while(true){
            System.out.println("the nice music");
            sleep(1);
        }
    }
    private static void sleep(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
