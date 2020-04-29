package java学习.swing;

import javax.swing.*;

/**
 * @author Ryan
 * @date 2020/4/22 16:01
 */
public class SampleGUI {
    public static void main(String[] args) {
        //String s= JOptionPane.showInputDialog("tell me your age");
        //JOptionPane.showMessageDialog(null,"hello world","my title",JOptionPane.INFORMATION_MESSAGE);
        int x=JOptionPane.showConfirmDialog(null,"yes or no?","Choose!",JOptionPane.YES_NO_OPTION);
        if(x==JOptionPane.NO_OPTION)
            System.out.println("user say no");
        else System.out.println("user say yes");
    }
}
