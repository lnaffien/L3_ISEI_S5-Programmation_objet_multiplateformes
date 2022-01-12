/***********************************************************************************************************************************************

                                                                MatriceLineaire
                                                                            par NAFFIEN Lucie (janvier 2022)

Cette classe appartient a un projet realise pour le module "Programmation objet multiplateformes", enseigne par M. MARIAGE, dans le cadre 
de la 3eme annee de licence parcours Informatique des Systemes Embarques et Interactifs de l'Universite Paris 8.

Lien github de l'ensemble du projet : https://github.com/lnaffien/L3_ISEI_S5-Programmation_objet_multiplateformes


************************************************************************************************************************************************/

public class MatriceLineaire extends Matrice
{
    /*************************************************
     * 
     *              Constructeurs
     * 
     *************************************************/

    public MatriceLineaire(int taille)
    {
        super(taille);
        initMatrice();
    }

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

    @Override
    public void initMatrice()
    {
        initDiagonale();
        initInf();
        initSup();
    }

    public void initDiagonale()
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

    public void initInf()
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

    public void initSup()
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

    @Override
    protected void initMatrice(Matrice m)
    {
        initDiagonale(m);
        initInf(m);
        initSup(m);
    }

    public void initDiagonale(Matrice m)
    {
        int i = 0;
        int j = 0;
        while(i < this.hauteur && j < this.largeur)
        {
            if(m.matrice[i][j] != 0)
            {
                this.matrice[i][j] = m.matrice[i][j];
            }
            i++;
            j++;
        }
    }

    public void initInf(Matrice m)
    {
        int h_cursor = 1;
        int w_cursor = 0;
        int diagonale = 0;

        while(h_cursor < this.hauteur)
        {
            if(m.matrice[h_cursor][w_cursor] != 0)
            {
                this.matrice[h_cursor][w_cursor] = m.matrice[h_cursor][w_cursor];
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

    public void initSup(Matrice m)
    {
        int h_cursor = 0;
        int w_cursor = 1;
        int diagonale = 0;

        while(h_cursor < this.hauteur && w_cursor < this.largeur)
        {
            if(m.matrice[h_cursor][w_cursor] != 0)
            {
                this.matrice[h_cursor][w_cursor] = m.matrice[h_cursor][w_cursor];
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