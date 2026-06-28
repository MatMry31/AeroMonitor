package model;

public class SystemeNavigation extends Composant implements Verifiable {
    private String codeNorme;

    public SystemeNavigation(String nom) {
        super(nom);
        this.codeNorme = "DO-178C";
    }

    @Override
    public boolean verifierIntegrite() {
        return !getStatut().equals("PANNE");
    }

    @Override
    public String rapport() {
        return getNom() + " | Norme : " + codeNorme + " | Statut : " + getStatut();
    }
}