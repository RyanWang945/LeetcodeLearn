package 子类父类测试;

import java.util.ArrayList;

/**
 * @author Ryan
 * @date 2020/4/12 21:26
 */
public class TestMain {
    public static void main(String[] args) {
        ArrayList<Car> list= new ArrayList<>();
        list.add(new Coupe());
        list.add(new Truck());
        for(Car c:list){
            c.sayHello();
        }
    }
}
