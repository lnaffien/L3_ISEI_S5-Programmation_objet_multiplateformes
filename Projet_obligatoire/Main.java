import java.util.Scanner;

public class Main
{
    public static void main(String arg[])
    {
        Scanner in = new Scanner(System.in);
        int taille; 
        System.out.println("Bonjour ! Je suis un createur de matrices carrees, pour vous servir !");

        System.out.println("Veuillez m'indiquer la taille de la matrice carree : ");
        taille = in.nextInt();
        if(taille <= 0)
        {
            throw new ArithmeticException("Taille invalide, veuillez relancer le programme.");
        }        
        MatriceLineaire matLineaire = new MatriceLineaire(taille);
        matLineaire.afficherMatrice();
        MatriceCreuse matCreuse = new MatriceCreuse(matLineaire);
        matLineaire.afficherMatrice();   
    }
}