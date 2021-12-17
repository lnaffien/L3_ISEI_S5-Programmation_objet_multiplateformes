package v2_avec_classes;

public class Value
{
    private int posX;
    private int posY;
    private int value;
    
    public Value(int posX, int posY)
    {
        this.posX = posX;
        this.posY = posY;
        resetValue();
    }

    public void resetValue()
    {
        this.value = 0;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getValue()
    {
        return this.value;
    }

    public void setValue(int value)
    {
        this.value = value;
    }
}
