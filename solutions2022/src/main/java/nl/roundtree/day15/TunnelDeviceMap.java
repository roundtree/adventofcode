package nl.roundtree.day15;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TunnelDeviceMap {

    private final List<Device> devices = new ArrayList<>();

    TunnelDeviceMap(final List<Beacon> beacons, final List<Sensor> sensors) {
        this.devices.addAll(beacons);
        this.devices.addAll(sensors);
    }

    int getAmountOfFieldsWithoutDistressBeaconPossibilityForRow(int row) {
        // Ask each device, based on the closest beacon, for the fields witch cannot contain a beacon for a certain row
        final Set<Field> fieldsWithoutBeaconPossibility = devices
                .stream()
                .flatMap(device -> device.getFieldsWithoutBeaconForRow(row).stream())
                .collect(Collectors.toSet());

        // Remove all devices on the given row, they won't count in the number of fields that can't contain a beacon
        fieldsWithoutBeaconPossibility.removeAll(getFieldsWithDeviceOnRow(row));

        return fieldsWithoutBeaconPossibility.size();
    }

    private Set<Field> getFieldsWithDeviceOnRow(int row) {
        return devices
                .stream()
                .map(d -> d.field)
                .filter(field -> field.row == row)
                .collect(Collectors.toSet());
    }
}
