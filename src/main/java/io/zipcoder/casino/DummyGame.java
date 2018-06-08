package io.zipcoder.casino;
import java.util.Random;


public class DummyGame implements Game{
    protected Player player1;
    protected Player player2;
    private int p1Score;
    private int p2score;
    private Player winner;



    public DummyGame(){
    this.player1 = new Player(0, "You");
    this.player2 = new Player(0,"House");


    }


    public void runGame(){
    playGame();
    determineWinner();
    }



    public int rand(){
        Random r = new Random();
        return r.nextInt(10)+1;
    }


    public void playGame() {

        p1Score = rand();
        p2score = rand();


    }

    public Player determineWinner(){
        if(p1Score > p2score){
            System.out.println("player 1 score is: " + p1Score);
            System.out.println("player 2 score is: " + p2score);
            setWinner(player1);
            return getWinner();

        }

        else{
            System.out.println(p1Score);
            System.out.println(p2score);
            setWinner(player2);
            return getWinner();
        }






    }
    public void setWinner(Player winner){
        this.winner = winner;


    }
    public Player getWinner(){
        System.out.println(winner.getName() + " Wins!");
        return winner;



    }








}