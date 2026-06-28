import model.SystemeNavigation;
import service.MoniteurSysteme;

public class Main {
    public static void main(String[] args) {
        MoniteurSysteme moniteur = new MoniteurSysteme();

        moniteur.ajouterSysteme(new SystemeNavigation("ILS"));
        moniteur.ajouterSysteme(new SystemeNavigation("VOR"));
        moniteur.ajouterSysteme(new SystemeNavigation("ATC-01"));
        moniteur.ajouterSysteme(new SystemeNavigation("RADAR-02"));

        // Simuler des incidents
        moniteur.getSysteme("VOR").setStatut("PANNE");
        moniteur.getSysteme("ATC-01").setStatut("ALERTE");

        // Afficher le rapport
        moniteur.afficherRapport();
    }
}