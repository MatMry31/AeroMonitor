package model;

public class Composant {
    private String nom;
    private String statut;

    public Composant(String nom) {
        this.nom = nom;
        this.statut = "OK";
    }

    public String getNom() { return this.nom; }
    public String getStatut() { return this.statut; }

    public void setStatut(String statut) {
        if (!statut.equals("OK") && !statut.equals("ALERTE") && !statut.equals("PANNE")) {
            throw new IllegalArgumentException("Statut invalide : " + statut);
        }
        this.statut = statut;
    }

    @Override
    public String toString() {
        return nom + " [" + statut + "]";
    }
}