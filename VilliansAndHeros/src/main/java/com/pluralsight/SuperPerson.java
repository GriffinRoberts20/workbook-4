package com.pluralsight;

import java.util.HashMap;
import java.util.Map;

public abstract class SuperPerson {
    protected String name;
    protected int health;
    protected int maxHealth;
    protected int experiencePoints;
    protected Map<String,Integer> battleLog=new HashMap<>();
    protected Map<String,Integer> inventory=new HashMap<>();

    public SuperPerson(String name, int health) {
        this.name = name;
        this.health = health;
        this.maxHealth= health;
        this.experiencePoints = 0;
    }

    public boolean isAlive(){
        return this.health > 0;
    }

    public void takeDamage(int damageAmount) throws InterruptedException {
        this.health= Math.max(this.health - damageAmount, 0);
        if(this.health==0){
            Thread.sleep(3000);
            System.out.println();
            System.out.print("<");
            Thread.sleep(1000);
            System.out.print("/");
            Thread.sleep(1000);
            System.out.print("3\n\n");
            Thread.sleep(1000);
            System.out.println(this.name+" died.");
            Thread.sleep(1000);
        }
    }

    public String getStatus(){

        StringBuilder heartString=new StringBuilder();
        heartString.append("|");
        int h=0;
        while(h<this.maxHealth){
            if(h<this.health) heartString.append("/");
            else heartString.append("_");
            h+=5;
        }
        heartString.append("|");
        return this.name+" has "+this.health+" health left.\n"+heartString;
    }

    public void gainXP(int xp){
        this.experiencePoints+=xp;
    }

    public abstract void fight(SuperPerson opponent) throws InterruptedException;

    public void addPowerup(String item,int value){
        inventory.put(item,value);
        System.out.println(this.name+" received a(n) "+item+".");
    }

    public boolean hasItem(){
        return !inventory.isEmpty();
    }

    public void logHit(SuperPerson opponent){
        String name=opponent.name;
        int count=battleLog.getOrDefault(name,0);
        battleLog.put(name,count+1);
    }

    public void printBattleLog(){
        System.out.println("Battle log for "+this.name+":");
        for(Map.Entry<String,Integer> entry: battleLog.entrySet()){
            System.out.println(" - Hit "+entry.getKey()+": "+entry.getValue()+" times");
        }
    }

    public void turn(SuperPerson opponent,int turn) throws InterruptedException {
        Thread.sleep(300);
        //print whose turn and turn counter
        System.out.println(this.name+"'s "+ turn + MyUtils.getNumberSuffix(turn)+" turn:");
        Thread.sleep(300);
        //fight
        this.fight(opponent);
        Thread.sleep(300);
        //if opponent lived, print status
        if(opponent.isAlive()) System.out.println(opponent.getStatus());
        MyUtils.pressEnterToContinueQuiet();
    }

    public abstract String getType();

    public abstract boolean isHero();
}
