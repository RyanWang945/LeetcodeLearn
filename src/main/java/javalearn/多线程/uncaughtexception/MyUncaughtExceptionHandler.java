package javalearn.多线程.uncaughtexception;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Ryan
 * @date 2020/11/26 19:28
 */
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    private String name;
    public MyUncaughtExceptionHandler(String s){
        this.name=s;
    }
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Logger logger=Logger.getAnonymousLogger();
        logger.log(Level.WARNING,"线程异常，终止 "+t.getName(),e);
        System.out.println(name+"捕获了"+t.getName()+"异常"+e);
    }
}
