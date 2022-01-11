public class MatriceCreuse implements Matrice
{
    int hauteur;
    int largeur;
    int matrice[][];
    //static int nbr = 0;

    /*public MatriceCreuse(int taille)
    {
        this.hauteur = taille;
        this.largeur = taille;
        matrice = new int[this.hauteur][this.largeur];
    }*/

    public MatriceCreuse(MatriceLineaire ml)
    {
        if(ml == null)
        {
            throw new ArithmeticException("Cette matrice lineaire n'existe pas.");
        }
        this.hauteur = ml.hauteur;
        this.largeur = ml.largeur;
        matrice = new int[this.hauteur][this.largeur];
        initDiagonale(ml);
        initInf(ml);
        initSup(ml);
    }

    public void afficherMatrice()
    {
        System.out.println("Matrice creuse :");
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

    }

    public void initInf()
    {

    }

    public void initSup()
    {
        
    }
    
    public void initDiagonale(MatriceLineaire ml)
    {
        int i = 0;
        int j = 0;
        while(i < this.hauteur && j < this.largeur)
        {
            if(ml.matrice[i][j] != 0)
            {
                this.matrice[i][j] = ml.matrice[i][j];
            }
            i++;
            j++;
        }
    }

    public void initInf(MatriceLineaire ml)
    {
        int h_cursor = 1;
        int w_cursor = 0;
        int diagonale = 0;

        while(h_cursor < this.hauteur)
        {
            if(ml.matrice[h_cursor][w_cursor] != 0)
            {
                this.matrice[h_cursor][w_cursor] = ml.matrice[h_cursor][w_cursor];
            }
            w_cursor ++;

            if(w_cursor > diagonale || w_cursor >= this.largeur)
            {
                w_cursor = 0;
                h_cursor ++;
                diagonale ++;
            }
        }
    }

    public void initSup(MatriceLineaire ml)
    {
        int h_cursor = 0;
        int w_cursor = 1;
        int diagonale = 0;

        while(h_cursor < this.hauteur && w_cursor < this.largeur)
        {
            if(ml.matrice[h_cursor][w_cursor] != 0)
            {
                this.matrice[h_cursor][w_cursor] = ml.matrice[h_cursor][w_cursor];
            }
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