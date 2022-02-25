/***********************************************************************************************************************************************

                                                                PartManager
                                                                            par NAFFIEN Lucie (janvier 2022)

Cette classe appartient a un projet realise pour le module "Programmation objet multiplateformes", enseigne par M. MARIAGE, dans le cadre 
de la 3eme annee de licence parcours Informatique des Systemes Embarques et Interactifs de l'Universite Paris 8.

Lien github de l'ensemble du projet : https://github.com/lnaffien/L3_ISEI_S5-Programmation_objet_multiplateformes


************************************************************************************************************************************************/

package Matrice;

public interface PartManager
{
    public int getValueFromIndex(int hauteur, int largeur);
    public void ajouterValeur(int hauteur, int largeur, int valeur);
    public void afficherPartMatrice();
    public void transposer(); 
}
