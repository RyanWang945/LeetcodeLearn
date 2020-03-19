package java学习.枚举类;

/**
 * @author Ryan
 * @date 2020/3/17 10:15
 */
public class EnumDemo {
    public static void main(String[] args) {
        Sex s=Sex.Boy;
        System.out.println(s);
        System.out.println(s.ordinal());//返回枚举类的变量的索引位置
    }
}
enum Sex{
    Boy,girl;
}
