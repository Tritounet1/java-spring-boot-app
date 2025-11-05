# Java Spring Boot Project

## Lancer le Project

```sh
mvn spring-boot:run
```

## Mettre à jour les dépendances :

Modifier le fichier `pom.xml`

Et clean le projet :

```sh
mvn clean
```

## Ajouter la dépendance pour le hot reload :

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <optional>true</optional>
</dependency>
```
