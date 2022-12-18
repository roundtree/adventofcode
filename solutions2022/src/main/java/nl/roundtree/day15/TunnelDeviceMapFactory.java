package nl.roundtree.day15;

import java.util.Arrays;
import java.util.List;

class TunnelDeviceMapFactory {

    static TunnelDeviceMap setupTunnelDeviceMap() {
        final Beacon beaconRow2674241 = new Beacon(2674241, 4192888);
        final Beacon beaconRow2154954 = new Beacon(2154954, -342775);
        final Beacon beaconRow3444765 = new Beacon(3444765, 2347460);
        final Beacon beaconRow2761496 = new Beacon(2761496, 2831113);
        final Beacon beaconRow2729595 = new Beacon(2729595, 2000000);
        final Beacon beaconRow4006219 = new Beacon(4006219, 3011198);
        final Beacon beaconRow3754119 = new Beacon(3754119, 4475047);
        final Beacon beaconRowMinus276514 = new Beacon(-276514, 2995794);
        final Beacon beaconRowMinus281319 = new Beacon(-281319, 668868);

        final List<Beacon> beacons = Arrays.asList(beaconRow2674241, beaconRow2154954, beaconRow3444765, beaconRow2761496,
                beaconRow2729595, beaconRow4006219, beaconRow3754119, beaconRowMinus276514, beaconRowMinus281319);

        final List<Sensor> sensors = Arrays.asList(
                new Sensor(1384790, 3850432, beaconRow2674241),
                new Sensor(2825953, 288046, beaconRow2154954),
                new Sensor(3553843, 2822363, beaconRow3444765),
                new Sensor(2495377, 3130491, beaconRow2761496),
                new Sensor(1329263, 1778185, beaconRow2729595),
                new Sensor(2882039, 2206085, beaconRow2729595),
                new Sensor(3903141, 2510440, beaconRow4006219),
                new Sensor(3403454, 3996578, beaconRow3754119),
                new Sensor(3630476, 1048796, beaconRow3444765),
                new Sensor(16252, 2089672, beaconRowMinus276514),
                new Sensor(428672, 1150723, beaconRowMinus281319),
                new Sensor(2939101, 3624676, beaconRow2674241),
                new Sensor(3166958, 2890076, beaconRow2761496),
                new Sensor(3758241, 3546895, beaconRow4006219),
                new Sensor(218942, 3011070, beaconRowMinus276514),
                new Sensor(52656, 3484635, beaconRowMinus276514),
                new Sensor(2057106, 405314, beaconRow2154954),
                new Sensor(1966905, 2495701, beaconRow2761496),
                new Sensor(511976, 2696731, beaconRowMinus276514),
                new Sensor(3094465, 2478570, beaconRow3444765),
                new Sensor(806671, 228252, beaconRowMinus281319),
                new Sensor(3011731, 1976307, beaconRow2729595));

        return new TunnelDeviceMap(beacons, sensors);
    }
}
