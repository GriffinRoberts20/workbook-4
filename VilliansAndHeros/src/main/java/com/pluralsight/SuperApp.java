package com.pluralsight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SuperApp {
    public static void main(String[] args) throws InterruptedException {
        //instantiate fighters
        SuperHero hancock = new SuperHero("Hancock", 100, 20);
        SuperVillain bob = new SuperVillain("Bob", 100,20);
        //adds fighters to list of fighters
        ArrayList<SuperPerson> fighters=new ArrayList<>();
        fighters.add(hancock);
        fighters.add(bob);
        //prints fighters status
        System.out.println(hancock.getStatus());
        System.out.println(bob.getStatus());
        //initialize and populate the powerups
        Map<String,Integer> items=new HashMap<>();
        items.put("crowbar",15);
        items.put("bat",5);
        items.put("mace",25);
        //distributes powerups randomly to fighters
        for(String key:items.keySet()){
            SuperPerson randomFighter = fighters.get((new Random().nextInt(fighters.size())));
            randomFighter.addPowerup(key,items.get(key));
        }
        Thread.sleep(5000);
        //announce the fight
        printFightStart();
        //turn counter
        int turn =1;
        //start fight
        while(bob.isAlive() && hancock.isAlive()){
            if(turn>1){
                Thread.sleep(300);
                MyUtils.printDivider(50);
            }
            hancock.turn(bob,turn);
            //end fight if opponent died
            if(!bob.isAlive()) break;
            Thread.sleep(300);
            MyUtils.printDivider(50);
            bob.turn(hancock,turn);
            turn++;
        }
        printFightResult(hancock,bob);

    }

    public static void printFightStart() throws InterruptedException {
        MyUtils.printDivider(50);
        System.out.print("\nSome");
        Thread.sleep(300);
        System.out.print("body ");
        Thread.sleep(300);
        System.out.print("is ");
        Thread.sleep(300);
        System.out.print("go");
        Thread.sleep(300);
        System.out.print("ing ");
        Thread.sleep(300);
        System.out.print("to ");
        Thread.sleep(300);
        System.out.print("die");
        Thread.sleep(600);
        System.out.print(".\n\n");
        Thread.sleep(300);
        MyUtils.printDivider(50);
        Thread.sleep(5000);
        MyUtils.clearTerminal();
        Thread.sleep(500);
    }

    public static void printFightResult(SuperPerson superOne,SuperPerson superTwo) throws InterruptedException {
        Thread.sleep(300);
        MyUtils.printDivider(50);
        Thread.sleep(300);
        System.out.println("Battle concluded.\n");
        Thread.sleep(1000);
        //call winner
        if(superOne.isAlive()) {
            if(superOne.isHero()) System.out.println(superOne.name + " murdered " + superTwo.name + ".\n");
            else System.out.println(superOne.name+" bonked "+superTwo.name+" to death.\n");
        }
        else {
            if(superTwo.isHero()) System.out.println(superTwo.name + " murdered " + superOne.name + ".\n");
            else System.out.println(superTwo.name+" bonked "+superOne.name+" to death.\n");
        }
        Thread.sleep(2000);
        //print logs
        superOne.printBattleLog();
        superTwo.printBattleLog();
    }
}
