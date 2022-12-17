package nl.roundtree.day15;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TunnelDeviceMapTest {

    private TunnelDeviceMap tunnelDeviceMap;

    @BeforeEach
    void setUp() {
        final Beacon beaconRowMinus2 = new Beacon(-2, 15);
        final Beacon beaconRow10 = new Beacon(10, 16);
        final Beacon beaconRow15 = new Beacon(15, 3);
        final Beacon beaconRow2 = new Beacon(2, 10);
        final Beacon beaconRow25 = new Beacon(25, 17);
        final Beacon beaconRow21 = new Beacon(21, 22);

        final List<Beacon> beacons = Arrays.asList(beaconRowMinus2, beaconRow10, beaconRow15, beaconRow2, beaconRow25, beaconRow21);

        final List<Sensor> sensors = Arrays.asList(
                new Sensor(2, 18, beaconRowMinus2),
                new Sensor(9, 16, beaconRow10),
                new Sensor(13, 2, beaconRow15),
                new Sensor(12, 14, beaconRow10),
                new Sensor(10, 20, beaconRow10),
                new Sensor(14, 17, beaconRow10),
                new Sensor(8, 7, beaconRow2),
                new Sensor(2, 0, beaconRow2),
                new Sensor(0, 11, beaconRow2),
                new Sensor(20, 14, beaconRow25),
                new Sensor(17, 20, beaconRow21),
                new Sensor(16, 7, beaconRow15),
                new Sensor(14, 3, beaconRow15),
                new Sensor(20, 1, beaconRow15));

        tunnelDeviceMap = new TunnelDeviceMap(beacons, sensors);
    }

    @Test
    void testGetAmountOfFieldsWithoutDistressBeaconPossibilityForRow() {
        assertThat(tunnelDeviceMap.getAmountOfFieldsWithoutDistressBeaconPossibilityForRow(9)).isEqualTo(25);
        assertThat(tunnelDeviceMap.getAmountOfFieldsWithoutDistressBeaconPossibilityForRow(10)).isEqualTo(26);
        assertThat(tunnelDeviceMap.getAmountOfFieldsWithoutDistressBeaconPossibilityForRow(11)).isEqualTo(27);
    }

    @Test
    void day15PuzzleSolutionToPart1() {
        final TunnelDeviceMap tunnelDeviceMap = TunnelDeviceMapFactory.setupTunnelDeviceMap();

        assertThat(tunnelDeviceMap.getAmountOfFieldsWithoutDistressBeaconPossibilityForRow(2_000_000)).isEqualTo(5256611);
    }

    @Test
    void testGetDistressBeaconFieldLocationWithinCoordinateRange() {
        assertThat(tunnelDeviceMap.getDistressBeaconFrequencyWithinCoordinateRange(0, 20)).isEqualTo(56000011);
    }

    @Test
    void day15PuzzleSolutionToPart2() {
        final TunnelDeviceMap tunnelDeviceMap = TunnelDeviceMapFactory.setupTunnelDeviceMap();

        assertThat(tunnelDeviceMap.getDistressBeaconFrequencyWithinCoordinateRange(0, 4_000_000)).isEqualTo(13337919186981L);
    }

}
