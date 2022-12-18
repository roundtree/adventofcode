package nl.roundtree.day03;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ElfGroupsTest {

    @Test
    void testGetSumOfBadgeItemPriorityForAllGroups() {
        final ElfGroups elfGroups = PuzzleInputReader.readPuzzleInputPart2("day03/day03_test_puzzleinput.txt");

        assertThat(elfGroups.getSumOfBadgeItemPriorityForAllGroups()).isEqualTo(70);
    }

    @Test
    void testDay03PuzzleSolutionToPart2() {
        final ElfGroups elfGroups = PuzzleInputReader.readPuzzleInputPart2("day03/day03_puzzleinput.txt");

        assertThat(elfGroups.getSumOfBadgeItemPriorityForAllGroups()).isEqualTo(2444);
    }
}