package nl.roundtree.day15;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day15Application {

    private static final Logger log = LoggerFactory.getLogger(Day15Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Day15Application.class, args);

        final TunnelDeviceMap tunnelDeviceMap = TunnelDeviceMapFactory.setupTunnelDeviceMap();

        log.info("Determining positions without beacon...");
        final int numberOfPositionsWithoutBeacon = tunnelDeviceMap.getAmountOfFieldsWithoutDistressBeaconPossibilityForRow(2_000_000);
        log.info("Amount of positions without beacon: {}", numberOfPositionsWithoutBeacon);
    }
}
