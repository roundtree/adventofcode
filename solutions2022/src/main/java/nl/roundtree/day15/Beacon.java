package nl.roundtree.day15;

public class Beacon extends Device {

    Beacon(final Field field) {
        super(field);
    }

    Beacon(final int column, final int row) {
        super(new Field(column, row));
    }

    @Override
    Beacon getClosestBeacon() {
        return this;
    }

    @Override
    public String toString() {
        return "Beacon{field=" + field + '}';
    }
}
