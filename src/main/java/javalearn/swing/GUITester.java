package javalearn.swing;

/**
 * @author Ryan
 * @date 2020/4/22 16:28
 */
public class GUITester {
    public static void main(String[] args) {
//        MyUI f=new MyUI();
//        //这个用来设置关闭窗口时终止程序
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        f.setSize(400,200);
//        f.setVisible(true);
//        f.setLayout(new GridLayout(4,5));
        /**
         * 这只一个包含默认文字的text框
         */
        MyFrame f=new MyFrame();
        f.setSize(800,600);
        f.setVisible(true);
        f.setResizable(false);
    }
}
