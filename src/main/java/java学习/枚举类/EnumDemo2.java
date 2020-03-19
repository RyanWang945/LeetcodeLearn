package java学习.枚举类;

/**
 * @author Ryan
 * @date 2020/3/17 10:21
 * 做信息标志和信息分类
 */
public class EnumDemo2 {
    public static void main(String[] args) {
        move(Orientation.LEFT);
    }
    private static void move(Orientation orientation){
        switch (orientation){
            case UP:
                System.out.println("上");
                break;
            case DOWN:
                System.out.println("下");
                break;
            case LEFT:
                System.out.println("左");
                break;
            case RIGHT:
                System.out.println("右");
                break;
        }
    }
}
enum Orientation {
    UP,DOWN,LEFT,RIGHT;
}
