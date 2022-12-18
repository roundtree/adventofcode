package nl.roundtree.day04;

import java.util.Comparator;

record Range(int start, int endInclusive) implements Comparable<Range> {

    public boolean fullyOverlaps(final Range other) {
        return (start <= other.start) && endInclusive >= other.endInclusive;
    }

    public boolean overlaps(final Range other) {
        return (start <= other.start && endInclusive >= other.start)
                || (start <= other.endInclusive && endInclusive >= other.start);
    }

    @Override
    public int compareTo(final Range other) {
        return Comparator.comparing(Range::start)
                .thenComparing(Range::endInclusive)
                .compare(this, other);
    }

}
