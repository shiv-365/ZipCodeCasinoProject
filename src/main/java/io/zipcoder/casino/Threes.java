package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Threes {
    int numberOfDice;
    int sumTemp;
    int rollNumber;
    Player whichPlayer;
    Player player1 = new Player();
    Player player2 = new Player();
    int sumPlayer1;
    int sumPlayer2;
    int ante;

    public static void main(String[] args){
        Threes game = new Threes();
        Player whichPlayer = game.choosePlayer();
        //game.roll(whichPlayer);
        game.score(whichPlayer, game.roll(whichPlayer));
        game.compareForWinner(game.getSumPlayer1(), game.getSumPlayer2());
    }


    Dice dice = player1.getDice(5);

    public Threes(){
        rollNumber = 0;
    }

    public int getSumPlayer1(){
        return sumPlayer1;
    }

    public int getSumPlayer2(){
        return sumPlayer2;
    }

    public void setSumTemp(int sumTemp){
        this.sumTemp = sumTemp;
    }

    public Player choosePlayer(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Who wants to start?");
        String pickedPlayer = scan.next();
        whichPlayer = (pickedPlayer.equals(player1)) ? player1 : player2;
        return whichPlayer;
    }

    Threes game = new Threes();


    public int roll(Player whichPlayer){
        ArrayList<Integer> result = dice.toss();
        Iterator<Integer>arrayIterator = result.iterator();

        while(arrayIterator.hasNext()){
            int die = result.get(arrayIterator.next());
            if(3 == die){
                result.set(die, 0);
            }
            sumTemp += die;
            System.out.print("\t" + result.get(arrayIterator.next()));
        }
        return sumTemp;
    }

    public void score(Player whichPlayer, int sumTemp) {
        while (rollNumber <= 1) {
            if (whichPlayer == player1) {
                sumPlayer1 = sumTemp;
                System.out.print("\t Your roll #" + rollNumber + " was " + sumPlayer1);
                setSumTemp(0);
                roll(player2);
                rollNumber++;
            } else {
                sumPlayer2 = sumTemp;
                System.out.print("\t Your roll #" + rollNumber + " was " + sumPlayer2);
                setSumTemp(0);
                roll(player1);
                rollNumber++;
            }
        }
    }

    public Player compareForWinner(int sumPlayer1, int sumPlayer2){
      Player winner = (sumPlayer1 < sumPlayer2) ? player1 : player2;
        System.out.println(winner+ " wins!");
     return winner;
    }


}
