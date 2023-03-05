package net.mytrofanov.awt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestFieldExample extends Frame implements ActionListener {

    private TextField tf1;
    private TextField tf2;
    private TextField tf3;

    private Button bt1;
    private Button bt2;

    public TestFieldExample() {
        tf1 = new TextField("First name");
        tf1.setBounds(50, 50, 150, 20);
        tf2 = new TextField("Last name");
        tf2.setBounds(50, 100, 150, 20);
        tf3 = new TextField();
        tf3.setBounds(50, 150, 150, 20);
        tf3.setEditable(false);
        bt1 = new Button("Add");
        bt2 = new Button("Subtract");
        bt1.setBounds(50, 200, 50, 50);
        bt2.setBounds(120, 200, 50, 50);
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        add(tf1);
        add(tf2);
        add(tf3);
        add(bt1);
        add(bt2);
        setSize(300,300);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s1 = tf1.getText();
        String s2 = tf2.getText();
        System.out.println("Text in the frame 1: " + s1);
        System.out.println("Text in the frame 1: " + s2);
    }
}
