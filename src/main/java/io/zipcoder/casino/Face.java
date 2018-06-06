package io.zipcoder.casino;

enum Face{
    TWO (2, "two"), THREE (3, "three"), FOUR (4, "four"), FIVE (5, "five"), SIX (6, "six"), SEVEN (7, "seven"),
    EIGHT (8, "eight"), NINE (9, "nine"), TEN (10, "ten"), JACK(11, "jack"), QUEEN(12, "queen"), KING (13, "king"), ACE (14, "ace");

    private final int value;
    private final String cardImage;

    private Face(int value, String cardImage){
        this.value = value;
        this.cardImage = cardImage;
    }

    public int getValue(){
        return value;
    }
    public String getCardImage() { return cardImage; }
}