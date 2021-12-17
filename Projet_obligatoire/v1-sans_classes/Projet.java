public class Projet
{
    static int nbr = 0;
    public static void main(String arg[])
    {
        //int size = 3;
        int height = 4;
        int width = 4;

        //int[][] matrix = new int [size][size];
        int[][] matrix = new int [height][width];
        
        System.out.println("Initialisation de la diagonale : ");
        /*initDiagonal(matrix, size);
        displayMatrix(matrix, size);*/
        initDiagonal(matrix, height, width);
        displayMatrix(matrix, height, width);

        System.out.println("Initialisation de la partie inferieure : ");
        /*initInf(matrix, size);
        displayMatrix(matrix, size);*/
        initInf(matrix, height, width);
        displayMatrix(matrix, height, width);

        System.out.println("Initialisation de la partie superieure : ");
        /*initSup(matrix, size);
        displayMatrix(matrix, size);*/
        initSup(matrix, height, width);
        displayMatrix(matrix, height, width);

    }

    /*public static void initDiagonal(int [][] matrix, int size)
    {
        for(int i = 0; i < size; i++)
        {
            matrix[i][i] = nbr;
            nbr ++;
        }
    }*/

    public static void initDiagonal(int [][] matrix, int height, int width)
    {
        int i = 0;
        int j = 0;
        while (i < height && j < width)
        {
            matrix[i++][j++] = nbr++;
        }
    }

    /*public static void initInf(int [][] matrix, int size)
    {
        int x = 1, y = 0;
        while(x < size - 1 && y < size)
        {
            if(x >= size - (size - y))
            {
                x = 0;
                y ++;
            }
            matrix[y][x] = nbr;
            nbr++;
            x++;
        }
    }*/

    public static void initInf(int [][] matrix, int height, int width)
    {
        int h_cursor = 1;
        int w_cursor = 0;
        int diagonale = 0;

        while(h_cursor < height)
        {
            matrix[h_cursor][w_cursor] = nbr;
            nbr ++;
            w_cursor ++;
            
            if(w_cursor > diagonale || w_cursor >= width)
            {
                w_cursor = 0;
                h_cursor ++;
                diagonale ++;
            }
        }
    }

    /*public static void initSup(int [][] matrix, int size)
    {
        int x = 1, y = 0;
        while(x < size - 1 && y < size)
        {
            if(x >= size - (size - y))
            {
                x = 0;
                y ++;
            }
            matrix[x][y] = nbr;
            nbr++;
            x++;
        }
    }*/

    public static void initSup(int [][] matrix, int height, int width)
    {
        int h_cursor = 0;
        int w_cursor = 1;
        int diagonale = 0;

        while(h_cursor < height && w_cursor < width)
        {
            matrix[h_cursor][w_cursor] = nbr;
            nbr ++;
            w_cursor ++;

            if(w_cursor >= width)
            {
                diagonale ++;
                w_cursor = diagonale + 1;
                h_cursor ++;
            }
        }
    }

    /*public static void displayMatrix(int [][] matrix, int size)
    {
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
            {
                System.out.print(matrix[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println();
    }*/

    public static void displayMatrix(int [][] matrix, int height, int width)
    {
        for(int i = 0; i < height; i++)
        {
            for(int j = 0; j < width; j++)
            {
                System.out.print(matrix[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println();
    }
}