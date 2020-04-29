package java学习.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Ryan
 * @date 2020/4/23 9:05
 * 5行6列
 */
public class MyFrame extends JFrame {
    JTextArea output;
    JScrollPane scrollPane;
    JLabel carOne;
    JLabel carTwo;
    JTextField carOneText;
    JTextField carTwoText;
    JButton save1;//event save the name of Car one
    JButton save2;//event save the name of Car two
    JButton selectCoupe1;
    JButton selectTruck1;
    JButton selectCoupe2;
    JButton selectTruck2;
    JLabel welcome;
    JLabel coupeOrTruck1;
    JLabel coupeOrTruck2;
    JLabel pressToSpin;
    JButton spin;
    public MyFrame(){
        super("Truck Race");
        init();
        save1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("name of car one: "+carOneText.getText());
            }
        });
        save2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("name of car two: "+carTwoText.getText());
            }
        });
    }
    public void init(){

        Container c=getContentPane();
        c.setLayout(new FlowLayout());
        c.setLayout(new GridBagLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);
        setVisible(true);
        setResizable(false);
        coupeOrTruck1=new JLabel("Coupe Or Truck?");
        coupeOrTruck2=new JLabel("Coupe Or Truck?");
        welcome=new JLabel("Welcome to TruckRace!");
        carOne=new JLabel("Car One");
        carTwo=new JLabel("Car two");
        pressToSpin=new JLabel("Press to spin:");
        carOneText=new JTextField(8);
        carTwoText=new JTextField(8);
        save1=new JButton("Save");
        save2=new JButton("Save");
        selectCoupe1=new JButton("Coupe");
        selectTruck1=new JButton("Truck");
        selectCoupe2=new JButton("Coupe");
        selectTruck2=new JButton("Truck");
        spin=new JButton("Spin");
        //welcome.setBounds(10,20,200,25);



        output=new JTextArea(20,50);
        scrollPane=new JScrollPane(output);
        output.setEditable(false);
        output.setText("text");
        output.setFont(new Font("monospaced",Font.PLAIN,12));
        output.setCaretPosition(output.getText().length());

        GridBagConstraints g1=new GridBagConstraints();
        g1.gridy=0;
        g1.gridx=2;
        c.add(welcome,g1);
        GridBagConstraints g2=new GridBagConstraints();
        g2.gridy=1;
        g2.gridx=0;
        c.add(carOne,g2);
        GridBagConstraints g3=new GridBagConstraints();
        g3.gridy=1;
        g3.gridx=1;
        c.add(carOneText,g3);
        GridBagConstraints gsave1=new GridBagConstraints();
        gsave1.gridy=1;
        gsave1.gridx=2;
        c.add(save1,gsave1);
        GridBagConstraints g4=new GridBagConstraints();
        g4.gridy=1;
        g4.gridx=4;
        c.add(carTwo,g4);
        GridBagConstraints g5=new GridBagConstraints();
        g5.gridy=1;
        g5.gridx=5;
        c.add(carTwoText,g5);
        GridBagConstraints gsave2=new GridBagConstraints();
        gsave2.gridy=1;
        gsave2.gridx=6;
        c.add(save2,gsave2);
        GridBagConstraints gselect1=new GridBagConstraints();
        gselect1.gridy=2;
        gselect1.gridx=0;
        gselect1.gridwidth=2;
        c.add(coupeOrTruck1,gselect1);
        GridBagConstraints gselect2=new GridBagConstraints();
        gselect2.gridy=2;
        gselect2.gridx=4;
        gselect2.gridwidth=2;
        c.add(coupeOrTruck2,gselect2);

        GridBagConstraints gPressToSpin=new GridBagConstraints();
        gPressToSpin.gridy=3;
        gPressToSpin.gridx=2;
        c.add(pressToSpin,gPressToSpin);

        GridBagConstraints gSpinButton=new GridBagConstraints();
        gSpinButton.gridy=3;
        gSpinButton.gridx=3;
        c.add(spin,gSpinButton);

        GridBagConstraints gCoupe1=new GridBagConstraints();
        gCoupe1.gridy=2;
        gCoupe1.gridx=2;
        c.add(selectCoupe1,gCoupe1);
        GridBagConstraints gTruck1=new GridBagConstraints();
        gTruck1.gridy=2;
        gTruck1.gridx=3;
        c.add(selectTruck1,gTruck1);

        GridBagConstraints gCoupe2=new GridBagConstraints();
        gCoupe2.gridy=2;
        gCoupe2.gridx=6;
        c.add(selectCoupe2,gCoupe2);
        GridBagConstraints gTruck2=new GridBagConstraints();
        gTruck2.gridy=2;
        gTruck2.gridx=7;
        c.add(selectTruck2,gTruck2);

        GridBagConstraints goutput=new GridBagConstraints();
        goutput.gridy=4;
        goutput.gridx=0;
        goutput.gridwidth=6;
        goutput.gridheight=4;
        c.add(output,goutput);
        Container c2=new Container();
        add(c2);
        c2.add(output);
    }
}
