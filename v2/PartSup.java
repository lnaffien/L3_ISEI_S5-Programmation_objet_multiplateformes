public class PartSup
{
    private int values_array[];
    int size;

    public PartSup(int size)
    {
        this.size = size;
        values_array = new int[((size * size) - size) / 2];
    }

    public int getValueFromIndex(int hauteur, int largeur)
    {
        if(hauteur < 0 || hauteur >= size - 1 || largeur <= 0 || largeur >= size)
        {
            throw new ArithmeticException("PartInf : getValueFromIndex : index invalide :"  + hauteur + ", " + largeur);
        }
        return values_array[hauteur * size + largeur - exp(hauteur) - hauteur - 1];
    }

    public void addValue(int value, int hauteur, int largeur)
    {
        if(hauteur < 0 || hauteur >= size - 1 || largeur <= 0 || largeur >= size || hauteur > largeur)
        {
            throw new ArithmeticException("PartInf : addValue : index invalide : " + hauteur + ", " + largeur);
        }

        values_array[hauteur * size + largeur - exp(hauteur) - hauteur - 1] = value;
    }

    private int exp(int hauteur)
    {
        int res = hauteur;
        if(hauteur > 0)
        {
            res += exp(hauteur - 1);
        }
        return res;
    }

    public int[] getPartSup()
    {
        return this.values_array;
    }

    public void display()
    {
        int hauteur = 0;
        int i = 0;
        for (int value : values_array)
        {
            System.out.print(value + " ; ");
            i++;

            if(i + hauteur >= size - 1)
            {
                System.out.println();
                hauteur++;
                i = 0;
            }
        }
    }
}