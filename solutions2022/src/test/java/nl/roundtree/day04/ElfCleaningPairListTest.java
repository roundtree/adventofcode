package nl.roundtree.day04;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ElfCleaningPairListTest {

    @Test
    void testCountFullyOverlappingRanges() {
        final ElfCleaningPairList elfCleaningPairs = PuzzleInputReader.readPuzzleInput("day04/day04_test_puzzleinput.txt");

        assertThat(elfCleaningPairs.countFullyOverlappingRanges()).isEqualTo(2);
    }

    @Test
    void testDay04PuzzleSolutionToPart1() {
        final ElfCleaningPairList elfCleaningPairs = PuzzleInputReader.readPuzzleInput("day04/day04_puzzleinput.txt");

        assertThat(elfCleaningPairs.countFullyOverlappingRanges()).isEqualTo(431);
    }

    @Test
    void testCountOverlappingRanges() {
        final ElfCleaningPairList elfCleaningPairs = PuzzleInputReader.readPuzzleInput("day04/day04_test_puzzleinput.txt");

        assertThat(elfCleaningPairs.countOverlappingRanges()).isEqualTo(4);
    }

    @Test
    void testDay04PuzzleSolutionToPart2() {
        final ElfCleaningPairList elfCleaningPairs = PuzzleInputReader.readPuzzleInput("day04/day04_puzzleinput.txt");

        assertThat(elfCleaningPairs.countOverlappingRanges()).isEqualTo(823);
    }
}