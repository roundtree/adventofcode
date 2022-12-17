package nl.roundtree.day15;

import java.util.Objects;

public class Field {

    final Integer column;
    final Integer row;

    Field(final int column, final int row) {
        this.column = column;
        this.row = row;
    }

    int getManhattanDistanceTo(final Field toField) {
        int euclideanDistanceX = Math.abs(this.column - toField.column);
        int euclideanDistanceY = Math.abs(this.row - toField.row);
        return euclideanDistanceX + euclideanDistanceY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field position = (Field) o;
        return column.equals(position.column) && row.equals(position.row);
    }

    @Override
    public int hashCode() {
        return Objects.hash(column, row);
    }

    @Override
    public String toString() {
        return "Field{column=" + column + ", row=" + row + '}';
    }
}
