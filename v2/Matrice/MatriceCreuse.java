package Matrice;

import PartManager.PartMatriceCreuse.PartManagerCreuse;

public class MatriceCreuse extends Matrice
{

    public MatriceCreuse(int taille)
    {
        super(taille);
        this.partManager = new PartManagerCreuse(taille);
        initMatrice();
    }

    public MatriceCreuse(Matrice m)
    {
        super(m);
        this.partManager = new PartManagerCreuse(taille);
        initMatrice(m);
    }

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
