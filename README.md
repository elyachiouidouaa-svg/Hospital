#HOSPITAL
# Compte rendu de l'Activité pratique N°2 - ORM, JPA, Hibernate, Spring Data

## Description
Cette application est développée avec **Spring Boot** et permet de gérer les activités d'un **hôpital**.  
Elle utilise **JPA** et **Hibernate** pour le mapping objet-relationnel (ORM) et **Spring Data** pour simplifier l'accès à la base de données.

## Fonctionnalités principales
- Gestion des **patients**, **médecins**, **rendez-vous** et **consultations**.
- Création, lecture, mise à jour et suppression (**CRUD**) des entités.
- Suivi des **rapports de consultation** associés aux rendez-vous.
- Utilisation de **Spring Data JPA** pour interagir facilement avec la base de données.

## Technologies utilisées
- Spring Boot  
- Spring Data JPA  
- Hibernate  
- Maven  
- Base de données (H2/MySQL selon la configuration)

## Déroulement de l'application

Au début du projet, nous avons créé les **entités principales** de l'application :  
- **Patient**  
- **Médecin**  
- **Rendez-vous**  
- **Consultation**  

Chaque entité a été définie avec ses attributs et ses relations afin de représenter correctement le modèle de données d'un hôpital.

Ensuite, nous avons créé les **repositories** correspondants pour chaque entité en utilisant **Spring Data JPA**, ce qui permet de gérer facilement les opérations **CRUD** (création, lecture, mise à jour et suppression) sur la base de données.

   ```bash
   git clone https://github.com/elyachiouidouaa-svg/Hospital.git
