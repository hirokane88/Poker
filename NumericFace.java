
/**
 * Write a description of class AbstractDie here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class NumericFace implements Randomizer
{
    
    int currentVal= 0;
    int numberOfSides = 1;
    
    public int getNumFaces() 
    {
        return numberOfSides;
    }

    public void setNumSides(int numFaces)
    {
        numberOfSides = numFaces;
    }
    
    public int getCurrentValue() 
    {
        return currentVal;
    }

    public String getFace(int faceNum) 
    {
        return faceNum + "";
    }

    public String getCurrentFace() 
    {
        return getFace(getCurrentValue());
    }

    public int randomize() 
    {
        currentVal = (int)(Math.random() * numberOfSides + 1);
        return currentVal;
    }
}
