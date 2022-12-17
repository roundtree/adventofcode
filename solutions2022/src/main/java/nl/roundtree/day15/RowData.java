package nl.roundtree.day15;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RowData {

    final int min;
    final int max;

    final Set<Range> unavailableRanges = new HashSet<>();

    public static RowData withMinMax(final int min, final int max) {
        return new RowData(min, max);
    }

    private RowData(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public void addRangeForRow(final int row, final Device device) {
        device.getRangeOfUnavailableFieldsForRow(row).ifPresent(range -> {
            int minimum = Math.max(range.getStart(), min);
            int maximum = Math.min(range.getEndInclusive(), max);
            unavailableRanges.add(new Range(minimum, maximum));
        });
    }

    Integer getEmptyColumn() {
        final List<Range> sortedRanges = unavailableRanges
                .stream()
                .sorted(Comparator.comparing(Range::getStart))
                .toList();

        if (sortedRanges.size() > 1) {
            Range completeRange = sortedRanges.get(0);
            if (completeRange.getStart() > 0) {
                // found it! First range has start greater than 0
                return completeRange.getStart() - 1;
            }

            for (final Range currentRange : sortedRanges) {
                if (currentRange.getStart() <= completeRange.getEndInclusive()) {
                    if (currentRange.getEndInclusive() >= completeRange.getEndInclusive()) {
                        completeRange = new Range(completeRange.getStart(), currentRange.getEndInclusive());
                    }
                } else {
                    // not overlapped, we have found the column! It must be the column before this range
                    return currentRange.getStart() - 1;
                }
            }
        }

        return null;
    }
}
