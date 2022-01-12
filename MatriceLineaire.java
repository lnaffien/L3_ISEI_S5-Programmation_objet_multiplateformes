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
        int h_curseur = 0;  // Curseur pour la hauteur
        int l_curseur = 0;  // Curseur pour la largeur

        System.out.println("Initialisation de la diagonale.");

        // Tant que les index ne depassent pas la hauteur ou la largeur maximale de la matrice, ajout d'une nouvelle valeur.
        while (h_curseur < this.hauteur && l_curseur < this.largeur)
        {
            System.out.print("[" + h_curseur + "][" + l_curseur + "] = ");
            matrice[h_curseur++][l_curseur++] = in.nextInt();
        }

        // Affichage de ce qui a deja ete initialise. 
        System.out.println();
        this.afficherMatrice();
    }

    /**
     * Initialisation manuelle de la partie inferieure.
     */
    private void initInf()
    {
        int h_curseur = 1;  // Curseur pour la hauteur
        int l_curseur = 0;  // Curseur pour la largeur
        int diagonale = 0;  // Curseur pour la diagonale

        System.out.println("Initialisation de la partie inferieure.");

        // Tant que l'index actuel ne depasse pas la hauteur maximale de la matrice, ajout d'une nouvelle valeur.
        while(h_curseur < this.hauteur)
        {
            System.out.print("[" + h_curseur + "][" + l_curseur + "] = ");
            this.matrice[h_curseur][l_curseur] = in.nextInt();

            l_curseur ++;
            
            // Mise a jour des curseurs s'ils atteignent la diagonale ou la largeur maximale de la matrice.
            if(l_curseur > diagonale || l_curseur >= this.largeur)
            {
                l_curseur = 0;
                h_curseur ++;
                diagonale ++;
            }
        }

        // Affichage de ce qui a deja ete initialise. 
        System.out.println();
        this.afficherMatrice();
    }

    /**
     * Initialisation manuelle de la partie superieure.
     */
    private void initSup()
    {
        int h_curseur = 0;  // Curseur pour la hauteur
        int l_curseur = 1;  // Curseur pour la largeur
        int diagonale = 0;  // Curseur pour la diagonale

        System.out.println("Initialisation de la partie inferieure.");

        // Tant que l'index actuel ne depasse pas la hauteur ou la largeur maximale de la matrice, ajout d'une nouvelle valeur.
        while(h_curseur < this.hauteur && l_curseur < this.largeur)
        {
            System.out.print("[" + h_curseur + "][" + l_curseur + "] = ");
            this.matrice[h_curseur][l_curseur] = in.nextInt();

            l_curseur ++;

            // Mise a jour des curseurs s'ils atteignent la largeur maximale de la matrice.
            if(l_curseur >= this.largeur)
            {
                diagonale ++;
                l_curseur = diagonale + 1;
                h_curseur ++;
            }
        }

        // Affichage de ce qui a deja ete initialise. 
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
        int h_curseur = 0;  // Curseur pour la hauteur
        int l_curseur = 0;  // Curseur pour la largeur

        // Tant que les index ne depassent pas la hauteur ou la largeur maximale de la matrice, ajout d'une nouvelle valeur.
        while(h_curseur < this.hauteur && l_curseur < this.largeur)
        {
            this.matrice[h_curseur][l_curseur] = m.matrice[h_curseur][l_curseur];
            h_curseur++;
            l_curseur++;
        }
    }

    /**
     * Initialisation de la partie inferieure a partir d'une autre matrice.
     * @param m matrice initiale
     */
    private void initInf(Matrice m)
    {
        int h_curseur = 1;  // Curseur pour la hauteur
        int l_curseur = 0;  // Curseur pour la largeur
        int diagonale = 0;  // Curseur pour la diagonale

        // Tant que l'index actuel ne depasse pas la hauteur maximale de la matrice, ajout d'une nouvelle valeur.
        while(h_curseur < this.hauteur)
        {
            this.matrice[h_curseur][l_curseur] = m.matrice[h_curseur][l_curseur];
            l_curseur ++;

            // Mise a jour des curseurs s'ils atteignent la diagonale ou la largeur maximale de la matrice.
            if(l_curseur > diagonale || l_curseur >= this.largeur)
            {
                l_curseur = 0;
                h_curseur ++;
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
        int h_curseur = 0;  // Curseur pour la hauteur
        int l_curseur = 1;  // Curseur pour la largeur
        int diagonale = 0;  // Curseur pour la diagonale

        // Tant que l'index actuel ne depasse pas la hauteur ou la largeur maximale de la matrice, ajout d'une nouvelle valeur.
        while(h_curseur < this.hauteur && l_curseur < this.largeur)
        {
            this.matrice[h_curseur][l_curseur] = m.matrice[h_curseur][l_curseur];
            l_curseur ++;

            // Mise a jour des curseurs s'ils atteignent la largeur maximale de la matrice.
            if(l_curseur >= this.largeur)
            {
                diagonale ++;
                l_curseur = diagonale + 1;
                h_curseur ++;
            }
        }
    }

    
}