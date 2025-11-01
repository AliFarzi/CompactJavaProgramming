# in order to run test cases,you have to switch to branch-Homework2 and you need to have maven installed.
# and then follow the readme accordingly

# Exception Handling System

## Team Members & Responsibilities

### Usman 
- **Primary Responsibilities:**
  - Designed and implemented the core exception handling framework
  - Created all custom exceptions and their test cases
  - Implemented the `ExceptionRethrower` and ResourceManager classes
  - Wrote comprehensive test suites

### Ali Shaban
- **Responsibilities:**
  - Assisted with test case development
  - Helped debug exception chaining implementation

### Farzizada
- **Responsibilities:**
  - Helped design test cases
  - Assisted with resource management implementation

### Priyanka
- **Responsibilities:**
  - Assisted with test case implementation
  - Helped with exception message formatting

## Project Overview
This project implements robust exception handling for a storage management system, featuring custom exceptions, proper exception chaining, and resource management.

## Key Features
- Custom exceptions for storage operations
- Exception chaining and rethrowing
- Resource management with AutoCloseable
- Comprehensive test coverage

## Getting Started
```bash
# Build the project
mvn clean install

# Run all tests
mvn test