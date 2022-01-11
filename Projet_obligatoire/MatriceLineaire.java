public class MatriceLineaire implements Matrice
{
    int hauteur;
    int largeur;
    int matrice[][];
    static int nbr = 0;

    public MatriceLineaire(int taille)
    {
        this.hauteur = taille;
        this.largeur = taille;
        matrice = new int[this.hauteur][this.largeur];
        initDiagonale();
        initInf();
        initSup();
    }

    public void afficherMatrice()
    {
        System.out.println("Matrice lineaire :");
        for(int i = 0; i < this.hauteur; i++)
        {
            for(int j = 0; j < this.largeur; j++)
            {
                System.out.print(this.matrice[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void initDiagonale()
    {
        int i = 0;
        int j = 0;
        while (i < this.hauteur && j < this.largeur)
        {
            matrice[i++][j++] = nbr++;
        }
    }

    public void initInf()
    {
        int h_cursor = 1;
        int w_cursor = 0;
        int diagonale = 0;

        while(h_cursor < this.hauteur)
        {
            this.matrice[h_cursor][w_cursor] = nbr;
            nbr ++;
            w_cursor ++;
            
            if(w_cursor > diagonale || w_cursor >= this.largeur)
            {
                w_cursor = 0;
                h_cursor ++;
                diagonale ++;
            }
        }
    }

    public void initSup()
    {
        int h_cursor = 0;
        int w_cursor = 1;
        int diagonale = 0;

        while(h_cursor < this.hauteur && w_cursor < this.largeur)
        {
            this.matrice[h_cursor][w_cursor] = nbr;
            nbr ++;
            w_cursor ++;

            if(w_cursor >= this.largeur)
            {
                diagonale ++;
                w_cursor = diagonale + 1;
                h_cursor ++;
            }
        }
    }
}