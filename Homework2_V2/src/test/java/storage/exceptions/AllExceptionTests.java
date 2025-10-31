package storage.exceptions;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("All Exception Tests")
@SelectClasses({
    CellEmptyExceptionTest.class,
    CellLockedExceptionTest.class,
    CellNotFoundExceptionTest.class,
    CellOccupiedExceptionTest.class,
    StorageFullExceptionTest.class
})
public class AllExceptionTests {
}