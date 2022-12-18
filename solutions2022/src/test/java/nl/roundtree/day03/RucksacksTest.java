package nl.roundtree.day03;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RucksacksTest {

    @Test
    void testGetTotalSumOfPrioritiesForItemsInBothCompartments() {
        final Rucksacks rucksacks = PuzzleInputReader.readPuzzleInputPart1("day03/day03_test_puzzleinput.txt");

        assertThat(rucksacks.getTotalSumOfPrioritiesForItemsInBothCompartments()).isEqualTo(157);
    }

    @Test
    void testDay03PuzzleSolutionToPart1() {
        final Rucksacks rucksacks = PuzzleInputReader.readPuzzleInputPart1("day03/day03_puzzleinput.txt");

        assertThat(rucksacks.getTotalSumOfPrioritiesForItemsInBothCompartments()).isEqualTo(7817);
    }
}