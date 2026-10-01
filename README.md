# Java Coffee Machine

A multilingual command-line coffee machine simulator built with Java. The application lets a user choose a coffee, displays a preparation countdown and plays an audio clip before confirming that the drink is ready.

## Current features

- Object-oriented coffee model using inheritance and polymorphism
- Latte, Americano and Espresso options
- English and French language support with `ResourceBundle`
- Custom exception handling for invalid selections
- Countdown performed on a separate thread
- Audio playback with Java Sound
- Application event logging

## Running the application

The project requires Java 21 and Maven.

```bash
mvn clean package
java -cp target/classes com.killianhewson.coffeemachine.Main
```

## Project background

This application was originally developed as a TU Dublin Java programming assignment. This repository contains a portfolio version that restructures and refines the original work. The coursework-provided logger was replaced with an independently written logging utility for this version.

