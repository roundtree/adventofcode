package nl.roundtree.day15;

import java.util.List;
import java.util.TreeSet;

public class RowData {

    final int row;
    final int min;
    final int max;

    final TreeSet<Range> rangesWithoutBeacon = new TreeSet<>();

    public static RowData withMinMax(final int row, final int min, final int max) {
        return new RowData(row, min, max);
    }

    public RowData(final int row) {
        this.row = row;
        min = Integer.MIN_VALUE;
        max = Integer.MAX_VALUE;
    }

    private RowData(int row, int min, int max) {
        this.row = row;
        this.min = min;
        this.max = max;
    }

    Integer getEmptyPosition() {
        if (rangesWithoutBeacon.size() > 1) {
            final TreeSet<Range> normalizedRanges = normalizeRanges(rangesWithoutBeacon);
            if (normalizedRanges.size() > 1) {
                // If more than one range is left, it means there is a gap somewhere. The gap will be between the two ranges, so before the start of the second range
                return normalizedRanges.last().getStart() - 1;
            }
        }

        return null;
    }

    void addRangesWithoutBeaconForDevices(final List<Device> devices) {
        devices.forEach(device -> device.getRangeOfFieldsNotContainingBeacon(row)
                .ifPresent(range -> {
                    int minimum = Math.max(range.getStart(), min);
                    int maximum = Math.min(range.getEndInclusive(), max);
                    rangesWithoutBeacon.add(new Range(minimum, maximum));
                }));
    }

    int getAmountOfUnavailablePositions() {
        return normalizeRanges(rangesWithoutBeacon)
                .stream()
                .mapToInt(Range::getLength)
                .sum();
    }

    /**
     * Normalize ranges so no overlapping range exists
     */
    private static TreeSet<Range> normalizeRanges(final TreeSet<Range> rangesToNormalize) {
        final TreeSet<Range> normalizedRanges = new TreeSet<>();
        normalizedRanges.add(rangesToNormalize.first());

        for (final Range currentRange : rangesToNormalize) {
            final Range previousRange = normalizedRanges.last();
            if (currentRange.getStart() <= previousRange.getEndInclusive()) {
                if (currentRange.getEndInclusive() >= previousRange.getEndInclusive()) {
                    previousRange.modifyEnd(currentRange.getEndInclusive());
                }
            } else {
                normalizedRanges.add(new Range(currentRange.getStart(), currentRange.getEndInclusive()));
            }
        }

        return normalizedRanges;
    }
}
