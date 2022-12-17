package nl.roundtree.day15;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.nonNull;

public class TunnelDeviceMap {

    private final List<Device> devices = new ArrayList<>();

    TunnelDeviceMap(final List<Beacon> beacons, final List<Sensor> sensors) {
        this.devices.addAll(beacons);
        this.devices.addAll(sensors);
    }

    int getAmountOfFieldsWithoutBeaconPossibilityForRow(final int row) {
        final RowData rowData = new RowData(row);
        rowData.addRangesWithoutBeaconForDevices(devices);

        int numberOfDevicesOnGivenRow = (int) devices
                .stream()
                .filter(device -> device.field.row == row)
                .count();

        return rowData.getAmountOfUnavailablePositions() - numberOfDevicesOnGivenRow;
    }

    long getDistressBeaconFrequencyWithinCoordinateRange(final int minCoordinateRange, final int maxCoordinateRange) {
        return getDistressBeaconFieldLocationWithinCoordinateRange(minCoordinateRange, maxCoordinateRange)
                .map(distressBeaconField -> ((long) distressBeaconField.column * 4_000_000) + distressBeaconField.row)
                .orElse(0L);
    }

    private Optional<Field> getDistressBeaconFieldLocationWithinCoordinateRange(final int minCoordinateRange, final int maxCoordinateRange) {
        for (int row = minCoordinateRange; row <= maxCoordinateRange; row++) {
            final RowData rowData = RowData.withMinMax(row, minCoordinateRange, maxCoordinateRange);
            rowData.addRangesWithoutBeaconForDevices(devices);

            final Integer emptyColumn = rowData.getEmptyPosition();
            if (nonNull(emptyColumn)) {
                return Optional.of(new Field(emptyColumn, row));
            }
        }

        return Optional.empty();
    }
}
