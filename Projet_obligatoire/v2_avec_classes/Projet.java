package v2_avec_classes;

public class Projet
{
    static int nbr = 0;
    public static void main(String arg[])
    {
        int taille = 4;
        int[][] matrice = new int [taille][taille];
        
        System.out.println("Initialisation de la diagonale : ");
        initDiagonal(matrice, taille);
        displayMatrice(matrice, taille);

        System.out.println("Initialisation de la partie inferieure : ");
        initInf(matrice, taille);
        displayMatrice(matrice, taille);

        System.out.println("Initialisation de la partie superieure : ");
        initSup(matrice, taille);
        displayMatrice(matrice, taille);

    }

    public static void initDiagonal(int [][] matrice, int taille)
    {
        for(int i = 0; i < taille; i++)
        {
            matrice[i][i] = nbr;
            nbr ++;
        }
    }

    public static void initInf(int [][] matrice, int taille)
    {
        int x = 1, y = 0;
        while(x < taille - 1 && y < taille)
        {
            if(x >= taille - (taille - y))
            {
                x = 0;
                y ++;
            }
            matrice[y][x] = nbr;
            nbr++;
            x++;
        }
    }

    public static void initSup(int [][] matrice, int taille)
    {
        int x = 1, y = 0;
        while(x < taille - 1 && y < taille)
        {
            if(x >= taille - (taille - y))
            {
                x = 0;
                y ++;
            }
            matrice[x][y] = nbr;
            nbr++;
            x++;
        }
    }

    public static void displayMatrice(int [][] matrice, int taille)
    {
        for(int i = 0; i < taille; i++)
        {
            for(int j = 0; j < taille; j++)
            {
                System.out.print(matrice[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println();
    }
}