package nl.roundtree.day04;

import java.util.ArrayList;

class ElfCleaningPairList extends ArrayList<ElfCleaningPair> {

    public int countFullyOverlappingRanges() {
        return (int) this
                .stream()
                .filter(ElfCleaningPair::cleaningRangeFullyOverlaps)
                .count();
    }

    public int countOverlappingRanges() {
        return (int) this
                .stream()
                .filter(ElfCleaningPair::cleaningRangOverlaps)
                .count();
    }
}
