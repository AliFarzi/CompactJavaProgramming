# In order to run this project you need to have maven installed on your system and stanalone this module you can run by switch to branch test-homework2 and run mvn clean install and then mvn test.

# Test Cases and Execution Guide

##  Available Test Suites

### 1. Exception Tests
- **File**: [AllExceptionTests.java](cci:7://file:///Users/usmaanrangrez/Desktop/Homework2Seperate/src/test/java/storage/exceptions/AllExceptionTests.java:0:0-0:0)
- **Tests**:
  - [CellEmptyExceptionTest](cci:2://file:///Users/usmaanrangrez/Desktop/Homework2Seperate/src/test/java/storage/exceptions/CellEmptyExceptionTest.java:6:0-19:1)
  - [CellLockedExceptionTest](cci:2://file:///Users/usmaanrangrez/Desktop/Homework2Seperate/src/test/java/storage/exceptions/CellLockedExceptionTest.java:7:0-9:35)
  - [CellOccupiedExceptionTest](cci:2://file:///Users/usmaanrangrez/Desktop/Homework2Seperate/src/test/java/storage/exceptions/CellOccupiedExceptionTest.java:7:0-9:36)
  - [CellNotFoundExceptionTest](cci:2://file:///Users/usmaanrangrez/Desktop/Homework2Seperate/src/test/java/storage/exceptions/CellNotFoundExceptionTest.java:7:0-9:35)
  - [StorageFullExceptionTest](cci:2://file:///Users/usmaanrangrez/Desktop/Homework2Seperate/src/test/java/storage/exceptions/StorageFullExceptionTest.java:6:0-9:68)

### 2. Exception Handling Tests
- **File**: [AllExceptionHandlingTests.java](cci:7://file:///Users/usmaanrangrez/Desktop/Homework2Seperate/src/test/java/storage/exceptionhandling/AllExceptionHandlingTests.java:0:0-0:0)
- **Tests**:
  - [ExceptionRethrowerTest](cci:2://file:///Users/usmaanrangrez/Desktop/Homework2Seperate/src/test/java/storage/exceptionhandling/ExceptionRethrowerTest.java:8:0-49:1)
  - `MultipleExceptionHandlerTest`
  - [ResourceManagerTest](cci:2://file:///Users/usmaanrangrez/Desktop/Homework2Seperate/src/test/java/storage/exceptionhandling/ResourceManagerTest.java:15:0-72:1)

## 🚀 How to Run Tests

### Run All Tests
```bash
cd Homework2_V2/
mvn test
```
### Run Specefic Test Method
```bash
mvn test -Dtest=StorageFullExceptionTest#testDefaultConstructor
```