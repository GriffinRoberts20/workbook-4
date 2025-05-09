package com.pluralsight;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;
    public Hand(){
        cards = new ArrayList<>();
    }
    // A Card is dealt to the Hand and the Hand is responsible
// to store the card
    public void Deal(Card card){
        cards.add(card);
    }
    public int getSize(){
        return cards.size();
    }
    public String getHandString(){
        StringBuilder s=new StringBuilder();
        for(Card card:cards){
            if(!card.isFaceUp()) {
                card.flip();
            }
            s.append(card.getValue()+" ");
        }
        return s.toString().trim();
    }
    public String getDealerHandString(){
        if(!cards.get(0).isFaceUp()) {
            cards.get(0).flip();
        }
        return cards.get(0).getValue()+" #";
    }
    // The Hand uses the methods of each card to determine
// the value of each card - and adds up all values
    public int getValue(){
        int value = 0;
        for(Card card: cards){
            if(!card.isFaceUp()) {
                card.flip(); // turn the card over to see the value
            }
            value += card.getPointValue();
            card.flip(); // hide the card again
        }
        return value;
    }
}
