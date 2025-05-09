package com.pluralsight;

import java.util.ArrayList;

public class BlackJack {
    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>();
        int numPlayers;
        Player dealer=new Player("Dealer");
        while (true) {
            numPlayers = MyUtils.askQuestionGetInt("Enter number of players: ");
            if (numPlayers > 9) {
                System.out.println("That's too many players.");
                continue;
            } else if (numPlayers < 1) {
                System.out.println("Must have at least one player");
                continue;
            }
            break;
        }
        for (int i = 0; i < numPlayers; i++) {
            String playerName=MyUtils.askQuestionGetString("Enter player "+(i+1)+"'s name: ");
            players.add(new Player(playerName));
        }
        Deck deck=new Deck();
        deck.shuffle();
        for (int i = 0; i < 2; i++) {
            for (Player p : players) {
                p.getHand().Deal(deck.deal());
            }
            dealer.getHand().Deal(deck.deal());
        }
        for(Player p:players){
            while(true){
                System.out.printf("Player: %s Hand: %s\n",p.getName(),p.getHand().getHandString());
                System.out.printf("Dealers hand: %s\n",dealer.getHand().getDealerHandString());
                if(p.getPoints()>21){
                    System.out.printf("%s busts.\n",p.getName());
                    break;
                }
                switch (MyUtils.askQuestionGetString("Enter (H) to hit, (S) to stay: ").toUpperCase()){
                    case "H":{
                        p.getHand().Deal(deck.deal());
                        p.setPoints(p.getHand().getValue());
                        continue;
                    }
                    case "S":{
                        break;
                    }
                }

                break;
            }
        }

        for(Player p:players){
            p.setPoints(p.getHand().getValue());
            System.out.printf("Player: %s Hand: %s\n",p.getName(),p.getHand().getHandString());
        }
        dealer.setPoints(dealer.getHand().getValue());
        System.out.printf("Dealer Hand: %s\n",dealer.getHand().getHandString());
        while(dealer.getPoints()<17){
            System.out.println("Dealer hits.");
            dealer.getHand().Deal(deck.deal());
            dealer.setPoints(dealer.getHand().getValue());
            System.out.println(dealer.getPoints());
            System.out.printf("Dealer Hand: %s\n",dealer.getHand().getHandString());
        }
        for(Player p:players){
            if(p.getPoints()<=21&&dealer.getPoints()>21){
                System.out.printf("Dealer busts, %s wins!\n",p.getName());
            } else if (p.getPoints()>21&&dealer.getPoints()<=21) {
                System.out.printf("%s busts, dealer wins.\n",p.getName());
            } else if(p.getPoints()> dealer.getPoints()&&p.getPoints()<=21){
                System.out.printf("%s Wins!\n",p.getName());
            } else if (p.getPoints()< dealer.getPoints()&&dealer.getPoints()<=21) {
                System.out.printf("Dealer beats %s.\n",p.getName());
            } else{
                System.out.printf("%s drew with dealer.\n",p.getName());
            }
        }
    }
}
