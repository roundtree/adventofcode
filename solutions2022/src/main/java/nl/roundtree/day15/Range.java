package nl.roundtree.day15;

import java.util.Comparator;

public class Range implements Comparable<Range> {

    private final int start;
    private int endInclusive;

    public Range(int start, int endInclusive) {
        this.start = start;
        this.endInclusive = endInclusive;
    }

    public void modifyEnd(int endInclusive) {
        this.endInclusive = endInclusive;
    }

    public int getLength() {
        return (endInclusive - start) + 1;
    }

    public int getStart() {
        return start;
    }

    public int getEndInclusive() {
        return endInclusive;
    }

    @Override
    public int compareTo(final Range other) {
        return Comparator.comparing(Range::getStart)
                .thenComparing(Range::getEndInclusive)
                .compare(this, other);
    }
}
