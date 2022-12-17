package nl.roundtree.day15;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

public class TunnelDeviceMap {

    private final List<Device> devices = new ArrayList<>();

    TunnelDeviceMap(final List<Beacon> beacons, final List<Sensor> sensors) {
        this.devices.addAll(beacons);
        this.devices.addAll(sensors);
    }

    int getAmountOfFieldsWithoutDistressBeaconPossibilityForRow(int row) {


        return getFieldsWithoutDistressBeaconPossibilityForRow(row).size();
    }

    Set<Field> getFieldsWithoutDistressBeaconPossibilityForRow(int row) {
        // Ask each device, based on the closest beacon, for the fields witch cannot contain a beacon for a certain row
        final Set<Field> fieldsWithoutBeaconPossibility = devices
                .stream()
                .flatMap(device -> device.getFieldsWithoutBeaconForRow(row).stream())
                .collect(Collectors.toSet());

        // Remove all devices on the given row, they won't count in the number of fields that can't contain a beacon
        fieldsWithoutBeaconPossibility.removeAll(getFieldsWithDeviceOnRow(row));
        return fieldsWithoutBeaconPossibility;
    }

    private Set<Field> getFieldsWithDeviceOnRow(int row) {
        return devices
                .stream()
                .map(d -> d.field)
                .filter(field -> field.row == row)
                .collect(Collectors.toSet());
    }

    long getDistressBeaconFrequencyWithinCoordinateRange(final int minCoordinateRange, final int maxCoordinateRange) {
        final Field distressBeaconField = getDistressBeaconFieldLocationWithinCoordinateRange(minCoordinateRange, maxCoordinateRange);

        if (nonNull(distressBeaconField)) {
            return ((long) distressBeaconField.column * 4_000_000) + distressBeaconField.row;
        }

        return 0L;
    }

    private Field getDistressBeaconFieldLocationWithinCoordinateRange(final int minCoordinateRange, final int maxCoordinateRange) {
        for (int row = minCoordinateRange; row <= maxCoordinateRange; row++) {
            final RowData rowData = RowData.withMinMax(minCoordinateRange, maxCoordinateRange);

            for (final Device device : devices) {
                rowData.addRangeForRow(row, device);
            }

            final Integer emptyColumn = rowData.getEmptyColumn();
            if (nonNull(emptyColumn)) {
                return new Field(emptyColumn, row);
            }
        }

        return null;
    }
}
