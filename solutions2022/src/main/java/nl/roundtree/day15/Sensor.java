package nl.roundtree.day15;

public class Sensor extends Device {

    final int manhattanDistanceToBeacon;

    Sensor(int column, int row, final Beacon closestBeacon) {
        super(new Field(column, row));
        this.manhattanDistanceToBeacon = field.getManhattanDistanceTo(closestBeacon.field);
    }

    @Override
    int getManhattanDistanceToBeacon() {
        return manhattanDistanceToBeacon;
    }

    @Override
    public String toString() {
        return "Sensor{" + "field=" + field + ", manhattanDistanceToBeacon=" + manhattanDistanceToBeacon + '}';
    }
}
