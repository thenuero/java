package com.nikhiltripathy.lambdas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 28/08/2025 at 13:19
 * Author: theneuro
 */

public class EffectiveFinal {

    private static void addMessage(int count, String message) {
        List<String> myList = new ArrayList<>();

        Runnable runnable = () -> {
           // myList = new ArrayList<>(); Illegal, should be final or effectively final.
          for (int i=0;i<count;i++) {
              myList.add(message); // allowed by compiler but breaks immutability.
          }
            System.out.println(myList.size());
        };

        new Thread(runnable).start();
    }

    public static void main(String[] args) {
        addMessage(100, "Hello");
    }
}
