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

## Jakarta validation

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

### Link

[Medium, Guide to field validation with jakarta validation](https://agussyahrilmubarok.medium.com/guide-to-field-validation-with-jakarta-validation-in-spring-8c9eca68022e)

## Lombok

Lombok is a Java library that aims to reduce this boilerplate by automatically generating code for commonly used patterns like getters, setters, constructors...

By integrating Lombok with Spring Boot, you can significantly simplify your code, making it easier to read, maintain, and write.

### Add to dependecy (pom.xml)

```xml
  <dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <version>1.18.34</version>
      <scope>provided</scope>
  </dependency>
```

### Link

[Medium, Using Lombok in Spring Boot](https://medium.com/devdomain/using-lombok-in-spring-boot-simplifying-your-code-c38057894cb8)

## Swagger

### Change swagger api path

Add to application.properties :

```xml
springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui-custom.html
springdoc.swagger-ui.operationsSorter=method
```

### Add to dependecy (pom.xml)

```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.8.5</version>
</dependency>
```

### Link

JSON format : `http://localhost:8080/v3/api-docs`

Html format : `http://localhost:8080/swagger-ui/index.html`
