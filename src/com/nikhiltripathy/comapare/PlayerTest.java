package com.nikhiltripathy.comapare;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerTest {

    public static void main(String[] args) {
        List<Player> playerList = new ArrayList<>();
        playerList.add(new Player(2,13,"Maxwel"));
        playerList.add(new Player(4,16,"Powel"));
        playerList.add(new Player(7,15,"Dhoni"));
        playerList.add(new Player(1,10,"Yuvi"));
        playerList.add(new Player(5,13,"Samson"));


        System.out.println("Sorting by ranking");
        Collections.sort(playerList, (p1,p2) -> {
            return Integer.compare(p1.getRanking(),p2.getRanking());
        });

        playerList.stream()
                .forEach(System.out::println);

        System.out.println("Sorting by age");

        Collections.sort(playerList, (p1,p2) -> Integer.compare(p1.getAge(),p2.getAge()));

        playerList.stream().forEach(System.out::println);

        System.out.println("sorting by name... using comparable..");
        Collections.sort(playerList);

        playerList.stream()
                .forEach(System.out::println);
    }
}
