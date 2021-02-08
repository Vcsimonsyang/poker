package com.github.Poker;

import java.util.*;

public class Poker {
    public static void main(String[] args) {
        //create a HashMap to store the index and the poker value;
        HashMap<Integer, String> cards = new HashMap<>();

        //create an ArrayList to store all the index;
        int index = 0;
        ArrayList<Integer> keys = new ArrayList();

        //Use String to build all the 54 poker;
        String[] colors = {"♦", "♣", "♥", "♠"};
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        //put all the index and cards into the HashMap--cards.
        //put all the index into ArrayList-- keys.
        for (String number : numbers) {
            for (String color : colors) {
                cards.put(index, color + number);
                keys.add(index);
                index++;
            }
        }
        cards.put(index, "Joker1");
        keys.add(index);
        index++;
        cards.put(index, "Joker2");
        keys.add(index);

        //create 3 players and ends cards -- use TreeSet
        TreeSet<Integer> player1 = new TreeSet<>();
        TreeSet<Integer> player2 = new TreeSet<>();
        TreeSet<Integer> player3 = new TreeSet<>();
        TreeSet<Integer> ends = new TreeSet<>();

        //shuffle;
        Collections.shuffle(keys);

        //dealing;
        for (int i = 0; i < keys.size(); i++) {
            if (i >= keys.size() - 3) {
                ends.add(keys.get(i));
            } else if (i % 3 == 1) {
                player1.add(keys.get(i));
            } else if (i % 3 == 2) {
                player2.add(keys.get(i));
            } else if (i % 3 == 0) {
                player3.add(keys.get(i));
            }
        }
        //look cards
        lookCards("player1", player1, cards);
        lookCards("player2", player2, cards);
        lookCards("player3", player3, cards);
        lookCards("ends", ends, cards);
    }

    public static void lookCards(String name, TreeSet<Integer> player, HashMap<Integer, String> hm) {
        System.out.print(name + ":  ");
        for(int i : player){
            System.out.print(hm.get(i) + " ");
        }
        System.out.println();
    }
}
