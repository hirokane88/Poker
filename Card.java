
/**
 * Write a description of class Card here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Card
{
    private int value;
    private int suit;

    public Card(int valueFace, int suitFace)
    {
        value = valueFace;
        suit = suitFace;
    }
    
    public Card(String suitQ, int valueQ)
    {
        if (suitQ.equals("\u2660"))
        {
            suit = 1;
        }
        if (suitQ.equals("\u2661"))
        {
            suit = 2;
        }
        if (suitQ.equals("\u2662"))
        {
            suit = 3;
        }
        if (suitQ.equals("\u2663"))
        {
            suit = 4;
        }
        
        value = valueQ;
    }
    
    public int getValue()
    {
        return value;
    }
    
    public int getSuit()
    {
        return suit;
    }
   
    public String getFace()
    {
        String name = "";
        if (value <= 10 && value != 1)
        {

            name += (value + "");
        }
        if (value == 1)
        {
            name += "A";
        }
        if (value == 11)
        {
            name += "J";
        }
        if (value == 12)
        {
            name += "Q";
        }
        if (value == 13)
        {
            name += "K";
        }
        if (suit == 1)
        {
            name += "\u2660";
        }    
        if (suit == 2)
        {
            name += "\u2661";
        }    
        if (suit == 3)
        {
            name += "\u2662";
        }    
        if (suit == 4)
        {
            name += "\u2663";
        } 
        return name;
    }

    public Boolean sameSuit(Card card, Card card1)
    {

        if (card.getSuit() == card1.getSuit())
        {
            return true;
        }

        return false;

    }
    
    public Boolean sameValue(Card card, Card card1)
    {
        if (card.getValue() == card1.getValue())
        {
            return true;
        }

        return false;
        
    }
} 
