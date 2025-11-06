import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Homework2.EqiupmentModule.model.*;

class AGVTest {

    @Test
    void id_is_set() {
        AGV a = new AGV("A1", null, 2.0, 50.0, 100.0, 200.0, "CS1");
        assertEquals("A1", a.getId());
    }

    @Test
    void state_changes() {
        AGV a = new AGV("A1", null, 2.0, 50.0, 100.0, 200.0, "CS1");
        a.setState(Equipment.EquipmentState.BUSY);
        assertEquals(Equipment.EquipmentState.BUSY, a.getState());
    }

    @Test
    void battery_non_negative() {
        AGV a = new AGV("A1", null, 2.0, 50.0, 100.0, 200.0, "CS1");
        assertTrue(a.getBatteryLevel() >= 0);
    }

    @Test
    void speed_non_negative() {
        AGV a = new AGV("A1", null, 2.0, 50.0, 100.0, 200.0, "CS1");
        assertTrue(a.getSpeed() >= 0);
    }

    @Test
    void charging_station_id_can_change() {
        AGV a = new AGV("A1", null, 2.0, 50.0, 100.0, 200.0, "CS1");
        a.setChargingStationId("CS2");
        assertEquals("CS2", a.getChargingStationId());
    }
}
