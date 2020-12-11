package javalearn.多线程.停止线程;

/**
 * @author Ryan
 * @date 2020/11/23 19:55
 * run无法抛出checked Exception只能用try catch
 */
public class RunThrowException {
    public void aVoid() throws Exception {
        throw new Exception();
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
            }
        });
    }
}
