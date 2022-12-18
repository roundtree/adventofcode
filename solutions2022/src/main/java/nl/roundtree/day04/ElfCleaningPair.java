package nl.roundtree.day04;

record ElfCleaningPair(Range elf1CleaningRange, Range elf2CleaningRange) {

    boolean cleaningRangeFullyOverlaps() {
        return elf1CleaningRange.fullyOverlaps(elf2CleaningRange) || elf2CleaningRange.fullyOverlaps(elf1CleaningRange);
    }

    boolean cleaningRangOverlaps() {
        return elf1CleaningRange.overlaps(elf2CleaningRange);
    }
}
