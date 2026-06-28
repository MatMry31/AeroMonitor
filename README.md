# AeroMonitor

Système de monitoring aéronautique développé en Java dans le cadre d'une préparation à un entretien en alternance.

## Contexte

Ce projet simule la surveillance de composants embarqués dans un environnement aéronautique. Il met en œuvre les concepts fondamentaux de la POO Java dans un contexte proche des systèmes critiques.

## Fonctionnalités

- Modélisation de composants aéronautiques (`ILS`, `VOR`, `ATC`, `RADAR`)
- Gestion des statuts : `OK`, `ALERTE`, `PANNE`
- Validation des statuts avec levée d'exception sur valeur invalide
- Vérification d'intégrité via l'interface `Verifiable`
- Génération d'un rapport de surveillance avec comptage des pannes actives
- Simulation d'incidents en temps réel

## Architecture

```
src/
├── Main.java                        # Point d'entrée, simulation de pannes
├── model/
│   ├── Composant.java               # Classe de base (nom, statut, validation)
│   ├── Verifiable.java              # Interface : verifierIntegrite() + rapport()
│   └── SystemeNavigation.java       # Composant navigation (norme DO-178C)
└── service/
    └── MoniteurSysteme.java         # Surveillance via Streams, rapport global
test/
└── SystemeNavigationTest.java       # Tests unitaires JUnit 5
```

## Concepts Java utilisés

| Concept | Utilisation |
|---|---|
| Héritage | `SystemeNavigation extends Composant` |
| Interface | `Verifiable` implémentée par les composants |
| Streams | Filtrage des pannes, recherche par nom |
| Exceptions | `IllegalArgumentException`, `NoSuchElementException` |
| Tests JUnit 5 | Vérification des statuts et de l'intégrité |

## Lancer le projet

Ouvrir dans IntelliJ IDEA et exécuter `Main.java`.

Exemple de sortie :

```
=== RAPPORT SYSTEMES ===
ILS | Norme : DO-178C | Statut : OK
VOR | Norme : DO-178C | Statut : PANNE
ATC-01 | Norme : DO-178C | Statut : ALERTE
RADAR-02 | Norme : DO-178C | Statut : OK
Pannes actives : 1
```

## Technologies

- Java 17
- JUnit 5
- IntelliJ IDEA
