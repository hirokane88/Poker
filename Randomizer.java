/**
 * Write a description of interface Randomizer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface Randomizer
{
    public int getNumFaces();

    public int getCurrentValue();

    public String getFace(int faceNum);

    public String getCurrentFace();

    public int randomize();
}
