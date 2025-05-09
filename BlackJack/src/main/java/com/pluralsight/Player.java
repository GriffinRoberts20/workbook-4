package com.pluralsight;

public class Player {

    private Hand hand;
    private String name;
    private int points;

    public Player(Hand hand, String name) {
        this.hand = hand;
        this.name = name;
    }

    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
    }

    public int getPoints() {
        if(points<=21) {
            return points;
        }else if(this.hand.getHandString().contains("A")&&points>21){
            int count=this.hand.getHandString().length()-this.hand.getHandString().replace(String.valueOf('A'),"").length();
            while(points>21&&count>0){
                this.setPoints(points-10);
                count--;
            }
            return points;
        }
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
