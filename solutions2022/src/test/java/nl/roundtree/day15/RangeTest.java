package nl.roundtree.day15;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RangeTest {

    @Test
    void testLength() {
        final Range range = new Range(-10, 20);

        assertThat(range.getLength()).isEqualTo(31);
    }

    @Test
    void modifyEnd() {
        final Range range = new Range(0, 20);

        range.modifyEnd(30);

        assertThat(range.getEndInclusive()).isEqualTo(30);
    }

}