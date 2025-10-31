package Homework2.StorageModule.tests;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suiite
@SelectClasses({
    CellEmptyExceptionTest.class,
    CellOccupiedExceptionTest.class,
    CellLockedExceptionTest.class,
    CellNotFoundExceptionTest.class,
    StorageFullExceptionTest.class,
    StorageOperationExceptionTest.class
})
public class AllTestsSuite {
}
