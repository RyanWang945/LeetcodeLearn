package 线程池学习;

import java.util.*;

/**
 * @author Ryan
 * @date 2020/1/10 14:23
 * 自定义的线程池类
 * 成员变量：
 *      任务队列：集合，需要控制线程安全问题
 *      当前线程数量
 *      核心线程数
 *      最大线程数
 *      任务队列的长度
 * 成员方法：
 *      提交任务，将任务添加到集合中，判断是否超出任务总长度
 *      执行任务：判断当前线程数量，决定创建核心线程还是非核心线程。
 *
 */
public class MyThreadPool {
    private List<Runnable> tasks = Collections.synchronizedList(new LinkedList<>());
    private int num;
    private int corePoolSize;
    private int maxSize;
    private int workSize;

    public MyThreadPool(int corePoolSize, int maxSize, int workSize) {
        this.corePoolSize = corePoolSize;
        this.maxSize = maxSize;
        this.workSize = workSize;
    }

    public void submit(Runnable r){
        //判断当前集合中任务数量是否超出了最大任务数量
        if(tasks.size()>=workSize){
            System.out.println("任务："+r+"被丢弃了。。。");
        }else{
            tasks.add(r);
            execTask(r);
        }
    }
    private void execTask(Runnable r){
        if(num<corePoolSize){
            new Myworker("核心线程："+num,tasks).start();
            num++;
        }else if(num<maxSize){
            new Myworker("非核心线程："+num,tasks).start();
            num++;
        }else{
            System.out.println("任务："+r+"被缓存了");
        }
    }
}
