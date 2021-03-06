package io.zipcoder.casino.allCasino.games;

import io.zipcoder.casino.allCasino.ioMessages.*;
import io.zipcoder.casino.allCasino.card.Card;
import io.zipcoder.casino.allCasino.card.CardGame;
import io.zipcoder.casino.allCasino.interfaces.Game;
import io.zipcoder.casino.allCasino.player.*;

import java.util.ArrayList;

public class BlackJackHand {

    ArrayList<Card> hand;
    GameConsole gameConsole;

    public BlackJackHand() {
        hand = new ArrayList<Card>();
        gameConsole = new GameConsole();
    }

    public void add(Card c) {
        hand.add(c);
    }

    public Card[] getCards() {
        Card [] cards = new Card[hand.size()];
        return hand.toArray(cards);
    }


    public void displayHand() {
        for (int i = 0; i < hand.size(); i++) {
            gameConsole.println(hand.get(i).toString() + "\n");
        }
    }
    public void displayHand(String message) {
        gameConsole.println(message);
        displayHand();
    }

    public void displayDealerHand() {
        gameConsole.println("This is the dealer's hand =^.^=");
        gameConsole.println(Card.getBackOfCard());
        for (int i = 1; i < hand.size(); i++) {
            System.out.println(hand.get(i).toString() + "\n");
        }
    }

    public int getTotal() {
        int total = 0;
        int aceCount = 0;
        for (Card c : hand) {
            if (c.getFace().equals(Face.JACK) || c.getFace().equals(Face.QUEEN) || c.getFace().equals(Face.KING)){
                total += 10;
            }
            else if (c.getFace().equals(Face.ACE)) {
                aceCount++;
            }
            else total += c.getFace().getValue();
        }

        if (aceCount > 0) {
            total =  tallyAces(aceCount, total);
        }
        return total;
    }

    private int tallyAces(int aceCount, int tally) {
        for(int i =1; i <= aceCount; i++) {
            if (21 - (tally + aceCount - i) >=11) {
                tally += 11;
            }
             else {
                tally += 1;
            }
        }
        return tally;
    }

}
