package com.nikhiltripathy.comapare;

public class Player implements Comparable<Player> {
    private  int ranking;
    private  int age;
    private String name;

    public Player() {
    }

    public Player(int ranking, int age, String name) {
        this.ranking = ranking;
        this.age = age;
        this.name = name;
    }

    public int getRanking() {
        return ranking;
    }

    @Override
    public String toString() {
        return "Player{" +
                "ranking=" + ranking +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Player o) {
        return getName().compareTo(o.getName());
    }
}
