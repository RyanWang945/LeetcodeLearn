package java学习.swing;

import javax.swing.*;
import java.awt.*;

/**
 * @author Ryan
 * @date 2020/4/22 16:26
 */
public class MyUI extends JFrame {
    private JLabel label1;
    public MyUI(){
        super("This displays in blue bar");
        setLayout(new FlowLayout());
        label1=new JLabel("Hah!");
        add(label1);
        JButton myButton=new JButton("Click me!");
        myButton.setToolTipText("hey look here");
        add(myButton);
    }
}
