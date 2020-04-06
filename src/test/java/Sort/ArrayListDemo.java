package Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Ryan
 * @date 2020/4/4 9:36
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Circle> list=new ArrayList<>();
        //添加circle操作
        list.add(new Circle());
        //删除第0个circle
        list.remove(0);
        //循环添加20个Circle对象
        for(int i=0;i<20;i++){
            list.add(new Circle());
        }
        //从ArrayList中取出第3个对象
        Circle a = list.get(3);
        //将Circle按照weight排序，这个是难点
        Collections.sort(list, new Comparator<Circle>() {
            @Override
            public int compare(Circle o1, Circle o2) {
                return o1.weight-o2.weight;
            }
        });
        //将Circle按照rgb排序
        Collections.sort(list, new Comparator<Circle>() {
            @Override
            public int compare(Circle o1, Circle o2) {
                return o1.rgb-o2.rgb;
            }
        });
        for(Circle c:list){
            System.out.println(c);
        }


    }
}
