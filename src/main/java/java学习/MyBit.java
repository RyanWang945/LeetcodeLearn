package java学习;

/**
 * @author Ryan
 * @date 2020/1/1 20:52
 */
public class MyBit {
    /**
     *11=1011,13=1101,所以11&13=1001,也就是9
     * @param args
     */
    public static void main(String[] args) {
        int a=123456789;
        long starttime=System.nanoTime();
        //System.out.println(a*2*2*2);
        System.out.println(a<<2);
        long end=System.nanoTime();
        System.out.println(end-starttime);
        System.out.println(Integer.toBinaryString(a));
    }
    /**
     * 115601,234200,197700,159300
     * 246000,168500,148000,186201
     */

}
