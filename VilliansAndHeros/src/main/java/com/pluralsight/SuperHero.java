package com.pluralsight;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SuperHero extends SuperPerson{

    public SuperHero(String name, int health, int powerLevel){
        super(name,health);
        this.experiencePoints=powerLevel;

        System.out.println(this.name+" has arrived with a power level of "+powerLevel);
    }

    @Override
    public void fight(SuperPerson opponent) throws InterruptedException {
        //generates random damage
        int randomDamage= ThreadLocalRandom.current().nextInt(0,10);
        //attack misses if rolled 0 random damage
        if(randomDamage==0){
            System.out.println(this.name+" missed.");
        }
        //damage calculation
        else {
            //defaults to randomDamage plus xp
            int totalDamage=randomDamage+this.experiencePoints;
            //uses random powerup if available
            if(this.hasItem()) {
                ArrayList<String> items = new ArrayList<>(inventory.keySet());

                String randomItem = items.get(new Random().nextInt(items.size()));
                System.out.println(this.name+" used "+randomItem+".");
                totalDamage += inventory.get(randomItem);
                inventory.remove(randomItem);
            }
            //logs hit count
            this.logHit(opponent);
            //display damage
            System.out.println(this.name+" bludgeoned "+opponent.name+" for "+totalDamage+" damage.");
            //calculate opponent health post attack
            opponent.takeDamage(totalDamage);
        }
    }

    @Override
    public String getType(){
        return this.getClass().getSimpleName();
    }

    @Override
    public boolean isHero(){
        return true;
    }
}
