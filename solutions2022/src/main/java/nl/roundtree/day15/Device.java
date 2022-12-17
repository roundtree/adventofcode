package nl.roundtree.day15;

import java.util.Optional;

public abstract class Device {

    final Field field;

    Device(final Field field) {
        this.field = field;
    }

    abstract int getManhattanDistanceToBeacon();

    Optional<Range> getRangeOfFieldsNotContainingBeacon(int row) {
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
