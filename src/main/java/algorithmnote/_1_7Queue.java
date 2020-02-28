package algorithmnote;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;

/**
 * @author Ryan
 * @date 2020/1/7 15:47
 * Queue接口可以接受一个LinkedList对象
 * 需要注意的是LinkedList是一个无容量限制的双向链表。
 * 其中有多个常用方法
 */
public class _1_7Queue {
    Queue<Integer> myqueue=new LinkedList<>();
    @Test
    public void testQueue(){
//        myqueue.add(1);
//        myqueue.offer(2);
//        myqueue.offer(4);
//        myqueue.add(7);
//        System.out.println(myqueue.isEmpty());
//        System.out.println(myqueue);
//        System.out.println(myqueue.remove());
//        System.out.println(myqueue.remove(7));
//        System.out.println(myqueue);
//
//        List<Integer> list=new ArrayList<>();
//        list.add(3);
//        list.add(0,4);
//        System.out.println(list);
//        ArrayList<Integer> arrayList=new ArrayList<>(3);
//        arrayList.add(1);
//        arrayList.add(2);
//        arrayList.add(3);
//        arrayList.add(4);
//        System.out.println(arrayList);

        ArrayList a=new ArrayList();
        Bike _1=new Bike("第一辆车");
        Bike _2=new Bike("第一辆车");
        Bike _25=new Bike("第2.5辆车");
        a.add(_1);
        a.add(_2);
        ArrayList b=(ArrayList)a.clone();
        //_1.setName("第一辆车坏了");
        System.out.println(a);
        System.out.println(b);
        a.add(1,_25);
        System.out.println(a);
        System.out.println(b);
        System.out.println("size of a is:"+a.size());
        System.out.println("size of b is:"+b.size());
        LinkedList linkedList=new LinkedList();
        a.clear();
        System.out.println(a);
        System.out.println(b);
        System.out.println(_25);
        System.out.println(_1.equals(_2));
        Object o1=_1;
        Object o2=_2;
        System.out.println(o1.equals(o2));


    }
    class Bike{
        private String name;

        public Bike(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Bike{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
