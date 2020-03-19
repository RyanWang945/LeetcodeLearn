package java学习.单例模式;

/**
 * @author Ryan
 * @date 2020/3/17 9:28
 * 饿汉单例
 */
public class SingleInstance {
    public static void main(String[] args) {
        Single instance = Single.getInstance();
    }
}
class Single{
    /**
     * static在类加载时已经创建好了
     */
    public static  Single instance=new Single();
    private  Single(){

    }
    public static  Single getInstance(){
        return instance;
    }
}

/**
 * 懒汉
 */
class SingleLazy{
    //不能直接创建对象
    public static SingleLazy instance;
    private SingleLazy(){

    }
    public static SingleLazy getInstance(){
        if(instance==null){
            //第一次来取对象，创建对象
            instance=new SingleLazy();
        }
        return instance;
    }
}

