import org.junit.*;

import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

public class BlackjackTests {
    GameMethods game = new GameMethods();
    Deck deckClass = new Deck();
    Card[] deck = deckClass.Array();
    ArrayList<Card> playerDeck = new ArrayList<>();
    ArrayList<Card> dealerDeck = new ArrayList<>();

    @Test
    public void hitTest() {
        ArrayList first = new ArrayList();
        HashSet set = new HashSet();
        boolean match = false;
//        set.add(new Card("Ace of spades", 11, false));
        for (int i = 0; i < deck.length ; i++) {
            game.hit(first);
        }
        for (Object item:first) {
            if (!set.add(item)) {
                match = true;
            }
        }
        System.out.println(set);
        Assert.assertEquals(false,match);
    }
    @Test
    public void hitWithoutCheckingDrawTest() {
        ArrayList first = new ArrayList();
        HashSet set = new HashSet();
        boolean match = false;
//        set.add(new Card("Ace of spades", 11, false));
        for (int i = 0; i < deck.length ; i++) {
            game.hitNoCheck(first);
        }
        for (Object item:first) {
            if (!set.add(item)) {
                System.out.println("We got a match");
                match = true;
            }
        }
        System.out.println(set);
        Assert.assertEquals(true,match);
    }
    @Test
    public void playerBust() {
        playerDeck.add(new Card("test",22,false));
        game.playerIsWinner(playerDeck,dealerDeck);
        Assert.assertEquals(false,game.playerIsWinner(playerDeck,dealerDeck));
    }
    @Test
    public void playerBlackjack() {
        playerDeck.add(new Card("Ace",11,false));
        playerDeck.add(new Card("ten",3,false));
        if(game.total(playerDeck) == 21) {
            System.out.println("BlackJack!!!!");
            System.exit(0);
        }
        dealerDeck.add(new Card("test2",21,false));

        game.playerIsWinner(playerDeck,dealerDeck);
        Assert.assertEquals(true,game.playerIsWinner(playerDeck,dealerDeck));
    }
    @Test
    public void dealerBust() {
        playerDeck.add(new Card("Ace",11,false));
        dealerDeck.add(new Card("test",22,false));
        game.playerIsWinner(playerDeck,dealerDeck);
        Assert.assertEquals(false,game.playerIsWinner(playerDeck,dealerDeck));
    }
    @Test
    public void bothBust() {
        playerDeck.add(new Card("test1",22,false));
        dealerDeck.add(new Card("test2",22,false));
        game.playerIsWinner(playerDeck,dealerDeck);
        Assert.assertEquals(false,game.playerIsWinner(playerDeck,dealerDeck));
    }


}
