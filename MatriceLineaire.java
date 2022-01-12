/***********************************************************************************************************************************************

                                                                MatriceLineaire
                                                                            par NAFFIEN Lucie (janvier 2022)

Cette classe appartient a un projet realise pour le module "Programmation objet multiplateformes", enseigne par M. MARIAGE, dans le cadre 
de la 3eme annee de licence parcours Informatique des Systemes Embarques et Interactifs de l'Universite Paris 8.

************************************************************************************************************************************************/

public class MatriceLineaire extends Matrice
{
    /*************************************************
     * 
     *              Constructeurs
     * 
     *************************************************/

    /**
     * Constructeur.
     * @param taille taille de la matrice carree
     */
    public MatriceLineaire(int taille)
    {
        super(taille);
        initMatrice();
    }

    /**
     * Constructeur : creation de la matrice a partir d'une autre.
     * @param m matrice initiale
     */
    public MatriceLineaire(Matrice m)
    {
        super(m);
        initMatrice(m);
    }

    /*************************************************
     * 
     *              Methodes
     * 
     *************************************************/

    /*************************************************
     * Initialisation a partir des donnees entrees
     *************************************************/

    /**
     * Initialisation manuelle de la matrice.
     * Initialisation separee de la diagonale, de la partie inferieure et de la partie superieure.
     */
    @Override
    protected void initMatrice()
    {
        initDiagonale();
        initInf();
        initSup();
    }

    /**
     * Initialisation manuelle de la diagonale.
     */
    private void initDiagonale()
    {
        int i = 0;
        int j = 0;

        System.out.println("Initialisation de la diagonale.");

        while (i < this.hauteur && j < this.largeur)
        {
            System.out.print("[" + i + "][" + j + "] = ");
            matrice[i++][j++] = in.nextInt();
        }
        System.out.println();
        this.afficherMatrice();
    }

    /**
     * Initialisation manuelle de la partie inferieure.
     */
    private void initInf()
    {
        int h_cursor = 1;
        int w_cursor = 0;
        int diagonale = 0;

        System.out.println("Initialisation de la partie inferieure.");

        while(h_cursor < this.hauteur)
        {
            System.out.print("[" + h_cursor + "][" + w_cursor + "] = ");
            this.matrice[h_cursor][w_cursor] = in.nextInt();
            w_cursor ++;
            
            if(w_cursor > diagonale || w_cursor >= this.largeur)
            {
                w_cursor = 0;
                h_cursor ++;
                diagonale ++;
            }
        }
        System.out.println();
        this.afficherMatrice();
    }

    /**
     * Initialisation manuelle de la partie superieure.
     */
    private void initSup()
    {
        int h_cursor = 0;
        int w_cursor = 1;
        int diagonale = 0;

        System.out.println("Initialisation de la partie inferieure.");

        while(h_cursor < this.hauteur && w_cursor < this.largeur)
        {
            System.out.print("[" + h_cursor + "][" + w_cursor + "] = ");
            this.matrice[h_cursor][w_cursor] = in.nextInt();
            w_cursor ++;

            if(w_cursor >= this.largeur)
            {
                diagonale ++;
                w_cursor = diagonale + 1;
                h_cursor ++;
            }
        }
        System.out.println();
        this.afficherMatrice();
    }

    /*************************************************
     * Initialisation a partir d'une autre matrice
     *************************************************/

    /**
     * Initialisation de la matrice a partir d'une autre.
     * Initialisation separee de la diagonale, de la partie inferieure et de la partie superieure.
     * @param m matrice initiale
     */
    @Override
    protected void initMatrice(Matrice m)
    {
        initDiagonale(m);
        initInf(m);
        initSup(m);
    }

    /**
     * Initialisation de la diagonale a partir d'une autre matrice.
     * @param m matrice initiale
     */
    private void initDiagonale(Matrice m)
    {
        int i = 0;
        int j = 0;
        while(i < this.hauteur && j < this.largeur)
        {
            this.matrice[i][j] = m.matrice[i][j];
            i++;
            j++;
        }
    }

    /**
     * Initialisation de la partie inferieure a partir d'une autre matrice.
     * @param m matrice initiale
     */
    private void initInf(Matrice m)
    {
        int h_cursor = 1;
        int w_cursor = 0;
        int diagonale = 0;

        while(h_cursor < this.hauteur)
        {
            this.matrice[h_cursor][w_cursor] = m.matrice[h_cursor][w_cursor];
            w_cursor ++;

            // Mise a jour du curseur lorsqu'il atteint la diagonale ou le bord de la matrice.
            if(w_cursor > diagonale || w_cursor >= this.largeur)
            {
                w_cursor = 0;
                h_cursor ++;
                diagonale ++;
            }
        }
    }

    /**
     * Initialisation de la partie superieure a partir d'une autre matrice.
     * @param m matrice initiale
     */
    private void initSup(Matrice m)
    {
        int h_cursor = 0;
        int w_cursor = 1;
        int diagonale = 0;

        while(h_cursor < this.hauteur && w_cursor < this.largeur)
        {
            this.matrice[h_cursor][w_cursor] = m.matrice[h_cursor][w_cursor];
            w_cursor ++;

            // Mise a jour du curseur lorsqu'il atteint le bord de la matrice.
            if(w_cursor >= this.largeur)
            {
                diagonale ++;
                w_cursor = diagonale + 1;
                h_cursor ++;
            }
        }
    }

    
}