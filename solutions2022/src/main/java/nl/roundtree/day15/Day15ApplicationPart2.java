package nl.roundtree.day15;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;

public class Day15ApplicationPart2 {

    private static final Logger log = LoggerFactory.getLogger(Day15ApplicationPart1.class);

    public static void main(String[] args) {
        SpringApplication.run(Day15ApplicationPart1.class, args);

        final TunnelDeviceMap tunnelDeviceMap = TunnelDeviceMapFactory.setupTunnelDeviceMap();

        log.info("Determining distress beacon frequency without beacon...");
        final long tuningFrequency = tunnelDeviceMap.getDistressBeaconFrequencyWithinCoordinateRange(0, 4_000_000);
        log.info("Distress beacon tuning frequency: {}", tuningFrequency);
    }
}
