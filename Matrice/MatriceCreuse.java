/***********************************************************************************************************************************************

                                                                MatriceCreuse
                                                                            par NAFFIEN Lucie (janvier 2022)

Cette classe appartient a un projet realise pour le module "Programmation objet multiplateformes", enseigne par M. MARIAGE, dans le cadre 
de la 3eme annee de licence parcours Informatique des Systemes Embarques et Interactifs de l'Universite Paris 8.

Lien github de l'ensemble du projet : https://github.com/lnaffien/L3_ISEI_S5-Programmation_objet_multiplateformes

************************************************************************************************************************************************/

package Matrice;

import PartMatriceCreuse.PartManagerCreuse;

public class MatriceCreuse extends Matrice
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
    public MatriceCreuse(int taille)
    {
        super(taille);
        this.partManager = new PartManagerCreuse(taille);
        initMatrice();
    }

    /**
     * Constructeur : creation de la matrice a partir d'une autre.
     * @param m matrice initiale
     */
    public MatriceCreuse(Matrice m)
    {
        super(m);
        
        if(m.partManager.getClass() == PartManagerCreuse.class)
        {
            this.partManager = m.partManager;
        }
        else
        {
            this.partManager = new PartManagerCreuse(taille);
            initMatrice(m);
        }        
    }

    /*************************************************
     * 
     *              Methodes
     * 
     *************************************************/

    /**
     * Initialisation manuelle de la matrice.
     */
    protected void initMatrice()
    {
        System.out.println("Veuillez indiquer les cases non nulles de la matrice sous la forme suivante : x(hauteur) y(largeur) valeur");
        System.out.println("Attention : une case deja enregistree sera reecrite.");
        System.out.println("Exemple :\n0 0 5");

        int fin = 1;
        while(fin != 0)
        {
            // Ajout d'une nouvelle valeur en fonction de l'entree renseignee.
            System.out.println("Nouvelle valeur : ");
            modifierValeur(in.nextInt(), in.nextInt(), in.nextInt());

            // Verification que l'utilisateur veuille continuer ou non.
            System.out.println("Continuer ?");
            System.out.println("0 : non");
            System.out.println("1 : oui");
            fin = in.nextInt();
        }

        System.out.println("Fin de l'entree des donnees.\n");

        // Fermeture du Scanner afin d'eviter des fuites de memoire.
        in.close();
    }
    
}