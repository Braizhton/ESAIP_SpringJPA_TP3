# TP3 - Spring Data JPA
- Réalisé par Arthur STEPHANT DURAND
- IRA2026 - ESAIP Angers

# Utilisation de la base de donnée locale H2
## En mode DEV avec reset (drop)
Simple et rapide, à chaque lancement de l'application, les tables sont recréées et remplies avec Hibernate et le script SQL respectivement.
1) Implémenter toutes les classes Entity JPA (Animal, Personne, Role, Species)
2) Renseigner le fichier `resources/data.sql` avec le script d'insertion des entrées de chaque table
3) Dans le fichier `application.properties` :
```shell
# Création des tables selon les classes implémentées et drop à la fermeture de l'application
spring.jpa.hibernate.ddl-auto=create-drop
# Script d'initialisation des tables via resources/data.sql exécuté à chaque lancement de l'application
spring.sql.init.mode=always
# Attente de la fin de l'initialisation des tables avant de lancer le script d'alimentation des tables
spring.jpa.defer-datasource-initialization=true
```
4) Lancer l'application

## En mode DEV sans reset
Plus complexe, il faut s'assurer que l'application tourne sans planter pour pouvoir accéder à la console H2, créer les tables et les alimenter avec le script SQL, et enfin mettre en marche Hibernate au lancement de l'application.
1) Lancer l'application en veillant bien à avoir commenté le contenu de la fonction `run(String... args)` dans `SpringDataJpaApplication`, ainsi que commenté ou supprimé les entrées suivantes du fichier `application.properties` :
```shell
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.hibernate.ddl-auto=create-drop
spring.sql.init.mode=always
spring.jpa.defer-datasource-initialization=true
```
2) Alimenter la base de donnée directement depuis la console H2 (http://localhost:8080/h2_console) en exécutant le script `resources/data.sql.backup`
3) Implémenter toutes les classes Entity JPA (Animal, Personne, Role, Species)
4) Puis renseigner dans le fichier `application.properties` :
```shell
# Uniquement vérification que les tables sont bien présentes
spring.jpa.hibernate.ddl-auto=validate
```
5) Lancer l'application