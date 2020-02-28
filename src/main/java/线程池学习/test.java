package 线程池学习;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.*;

/**
 * @author Ryan
 * @date 2020/1/10 15:21
 *
 */
public class test {
    @Test
    /**
     * 练习Executors获取ExecutorService，然后调用方法，提交任务
     */
    public void test_thread(){
        ExecutorService es= Executors.newCachedThreadPool();
        for(int i=1;i<=10;i++){
            es.submit(new MyRunnable(i));
        }
    }
    @Test
    /**
     *
     */
    public void test_thread2(){

        ExecutorService es= Executors.newCachedThreadPool(new ThreadFactory() {
            int n=1;
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r,"自定义线程名称"+n++);
            }
        });
        for(int i=1;i<=10;i++){
            es.submit(new MyRunnable(i));
        }
    }
    @Test
    public void test_thread3(){
        ExecutorService es=Executors.newFixedThreadPool(1);
        for(int i=1;i<=10;i++){
            es.submit(new MyRunnable(i));
        }
        //es.shutdown();//关闭线程池，不在接受新的任务,已提交的任务都完成
        //es.submit(new MyRunnable(999));提交不上去新的任务
        List<Runnable> runnables = es.shutdownNow();
        System.out.println(runnables);
    }
    @Test
    public void test_asynchronizeThread() throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();
        Future<Integer> f = es.submit(new MyCall(1, 1));
        boolean done = f.isDone();
        System.out.println("第一次判断任务是否完成"+done);
        boolean cancelled = f.isCancelled();
        System.out.println("第一次判断任务是否取消"+cancelled);
        Integer integer = f.get();
        System.out.println("任务执行的结果"+integer);
        boolean done2 = f.isDone();
        System.out.println("第二次判断任务是否完成"+done2);

    }
}

/**
 * 任务类，包含一个任务编号，在任务中，打印出哪一个线程正在执行任务
 */
class MyRunnable implements Runnable{
    private int id;

    public MyRunnable(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        //获取线程的名称，打印一句话
        String name = Thread.currentThread().getName();
        System.out.println(name+"执行了任务..."+id);
    }
}
class MyCall implements Callable<Integer>{

    private int a;
    private int b;

    public MyCall(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Integer call() throws Exception {
        String name=Thread.currentThread().getName();
        System.out.println(name+"准备开始计算。。。");
        Thread.sleep(2000);
        System.out.println(name+"计算完成");
        return a+b;
    }
}
