package Matrice;

public interface PartManager
{
    public int getValueFromIndex(int hauteur, int largeur);
    public void ajouterValeur(int hauteur, int largeur, int valeur);
    public void afficherPartMatrice();
    public void transposer(int hauteur, int largeur); 
}
