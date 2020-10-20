/**
 * Write a description of class PokerHand here.
 *
 * @author (Hirotaka Kumagami)
 * @version (a version number or a date)
 */
import java.util.*;
public class PokerHand extends NumericFace
{
    List<Card> pokerHand = new ArrayList<Card>();
    private Card card1;
    private Card card2;
    private Card card3;
    private Card card4;
    private Card card5;
    public PokerHand(Card c1, Card c2, Card c3, Card c4, Card c5)
    {
        card1 = c1;
        card2 = c2;
        card3 = c3;
        card4 = c4;
        card5 = c5;
        pokerHand.add(c1);
        pokerHand.add(c2);
        pokerHand.add(c3);
        pokerHand.add(c4);
        pokerHand.add(c5);
        selectionSort();
    }
    public static String yourName()
    {
        return "Hiro, Kumagami";
    } 
    public String toString()
    {
        String name = "";
        for (int count = 0; count < 5; count++)
        {
            name += pokerHand.get(count).getFace() + " ";
        }
        return name;
    }   
    public void selectionSort()
    {
        for (int count = 0; count <= 4; count++)
        {
            int best = pokerHand.get(count).getValue();
            Card num = pokerHand.get(count);
            int okay = count;
            for (int i = count; i <= 4; i++)
            {
                if (pokerHand.get(i).getValue() < best)
                {
                    best = pokerHand.get(i).getValue();
                    num = pokerHand.get(i);
                    okay = i;
                }
            }

            Collections.swap(pokerHand, count, okay);
        }

    }

    public void insertionSort()
    {
        for (int count = 1; count < 5; count++)
        {
            int key = pokerHand.get(count).getValue();
            Card keyCard = pokerHand.get(count);
            for (int i = 0; i <= 4; i++)
            {
                if (key < pokerHand.get(i).getValue())
                {
                    pokerHand.set(i, keyCard);
                }
            }
        }
    }

    public Boolean isFlush()
    {
        int total = 0;
        for (int count = 1; count < 5; count++)
        {
            if (pokerHand.get(count-1).getSuit() == pokerHand.get(count).getSuit())
            {
                total++;
            }
        }
        if (total == 4)
        {
            return true;
        }
        return false;
    }

    public Boolean isPair()
    {
        int total = 0;
        for (int count = 1; count < 5; count++)
        {
            if (pokerHand.get(count-1).getValue() == pokerHand.get(count).getValue())
            {
                total++;
            }
        }
        if (total == 1)
        {
            return true;
        }
        return false;
    }

    public Boolean isTwoPair()
    {

        int total = 0;

        int total1 = 0;

        int num = 0;

        for (int count = 1; count < 3; count++)
        {
            if (pokerHand.get(count-1).getValue() == pokerHand.get(count).getValue())
            {
                total++;
                num = pokerHand.get(count-1).getValue();

            }

        }
        for (int count = 1; count < 5; count++)
        {
            if (pokerHand.get(count-1).getValue() == pokerHand.get(count).getValue() && num != pokerHand.get(count-1).getValue())

            {

                total1++;

            }
        }

        if (total == 1 && total1 == 1)
        {
            return true;
        }
        return false;

    }

    public Boolean isThreeOfAKind()
    {
        int total = 0;
        int total1 = 0;

        int num = 0;
        int num1 = 0;
        for (int count = 1; count < 5; count++)
        {
            if (pokerHand.get(count-1).getValue() == pokerHand.get(count).getValue())
            {
                total++;
                if (num1 == 0)
                {
                    num = pokerHand.get(count-1).getValue();
                    num1++;
                }

            }
        }
        for (int count = 1; count < 5; count++)
        {
            if (pokerHand.get(count-1).getValue() == pokerHand.get(count).getValue() && num == pokerHand.get(count-1).getValue())
            {
                total1++;

            }
        }

        if (total == 2 && total1 == 2)
        {
            return true;
        }
        return false;
    }

    public Boolean isFourOfAKind()
    {
        int total = 0;
        int total1 = 0;

        int num = 0;
        int num1 = 0;
        for (int count = 1; count < 5; count++)
        {
            if (pokerHand.get(count-1).getValue() == pokerHand.get(count).getValue())
            {
                total++;
                if (num1 == 0)
                {
                    num = pokerHand.get(count-1).getValue();
                    num1++;
                }

            }
        }
        for (int count = 1; count < 5; count++)
        {
            if (pokerHand.get(count-1).getValue() == pokerHand.get(count).getValue() && num == pokerHand.get(count-1).getValue())
            {
                total1++;

            }
        }

        if (total == 3 && total1 == 3)
        {
            return true;
        }
        return false;
    }

    public Boolean isFullHouse()
    {
        int total = 0;
        int total1 = 0;

        int num = 0;
        int num1 = 0;
        for (int count = 1; count < 5; count++)
        {
            if (pokerHand.get(count-1).getValue() == pokerHand.get(count).getValue())
            {
                total++;
                if (num1 == 0)
                {
                    num = pokerHand.get(count-1).getValue();
                    num1++;
                }

            }
        }
        for (int count = 1; count < 5; count++)
        {
            if (pokerHand.get(count-1).getValue() == pokerHand.get(count).getValue() && num != pokerHand.get(count-1).getValue())
            {
                total1++;

            }
        }

        if ((total == 2 && total1 == 3) || (total == 3 && total1 == 2))
        {
            return true;
        }
        return false;
    }

    public Boolean isStraight()
    {
        int total = 0;
        for (int count = 1; count < 5; count++)
        {
            int x = pokerHand.get(count-1).getValue();
            int y = pokerHand.get(count).getValue();
            if (y - x == 1 )
            {
                total++;
            }
            if (x == 1 && y - x == 9)
            {
                total++;
            }
            
        }
        if (total == 4)
        {
            return true;
        }
        return false;

    }

    public Boolean isStraightFlush()
    {
        if (isStraight() && isFlush())
        {
            return true;
        }
        return false;
    }
}
