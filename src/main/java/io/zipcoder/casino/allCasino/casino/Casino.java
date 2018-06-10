
package io.zipcoder.casino.allCasino.casino;
import io.zipcoder.casino.allCasino.games.BlackJack;
import  io.zipcoder.casino.allCasino.ioMessages.*;
import  io.zipcoder.casino.allCasino.player.*;
import io.zipcoder.casino.allCasino.ioMessages.PreMadeMessages;
import io.zipcoder.casino.allCasino.games.*;
import io.zipcoder.casino.allCasino.interfaces.*;





public class Casino {

    private boolean inTheCasino = true;
    //private boolean playingGames = false;


    GameConsole console = new GameConsole();
    PreMadeMessages messages = new PreMadeMessages();
    Game game;



    Player player1 = new Player(0, "");

    public void welcome() {
         player1.setName(console.stringScan("Whats Your Name?"));

         player1.setHelloKittyFunBucks(console.getIntegerInput("How Much Money Did You Bring Today?"));

        if(player1.getName().equalsIgnoreCase("froilan")){
            console.println(messages.bringMeTheBat);
            console.println(messages.rollTheDice);
            console.println(messages.froilanWelcome);
        }else {
            console.println(messages.displayTheCat);
            console.println(messages.rollTheDice);
            console.println(messages.welcomeMessage);
        }

        enterCasino();
    }

    public void enterCasino(){

        while(inTheCasino == true){
            if(player1.getName().equalsIgnoreCase("froilan")){
                console.println(messages.gothamMenu);
            } else {
            console.println(messages.mainMenu);}

            switch(console.stringScan("What Would You Like To Do?")){
                case "see credits" :
                    console.println("You Currently Have: " + player1.getHelloKittyFunBucks() + " Hello Kitty Fun Bucks!");
                    break;
                case "add credits" :
                    console.println(messages.atm);
                    player1.addHelloKittyFunBucks(console.getIntegerInput("How Many Credits Would You Like To Add?"));
                    break;
                case "play games" :
                    playGames();
                    break;
                case "exit" : leaveCasino();
                    inTheCasino = false;
                    break;
                default: console.println("You Can't Do That, We Have Rules Here!! Please Choose An Available Option");
                    break;
            }
        }

    }

    public void leaveCasino(){
        if(player1.getName().equalsIgnoreCase("froilan")) {
            console.println(messages.batBye);
            console.println("Not The Gambler That Gotham Needs, The Gambler That Gotham Deserves....");
        }else {

            console.println(messages.byeBye);
        }
    }

    public void playGames() {
        chooseGame();
        if (game instanceof Gamble) {
            int bet = console.getIntegerInput("Place Kitty Bets!");
            player1.addHelloKittyFunBucks(bet*-1);
            ((Gamble) game).placeBet(bet);
        }
        game.playGame();
        if (game instanceof Gamble) {
            boolean playeriswinner = game.getWinner();
            if (playeriswinner) {
                player1.addHelloKittyFunBucks(((Gamble) game).payOut());
                if(player1.getName().equalsIgnoreCase("froilan")) {
                    console.println(messages.batmanWins);
                } else {
                    console.println(messages.makeItRain);}
            }
            else {
                console.println("Booooooooo. You lose.");
            }
        }

    }


    public void chooseGame() {
        switch (console.stringScan("What Game Do You Want To Play? War, BlackJack, Threes, Hi Lo, or Baccarat?")) {
            case "war": game = new War();
                game.playGame();
                ;
                break;
            case "blackjack":
                game = new BlackJack();
                break;
            case "threes":
                game = new Threes();
                break;
            case "hi lo":
                game = new DummyGame();
                break;
            case "baccarat":
                game = new Baccarat();
                break;
            default:
                console.println("Please Choose A Game We Have!");
                break;

        }

    }

}


