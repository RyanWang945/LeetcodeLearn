package javalearn.线程池学习;

import java.util.List;

/**
 * @author Ryan
 * @date 2020/1/10 14:19‘
 * 编写一个线程类，继承Thread类，设计一个线程的名字属性
 * 设计一个集合，用于保存所有的任务
 */
public class Myworker extends Thread{
    private String name;
    private List<Runnable> tasks;

    public Myworker(String name, List<Runnable> tasks) {
        super(name);
        this.tasks = tasks;
    }

    @Override
    public void run() {
        //判断集合中是否有任务，如果有，就一直执行
        while(tasks.size()>0){
            Runnable r=tasks.remove(0);
            r.run();
        }
    }
}
