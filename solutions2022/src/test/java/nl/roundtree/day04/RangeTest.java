package nl.roundtree.day04;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RangeTest {

    @Test
    void testOverlaps() {
        final Range range1 = new Range(2, 4);
        final Range range2 = new Range(3, 6);
        final Range range3 = new Range(6, 8);
        final Range range4 = new Range(9, 10);

        assertThat(range1.overlaps(range1)).isTrue();
        assertThat(range1.overlaps(range2)).isTrue();
        assertThat(range1.overlaps(range3)).isFalse();
        assertThat(range1.overlaps(range4)).isFalse();

        assertThat(range2.overlaps(range1)).isTrue();
        assertThat(range2.overlaps(range2)).isTrue();
        assertThat(range2.overlaps(range3)).isTrue();
        assertThat(range2.overlaps(range4)).isFalse();

        assertThat(range3.overlaps(range1)).isFalse();
        assertThat(range3.overlaps(range2)).isTrue();
        assertThat(range3.overlaps(range3)).isTrue();
        assertThat(range3.overlaps(range4)).isFalse();

        assertThat(range4.overlaps(range1)).isFalse();
        assertThat(range4.overlaps(range2)).isFalse();
        assertThat(range4.overlaps(range3)).isFalse();
        assertThat(range4.overlaps(range4)).isTrue();
    }
}