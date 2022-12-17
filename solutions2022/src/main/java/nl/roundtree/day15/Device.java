package nl.roundtree.day15;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public abstract class Device {

    private static final Logger log = LoggerFactory.getLogger(Device.class);

    final Field field;

    Device(final Field field) {
        this.field = field;
    }

    abstract int getManhattanDistanceToBeacon();

    Set<Field> getFieldsWithoutBeaconForRow(int row) {
        final Set<Field> unavailableFields = new HashSet<>();

        final int manhattanDistanceToBeacon = getManhattanDistanceToBeacon();
        if (manhattanDistanceToBeacon > 0) {
            final int amountOfUnavailablePositionsOnSensorRow = manhattanDistanceToBeacon * 2 + 1;

            int distanceFromSensorRowToProvidedRow = Math.abs((field.row - row));
            final int amountOfUnavailablePositionsOnProvidedRow = amountOfUnavailablePositionsOnSensorRow - (distanceFromSensorRowToProvidedRow * 2);

            if (amountOfUnavailablePositionsOnProvidedRow > 0) {
                final int amountOfUnavailablePositionsBeforeAndAfterSensorColumn = (amountOfUnavailablePositionsOnProvidedRow - 1) / 2;

                log.info("Generating fields for row {}", row);
                if (amountOfUnavailablePositionsBeforeAndAfterSensorColumn > 0) {
                    // generate fields for everything before and including the column position of the sensor
                    for (int column = field.column; column >= field.column - amountOfUnavailablePositionsBeforeAndAfterSensorColumn; column--) {
                        unavailableFields.add(new Field(column, row));
                    }

                    // generate fields for everything after the column position of the sensor
                    for (int column = field.column + 1; column <= field.column + amountOfUnavailablePositionsBeforeAndAfterSensorColumn; column++) {
                        unavailableFields.add(new Field(column, row));
                    }
                }
                log.info("Done generating fields for row {}", row);

            }
        }

        return unavailableFields;
    }

    Optional<Range> getRangeOfUnavailableFieldsForRow(int row) {
        final int manhattanDistanceToBeacon = getManhattanDistanceToBeacon();
        if (manhattanDistanceToBeacon > 0) {
            final int amountOfUnavailablePositionsOnSensorRow = manhattanDistanceToBeacon * 2 + 1;

            int distanceFromSensorRowToProvidedRow = Math.abs((field.row - row));
            final int amountOfUnavailablePositionsOnProvidedRow = amountOfUnavailablePositionsOnSensorRow - (distanceFromSensorRowToProvidedRow * 2);

            if (amountOfUnavailablePositionsOnProvidedRow > 0) {
                final int amountOfUnavailablePositionsBeforeAndAfterSensorColumn = (amountOfUnavailablePositionsOnProvidedRow - 1) / 2;

                int startColumn = field.column - amountOfUnavailablePositionsBeforeAndAfterSensorColumn;
                int endColumn = field.column + amountOfUnavailablePositionsBeforeAndAfterSensorColumn;

                return Optional.of(new Range(startColumn, endColumn));
            }
        }

        return Optional.empty();
    }
}
