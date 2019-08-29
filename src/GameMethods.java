import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.Scanner;

public class GameMethods {
    public GameMethods() {
    }

    Deck deckClass = new Deck();
    Card[] deck = deckClass.Array();
    Scanner scanner = new Scanner(System.in);

    public Card Random(Card[] deck){
        double randomDouble = Math.random();
        randomDouble = randomDouble * deck.length;
        int randomInt = (int) randomDouble;
//        System.out.println(deck[randomInt]);
        return deck[randomInt];
    }

    public ArrayList start() {
        ArrayList<Card> Deckstart = new ArrayList();
        hit(Deckstart);
        hit(Deckstart);
        return Deckstart;
    }

    public ArrayList hit(ArrayList<Card> playerdeck) {
        boolean isItemDrawn = false;
        while(!isItemDrawn) {
            playerdeck.add(Random(deck));
            Card item = playerdeck.get(playerdeck.size()-1);
            if(item.isDrawn()) {
                playerdeck.remove(item);
            } else {
                item.setDrawn(true);
                isItemDrawn = true;
            }
        }


        return playerdeck;
    }

    public ArrayList hitNoCheck(ArrayList<Card> playerdeck) {
        playerdeck.add(Random(deck));
        return playerdeck;
    }

    public int total(ArrayList<Card> playerDeck) {
        Integer sum = 0;
        for (Card item : playerDeck) {
            sum += IntStream.of(item.value).sum();
            if ((item.getValue() == 11) && (sum > 21)) {
                System.out.println(IntStream.of(item.value).sum());
                item.setValue(1);
                System.out.println("value changed to 1");
            }
        }
        return sum;
    }

    public ArrayList startDealer() {
        ArrayList<Card> dealersDeck = new ArrayList();
        while(total(dealersDeck) <= 16) {
            hit(dealersDeck);
        }
        return dealersDeck;
    }

    public boolean gameOver(ArrayList<Card> deck) {
        boolean gameOver = false;
        Integer sum = total(deck);
        if(sum >= 22) {
            gameOver = true;
        }

        return gameOver;
    }

    public boolean gameLoop(ArrayList<Card> player, ArrayList<Card> dealer) {
        boolean start = true;
        System.out.println("Welcome to blackjack, these are your starting cards:");
        System.out.println(Arrays.toString(player.toArray()));
        System.out.println("Total value of: " + total(player));
        do {
            if(total(player) == 21) {
                System.out.println("BlackJack!!!!");
                System.exit(0);
            }
            System.out.println("Hit or stay? 1 to hit 0 to quit");
            String input = scanner.nextLine();
            if(input.equals("1")) {
                hit(player);
                Card lastItem = player.get(player.size() - 1);
                System.out.println("You drew " + lastItem);
                gameOver(player);
            } else if(total(player) == 21) {
                System.out.println("BlackJack!!!!");
                System.exit(0);
            } else {
                start = false;
            }
            System.out.println(Arrays.toString(player.toArray()));
            System.out.println(total(player));
            if(gameOver(player)) {
                start = false;
            }
        }while(start);

        return start;
    }

    public boolean playerIsWinner(ArrayList<Card> player, ArrayList<Card> dealer) {
        boolean bustDealer = false;
        boolean bustPlayer = false;

        if(total(dealer) > 21) {
            bustDealer = true;
        }
        if(total(player) > 21) {
            bustPlayer = true;
        }
        if(total(player) > total(dealer) && !bustPlayer) {
            System.out.println("Player wins");
            System.out.println("Your total: " + total(player));
            System.out.println("Dealer total: " + total(dealer));
            return true;
        } else if((total(player) == total(dealer) && (total(player) <= 21))) {
            System.out.println("It's a draw!");
            System.out.println("Your total: " + total(player));
            System.out.println("Dealer total: " + total(dealer));
        } else if (bustDealer && !bustPlayer) {
            System.out.println("Player wins");
            System.out.println("Your total: " + total(player));
            System.out.println("Dealer total: " + total(dealer));
        } else {
            System.out.println("Dealer wins");
            System.out.println("Your total: " + total(player));
            System.out.println("Dealer total: " + total(dealer));
        }
        return false;
    }

}
