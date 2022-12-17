package nl.roundtree.day15;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FieldTest {

    @Test
    void testGetManhattanDistanceToExampleFromExercise() {
        final Field field1 = new Field(8, 7);
        final Field field2 = new Field(2, 10);

        assertThat(field1.getManhattanDistanceTo(field2)).isEqualTo(9);

    }

    @Test
    void testGetManhattanDistanceTo() {
        final Field field1 = new Field(0, -10);
        final Field field2 = new Field(7, -3);

        assertThat(field1.getManhattanDistanceTo(field2)).isEqualTo(14);
    }

    @Test
    void testGetManhattanDistanceToAllPositiveCoordinates() {
        final Field field1 = new Field(20, 10);
        final Field field2 = new Field(27, 17);

        assertThat(field1.getManhattanDistanceTo(field2)).isEqualTo(14);
    }

    @Test
    void testGetManhattanDistanceToAllNegativeCoordinates() {
        final Field field1 = new Field(-20, -10);
        final Field field2 = new Field(-27, -17);

        assertThat(field1.getManhattanDistanceTo(field2)).isEqualTo(14);
    }
}