public class PartDiagonal
{
    private int values_array[];
    int size;

    public PartDiagonal(int size)
    {
        values_array = new int[size];
    }

    public int getValueFromIndex(int index)
    {
        if(index >= size || index < 0)
        {
            throw new ArithmeticException("PartDiagonal : getValueFromIndex : index invalide.");
        }
        return values_array[index];
    }

    public void addValue(int value, int index)
    {
        if(index >= size || index < 0)
        {
            throw new ArithmeticException("PartDiagonal : addValue : index invalide");
        }

        values_array[index] = value;
    }
    
    public int[] getDiagonal()
    {
        return this.values_array;
    }

    public void display()
    {
        for (int value : values_array)
        {
            System.out.print(value + " ; ");
        }
        System.out.println();
    }
}
