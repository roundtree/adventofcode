package nl.roundtree.day15;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DeviceTest {

    @Test
    void testGetRangeOfFieldsNotContainingBeacon() {
        final Beacon beacon = new Beacon(27, 17);
        final Sensor sensor = new Sensor(20, 10, beacon);

        assertThat(sensor.getRangeOfFieldsNotContainingBeacon(20)).map(Range::getStart).hasValue(16);
        assertThat(sensor.getRangeOfFieldsNotContainingBeacon(20)).map(Range::getEndInclusive).hasValue(24);
    }

    @Test
    void testGetRangeOfFieldsNotContainingBeaconForBeacon() {
        final Beacon beacon = new Beacon(new Field(17, 27));

        assertThat(beacon.getRangeOfFieldsNotContainingBeacon(18)).isEmpty();
    }
}