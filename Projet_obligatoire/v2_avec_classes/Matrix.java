package v2_avec_classes;

import java.util.ArrayList;

public class Matrix
{
    private Matrix singleton;
    private int size;

    private Matrix(int size)
    {
        this.size = size;

    }

    public Matrix getMatrix(int size)
    {
        if(singleton == null)
        {
            new Matrix(size);
            singleton = this;
        }
        return singleton;
    }

    public void initValues()
    {
        int posX = 0;
        int posY = 0;

        while (posX < size && posY < size)
        {
            new Value(posX, posY);
            posX ++;

            if(posX >= size)
            {
                posX = 0;
                posY++;
            }
        }

    }
    
}
