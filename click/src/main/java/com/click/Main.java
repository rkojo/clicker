package com.click;

import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

public class Main {
  static boolean isSet = false;
 static Boolean looper = true;
  static Boolean quitter = false;

 //default to 2.
 static int amount = 2;
 static int sleepingtime = 1000;

  public static void main(String[] args) throws AWTException {
    frame f = new frame();
    Robot bot = new Robot();
    while (looper) {
      System.out.println(isSet);
      if (isSet == true) {
        for (int i = 0; i < amount; i++) {
          if (quitter == false) {
                    try {
            TimeUnit.MILLISECONDS.sleep(sleepingtime);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }   
          bot.mouseMove(frame.mousex, frame.mousey);
          bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
          System.out.println("pressed");
          bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

          if(i == amount - 1) {
            isSet = false;
            break;

          }
        }
        }
      }
    }
  }
}