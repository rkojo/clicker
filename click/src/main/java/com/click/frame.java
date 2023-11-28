package com.click;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class frame extends JFrame {
  static int mousex = 0;
  static int mousey = 0;

  public frame() {
    //frame
    getContentPane().setLayout(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    setTitle("clicker");
    setResizable(true);
    setSize(600, 500);
    System.out.println(mousex);
    System.out.println(mousey);

    //label for position
    JLabel position = new JLabel("X =" + mousex + " Y = " + mousey);
    position.setBounds(20, 130, 100, 20);
    add(position);

    //button to set
    JButton btn = new JButton("click to set");
    btn.setBounds(20, 160, 150, 30);
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
            position.setText("X =" + mousex + "Y = " + mousey);
          }
        });
      }
    });

    //entry for how much to click.
    JTextField aclick = new JTextField();
    JButton bclick = new JButton("Submit");
    JLabel cclick = new JLabel("Enter amount to repeat");
    bclick.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String st = aclick.getText();
        Main.amount = Integer.parseInt(st);
        cclick.setText("Repeat amount " + st + "times");
      }
    });
    aclick.setBounds(20, 35, 100, 30);
    bclick.setBounds(130, 35,80, 30);
    cclick.setBounds(20,0,150,30);
    add(aclick);
    add(bclick);
    add(cclick);

    //delay to wait
        JTextField adelay = new JTextField();
    JButton bdelay = new JButton("Submit");
    JLabel cdelay = new JLabel("Enter delay (in ms)");
    bdelay.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String amounttoclick = adelay.getText();
        Main.sleepingtime = Integer.parseInt(amounttoclick);
        cdelay.setText("delay = " + amounttoclick);
      }
    });
    adelay.setBounds(20, 90, 100, 30);
    bdelay.setBounds(130, 90,80, 30);
    cdelay.setBounds(20,60,150,30);
    add(adelay);
    add(bdelay);
    add(cdelay);
    JButton finalend = new JButton("Start");
    finalend.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Main.isSet = true;
      }
    });
    finalend.addKeyListener(new KeyListener() {
      @Override
      public void keyTyped(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_Q) {
          Main.quitter = true;
        }
      }

      @Override
      public void keyPressed(KeyEvent e) {
      }

      @Override
      public void keyReleased(KeyEvent e) {
      }
      
    });
    finalend.setBounds(20, 200, 80, 30);
    add(finalend);
    setVisible(true);
    revalidate();
  }

  public static int returnx() {
    return mousex;
  }

  public static int returny() {

    return mousey;
  }
  
}
