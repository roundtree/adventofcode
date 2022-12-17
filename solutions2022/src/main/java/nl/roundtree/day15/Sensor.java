package nl.roundtree.day15;

public class Sensor extends Device {

    private final Beacon closestBeacon;

    Sensor(final Field field, final Beacon closestBeacon) {
        super(field);
        this.closestBeacon = closestBeacon;
    }

    Sensor(int column, int row, final Beacon closestBeacon) {
        super(new Field(column, row));
        this.closestBeacon = closestBeacon;
    }

    @Override
    Beacon getClosestBeacon() {
        return closestBeacon;
    }

    @Override
    public String toString() {
        return "Sensor{" + "field=" + field + ", closestBeacon=" + closestBeacon + '}';
    }
}
