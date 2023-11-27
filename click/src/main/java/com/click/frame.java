package com.click;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class frame extends JFrame {
  static int mousex = 0;
  static int mousey = 0;
  boolean clicked = false;

  public frame() {
    //frame
    getContentPane().setLayout(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    setTitle("clicker");
    setResizable(true);
    setSize(600, 500);
    System.out.println(mousex);
    System.out.println(mousey);

    //label
    JLabel position = new JLabel("X =" + mousex + " Y = " + mousey);
    position.setBounds(20, 120, 100, 20);
    add(position);

    //button to set
    JButton btn = new JButton("click to set");
    btn.setBounds(20, 90, 150, 30);
    getContentPane().add(btn);
    //enable click to be selected
    btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        //new translucent frame to record click.
        JFrame j = new JFrame();
        j.setExtendedState(JFrame.MAXIMIZED_BOTH);
        j.setUndecorated(true);
        JLabel lab = new JLabel("where to click?");
        j.setOpacity((float) 0.2);
        j.add(lab);
        j.setVisible(true);
        j.addMouseListener(new MouseAdapter() {
          //when the mouse is clicked, it sets the values
          @Override
          public void mouseClicked(MouseEvent e) {
            mousex = e.getX();
            mousey = e.getY();
            System.out.println(mousex);
            System.out.println(mousey);
            j.setVisible(false);
            setVisible(true);
            clicked = true;
            Main.isSet = clicked;
            position.setText("X =" + mousex + "Y = " + mousey);
          }
        });
      }
    });

    //entry for how much to click.
    JTextField a = new JTextField();
    JButton b = new JButton("Submit");
    JLabel c = new JLabel("Enter amount to repeat");
    b.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String st = a.getText();
        Main.amount = Integer.parseInt(st);
        c.setText("Repeat amount " + st + "times");
      }
    });
    a.setBounds(20, 35, 100, 30);
    b.setBounds(130, 35,80, 30);
    c.setBounds(20,0,150,30);
    add(a);
    add(b);
    add(c);
  }

  public static int returnx() {
    return mousex;
  }

  public static int returny() {

    return mousey;
  }
  
}
