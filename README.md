# AutoLoc - Plateforme de gestion de location de véhicules multi-agences

Projet développé dans le cadre du module **Architecture des Systèmes d'Information (UP ASI)** - ESPRIT.

## 🎯 Objectifs du projet
AutoLoc est une plateforme web de gestion de location de véhicules multi-agences. Elle permet d'automatiser les processus de réservation, de gestion de la flotte automobile et de suivi des clients.

## 👥 Acteurs du système
- **Client :** Consulte le catalogue de véhicules, effectue des réservations et suit son historique de locations.
- **Agent d'agence :** Gère les départs et retours des véhicules et valide les contrats de location.
- **Responsable d'agence :** Suit le chiffre d'affaires, gère la flotte de son agence et consulte les rapports d'activité.
- **Administrateur :** Administre les comptes utilisateurs, les agences et les configurations globales du système.

## 🛠️ Stack Technique
- **Langage / Build :** Java 17, Maven
- **Framework :** Spring Boot 3.x, Spring Data JPA, Spring MVC
- **Base de données :** MySQL (`autoloc_db`)
- **Outillage :** IntelliJ IDEA Ultimate, Git / GitHub, Postman, Lombok