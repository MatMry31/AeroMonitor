package service;

import model.SystemeNavigation;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class MoniteurSysteme {
    private List<SystemeNavigation> systemes = new ArrayList<>();

    public void ajouterSysteme(SystemeNavigation s) {
        systemes.add(s);
    }

    public SystemeNavigation getSysteme(String nom) {
        return systemes.stream()
                .filter(s -> s.getNom().equals(nom))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Système introuvable : " + nom));
    }

    public long compterPannes() {
        return systemes.stream()
                .filter(s -> s.getStatut().equals("PANNE"))
                .count();
    }

    public void afficherRapport() {
        System.out.println("=== RAPPORT SYSTEMES ===");
        systemes.forEach(s -> System.out.println(s.rapport()));
        System.out.println("Pannes actives : " + compterPannes());
    }
}