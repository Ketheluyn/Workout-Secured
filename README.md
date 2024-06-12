# Fitness Tracker Project

## Project Setup

1. Open Eclipse.
2. Create a new Java project named `FitnessTracker`.
3. Create a package named `com.fitness.tracker`.
4. Add the required classes: `Main`, `User`, `AuthService`, `Goals`, `Exercises`, `Calendar`
5. Add dependencies for JUnit.

## Core Functionality

The project includes a simple user authentication system:
- `Main.java`: Entry point of the application.
- `User.java`: Represents a user with a username and password.
- `AuthService.java`: Provides authentication logic.
- `Goals.java`: Provides the ability for the user to set their goals for intakes.

## Unit Testing

Unit tests are implemented in `AuthServiceTest.java` using JUnit:
- Tests for successful and failed login scenarios.
Unit tests are implemented in `GoalsTest.java` using JUnit:
- Tests for successful logic of implementing goals in the program
Unit tests are implemented in `ExercisesTest.java` using JUnit:
- Tests for successful addition of user-created exercises
Unit tests are implemented in `UserTest.java` using JUnit:
- Tests for successful User management.

## Documentation

- Inline comments and docstrings are used for all classes and methods.
- External documentation is provided in this `README.md` file.

## Running the Project

1. Run `Main.java` to start the application.
2. Execute the various test Java classes.

