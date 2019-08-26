import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GameMethods game = new GameMethods();
        ArrayList dealersDeck = game.startDealer();
        ArrayList<Card> playerDeck = game.start();
        game.gameLoop(playerDeck,dealersDeck);
        game.playerIsWinner(playerDeck,dealersDeck);
//       ArrayList test = game.hitTest();
//        System.out.println(Arrays.toString(test.toArray()));
    }
    }