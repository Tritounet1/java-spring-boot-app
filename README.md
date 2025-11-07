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

## jakarta.validation.constraints and @Valid

```java
@NotNull(message = "Product name cannot be null") // Send NotValidException if name is null
@NotBlank(message = "Product name cannot be blank") // Send NotValidException if name is blank
private String name;

@NotNull(message = "Price cannot be null") // Send NotValidException if price is null
private Double price;
```

ExceptionHandler for handling the NotValidException :

```java
@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();

    ex.getBindingResult().getAllErrors().forEach((error) -> {
        String fieldName = ((FieldError) error).getField();
        String errorMessage = error.getDefaultMessage();
        errors.put(fieldName, errorMessage);
    });

    return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
}
```
