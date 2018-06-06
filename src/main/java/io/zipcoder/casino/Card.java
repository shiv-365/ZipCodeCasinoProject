package io.zipcoder.casino;

enum Suit{
    SPADES, HEARTS, DIAMONDS, CLUBS
}


enum Face{
    TWO (2), THREE (3), FOUR (4), FIVE (5), SIX (6), SEVEN (7),
    EIGHT (8), NINE (9), TEN (10), JACK(11), QUEEN(12), KING (13), ACE (14);

    private final int value;

    private Face(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}


public class Card implements Comparable<Card>{

    private Suit suit;
    private Face face;



    public Card(Face face, Suit suit){
        this.face = face;
        this.suit = suit;

    }

    public Suit getSuit(){

        return suit;
    }

    public Face getFace(){

        return face;
    }

    public int compareTo(Card card){
    return Integer.compare(face.getValue(), card.getFace().getValue());
}

    public String toString() {
        return face.toString() + " of " + suit.toString();
    }

}
