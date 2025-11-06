# TO DO

🏗️ Niveau 4 : Bonnes pratiques entreprise

Ajoute une exception personnalisée ResourceNotFoundException et renvoie un status HTTP 404 propre.
➤ (Cherche comment utiliser @ResponseStatus ou @ControllerAdvice)

Ajoute une validation sur les champs (@NotNull, @Size, etc.) et renvoie une réponse claire en cas d’erreur.
➤ (Cherche jakarta.validation.constraints et @Valid)

Ajoute Lombok pour simplifier ton code (@Getter, @Setter, @Builder, etc.).
➤ (Cherche comment l’activer dans un projet Maven)

🧠 Niveau 5 : Bonus — Niveau entreprise

Ajoute une logique de logging cohérente (logback / slf4j).

Configure des profils Spring (application-dev.properties, application-prod.properties).

Implémente un service métier avec des appels entre plusieurs classes.

Mets en place un endpoint asynchrone (avec @Async).

Ajoute une documentation automatique via Springdoc OpenAPI (Swagger UI).
