package nl.roundtree.day15;

public class Range {

    private final int start;
    private final int endInclusive;

    public Range(int start, int endInclusive) {
        this.start = start;
        this.endInclusive = endInclusive;
    }

    public int getStart() {
        return start;
    }

    public int getEndInclusive() {
        return endInclusive;
    }
}
