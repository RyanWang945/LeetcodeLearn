package Sort;

/**
 * @author Ryan
 * @date 2020/4/4 9:34
 */
public class Circle{
    int weight;
    int rgb;
    public Circle(){
        weight= (int) (Math.random() * 20);
        rgb= (int) (Math.random() * 255);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "weight=" + weight +
                ", rgb=" + rgb +
                '}';
    }
}
