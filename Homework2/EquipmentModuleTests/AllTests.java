import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        AGVTest.class,
        ShuttleTest.class,
        CraneTest.class,
        ChargingStationTest.class,
        EquipmentManagerTest.class,
        EquipmentTest.class
})
public class AllTests {
}
