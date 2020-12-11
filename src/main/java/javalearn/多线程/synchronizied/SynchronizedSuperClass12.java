package javalearn.多线程.synchronizied;

/**
 * @author Ryan
 * @date 2020/11/25 14:32
 * 可重入粒度测试，调用父类的方法
 */
public class SynchronizedSuperClass12 {
    public synchronized void doSomeThing(){
        System.out.println("我是父类方法");
    }

    public static void main(String[] args) {
        TestClass s=new TestClass();
        s.doSomeThing();
    }
}
class TestClass extends SynchronizedSuperClass12{
    public synchronized void doSomeThing(){
        System.out.println("我是子类方法");
        super.doSomeThing();
    }
}
