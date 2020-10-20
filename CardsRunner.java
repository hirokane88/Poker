import java.util.*;
/**
 * Test of PlayingCards
 *
 * @author (your name)
 */
public class CardsRunner
{
    public static void main()
    {
        PlayingCards cards = new PlayingCards();
        String randomCard = cards.getCurrentFace();
        System.out.println("The initial face is " + randomCard);
        System.out.print("This cards have the faces: \n");
        for (int i = 1; i <= cards.getNumFaces(); i++)
        {
            System.out.print(cards.getFace(i) + " ");
            if (i % 13 == 0) System.out.println();
        }
        System.out.println("");
        System.out.println("I will choose 5 random cards:");
        for (int n = 1; n <= 5; n++)
        {
            cards.randomize();
            System.out.println("Card #" + n + " : " + cards.getCurrentFace());
        }
        System.out.println("\nShuffled deck :");
        for(int i = 1; i <= 52; i++)
        {
            Card card = cards.dealCard();
            System.out.print(card.getFace() + " ");
            if (i % 13 == 0) 
            {
                System.out.println();
            }
        }
        cards.shuffle();
        System.out.println("\nShuffled again (different than last time?):");
        for(int i = 1; i <= 52; i++)
        {
            Card card = cards.dealCard();
            System.out.print(card.getFace() + " ");
            if (i % 13 == 0) System.out.println();
        }

        PokerHand ph = null;
        boolean gotFlush = false;
        int count = 0;

        while(!gotFlush) 
        {       
            cards.shuffle();
            count++;
            ph = new PokerHand(cards.dealCard(), 
                cards.dealCard(), cards.dealCard(),
                cards.dealCard(), cards.dealCard());
            System.out.println(ph);
            if(ph.isFlush())
            {
                gotFlush = true;
            }
        }
        System.out.println("\nYour Flush after " + count + " tries :");
        System.out.print(ph);
        checkHand("flush", cards);
        checkHand("pair", cards);
        checkHand("two pair", cards);
        checkHand("three of a kind", cards);
        checkHand("four of a kind", cards);
        checkHand("straight", cards);
        checkHand("full house", cards);
        checkHand("straight flush", cards);


    }     

    /**
     * Given a String representing a hand name, repeatedly deal out
     * poker hands until the specified hand comes up.  Print out how
     * many hands it took to get the desired hand.
     *
     * @param hand is a String representing which hand we are looking for.
     *   Options are : "flush", "pair", "two pair", 
     *                   "three of a kind", "four of a kind", 
     *                  "straight", "full house", "straight flush"
     * @param cards : the deck of cards object to deal
     */
    public static void checkHand(String hand, PlayingCards cards)
    {
        PokerHand ph = null;
        boolean gotHand = false;
        int count = 0;

        while(!gotHand) 
        {       
            cards.shuffle();
            count++;
            ph = new PokerHand(cards.dealCard(), cards.dealCard(), 
                cards.dealCard(),
                cards.dealCard(), cards.dealCard());

            if(hand.equals("flush") && ph.isFlush()) gotHand = true;
            else if(hand.equals("pair") && ph.isPair()) gotHand = true;
            else if(hand.equals("two pair") && ph.isTwoPair()) gotHand = true;
            else if(hand.equals("three of a kind") && 
            ph.isThreeOfAKind()) gotHand = true;
            else if(hand.equals("four of a kind") && 
            ph.isFourOfAKind()) gotHand = true;
            else if(hand.equals("straight") && ph.isStraight()) gotHand = true;
            else if(hand.equals("full house") && 
            ph.isFullHouse()) gotHand = true;
            else if(hand.equals("straight flush") && 
            ph.isStraightFlush()) gotHand = true; 

        }
        System.out.println("\nYour " + hand + " after " + count + " tries :");
        System.out.println(ph);

        System.out.println("Your hand + " + ph); 
    } 
}
