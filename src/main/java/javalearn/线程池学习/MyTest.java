package javalearn.线程池学习;

/**
 * @author Ryan
 * @date 2020/1/10 14:41
 */
public class MyTest {
    public static void main(String[] args) {
        MyThreadPool pool=new MyThreadPool(2,4,20);
        for(int i=0;i<10;i++){
            Mytask mytask=new Mytask(i);
            pool.submit(mytask);
        }
    }
}
