package java学习.java8特殊特性学习.lambda;

/**
 * @author Ryan
 * @date 2020/6/3 10:11
 */
public class LambdaDemo1 {
    interface Printer{
        void printer(String val);
    }
    public void printSomething(String something,Printer printer){
        printer.printer((something));
    }

    public static void main(String[] args) {
        LambdaDemo1 demo=new LambdaDemo1();
        String some="helloworld";
//        Printer printer=new Printer() {
//            @Override
//            public void printer(String val) {
//                System.out.println(val);
//            }
//        };
//        demo.printSomething(some,printer);
        /**
         * lambda表达式相当于一个匿名函数实现
         */
//        Printer printer=(String val)->{
//            System.out.println(val);
//        };
        //类型可以去掉，前提是只有一个参数
        //括号亦可以去掉
//        Printer printer=(val)->{
//            System.out.println(val);
//        };
        //Printer printer1=val-> System.out.println(val);
        //再简化的话，就是将这个对象的初始化放在调用位置
        demo.printSomething(some,val->System.out.println(val));
        //demo.printSomething(some,printer);
    }
}
