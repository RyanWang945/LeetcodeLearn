package 线程池学习;

/**
 * @author Ryan
 * @date 2020/1/10 14:15
 * 自定义线程池练习，任务类
 * 实现runnable接口
 */
public class Mytask implements Runnable {
    private int id;

    public Mytask(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("线程："+name+"即将执行任务："+id);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程："+name+"完成了任务："+id);
    }

    @Override
    public String toString() {
        return "Mytask{" +
                "id=" + id +
                '}';
    }
}
