package net.mytrofanov.awt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AwtEmployeeExample implements ActionListener {

    private TextField textField;

    public AwtEmployeeExample() {
        Frame frame = new Frame();
        Label label = new Label("Employee id:");
        Button button = new Button("Submit");
        textField = new TextField();

        // setting position of above components in the frame
        label.setBounds(20, 80, 80, 30 );
        textField.setBounds(20, 100, 80, 30 );
        button.setBounds(100, 100, 80, 30 );
        button.addActionListener(actionEvent -> System.out.println("pressed" + actionEvent.getActionCommand()));

        // adding components into frame
        frame.add(button);
        frame.add(label);
        frame.add(textField);

        // frame size 300 width and 300 height
        frame.setSize(400, 300);

        // setting the title of frame
        frame.setTitle("Employee info");

        frame.setLayout(null);

        // setting visibility of frame
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        String text = textField.getText();
//        int integer = Integer.parseInt(text);
//        System.out.println("Entered employee id: " + integer);
        textField.setText("Welcome");
    }
}
