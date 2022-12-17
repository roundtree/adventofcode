package nl.roundtree.day15;

import java.util.HashSet;
import java.util.Set;

public abstract class Device {

    final Field field;

    Device(final Field field) {
        this.field = field;
    }

    abstract Beacon getClosestBeacon();

    Set<Field> getFieldsWithoutBeaconForRow(int row) {
        final Set<Field> unavailableFields = new HashSet<>();

        final int manhattanDistanceToBeacon = field.getManhattanDistanceTo(getClosestBeacon().field);
        if (manhattanDistanceToBeacon > 0) {
            final int amountOfUnavailablePositionsOnSensorRow = manhattanDistanceToBeacon * 2 + 1;

            int distanceFromSensorRowToProvidedRow = Math.abs((field.row - row));
            final int amountOfUnavailablePositionsOnProvidedRow = amountOfUnavailablePositionsOnSensorRow - (distanceFromSensorRowToProvidedRow * 2);

            if (amountOfUnavailablePositionsOnProvidedRow > 0) {
                final int amountOfUnavailablePositionsBeforeAndAfterSensorColumn = (amountOfUnavailablePositionsOnProvidedRow - 1) / 2;

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
            }
        }

        return unavailableFields;
    }
}
