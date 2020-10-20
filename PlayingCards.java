
/**
 * Write a description of class PlayingCards here.
 *
 * @author (Hirotaka Kumagami)
 * @version (a version number or a date)
 */
import java.util.*;
public class PlayingCards extends NumericFace
{
    List<Card> deck = new ArrayList<Card>();
    public PlayingCards()
    {
        setNumSides(52);
        for (int suit = 1; suit < 5; suit++)
        {
            for (int value= 1; value< 14; value++)
            {
                Card indCard = new Card(value,suit);
                deck.add(indCard);
            }
        }
        randomize();
    }

    public String getFace(int faceNum)
    {
        Card card = deck.get(faceNum-1);
        return card.getFace();
    }

    public Card dealCard()
    {
        randomize();
        Card card = deck.remove(getCurrentValue()-1);
        setNumSides(deck.size());
        return card;
    }

    public void shuffle()
    {
        deck = new ArrayList<Card>();
        setNumSides(52);
        for (int suit = 1; suit < 5; suit++)
        {
            for (int value= 1; value< 14; value++)
            {
                Card indCard = new Card(value,suit);
                deck.add(indCard);
            }
        }
        randomize();
    }
}
