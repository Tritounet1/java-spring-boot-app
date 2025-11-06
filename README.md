# Java Spring Boot Project

## Run the project

```sh
mvn spring-boot:run
```

## Update the dependencies :

Modify the `pom.xml` file.

And clean the project :

```sh
mvn clean install
```

## Add the dependency for hot reload :

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <optional>true</optional>
</dependency>
```

## Structure

```
first_app
|-> controllers/
|-> models/
|-> repositories/
|-> services/
|-> FirstAppApplication.java # The main entry of the app
```
