package nl.roundtree.day01;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ElvesTest {

    @Test
    void testFindElfCarryingMostCalories() {
        final Elves elves = new Elves(PuzzleInputReader.readPuzzleInput("day01/day01_test_puzzleinput.txt"));

        assertThat(elves.findElfCarryingMostCalories().getTotalNumberOfCalories()).isEqualTo(24000);
    }

    @Test
    void testDay01PuzzleSolutionToPart1() {
        final Elves elves = new Elves(PuzzleInputReader.readPuzzleInput("day01/day01_puzzleinput.txt"));

        assertThat(elves.findElfCarryingMostCalories().getTotalNumberOfCalories()).isEqualTo(70698);
    }

    @Test
    void testFindCalorieSumOfTopThreeElvesCarryingMostCalories() {
        final Elves elves = new Elves(PuzzleInputReader.readPuzzleInput("day01/day01_test_puzzleinput.txt"));

        assertThat(elves.findCalorieSumOfTopThreeElvesCarryingMostCalories()).isEqualTo(45000);
    }

    @Test
    void testDay01PuzzleSolutionToPart2() {
        final Elves elves = new Elves(PuzzleInputReader.readPuzzleInput("day01/day01_puzzleinput.txt"));

        assertThat(elves.findCalorieSumOfTopThreeElvesCarryingMostCalories()).isEqualTo(206643);
    }

}