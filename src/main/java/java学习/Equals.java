package java学习;

/**
 * @author Ryan
 * @date 2020/1/1 20:39
 */
public class Equals {
    public static void main(String[] args) {
        Value1 v1=new Value1();
        Value1 v2=new Value1();
        v1.i=v2.i=100;
        System.out.println(v1.equals(v2));
    }
}
class Value1{
    int i;
}
