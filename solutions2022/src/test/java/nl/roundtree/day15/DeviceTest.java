package nl.roundtree.day15;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DeviceTest {

    @Test
    void testGetFieldsWithoutBeaconForRow() {
        final Beacon beacon = new Beacon(new Field(27, 17));
        final Sensor sensor = new Sensor(new Field(20, 10), beacon);

        assertThat(sensor.getFieldsWithoutBeaconForRow(20))
                .hasSize(9)
                .containsExactlyInAnyOrder(
                        new Field(16, 20),
                        new Field(17, 20),
                        new Field(18, 20),
                        new Field(19, 20),
                        new Field(20, 20),
                        new Field(21, 20),
                        new Field(22, 20),
                        new Field(23, 20),
                        new Field(24, 20));
    }

    @Test
    void testGetFieldsWithoutBeaconForRowForBeacon() {
        final Beacon beacon = new Beacon(new Field(17, 27));

        assertThat(beacon.getFieldsWithoutBeaconForRow(18)).isEmpty();
    }
}