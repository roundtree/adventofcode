package nl.roundtree.day02;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RoundsTest {

    @Test
    void testGetTotalPlayerScore() {
        final Rounds rounds = PuzzleInputReader.readPuzzleInputPart1("day02/day02_test_puzzleinput.txt");

        assertThat(rounds.getTotalPlayerScore()).isEqualTo(15);
    }

    @Test
    void testDay01PuzzleSolutionToPart1() {
        final Rounds rounds = PuzzleInputReader.readPuzzleInputPart1("day02/day02_puzzleinput.txt");

        assertThat(rounds.getTotalPlayerScore()).isEqualTo(12740);
    }

    @Test
    void testGetTotalPlayerScoreWithEncodedWinLoseDrawvalue() {
        final Rounds rounds = PuzzleInputReader.readPuzzleInputPart2("day02/day02_test_puzzleinput.txt");

        assertThat(rounds.getTotalPlayerScore()).isEqualTo(12);
    }

    @Test
    void testDay01PuzzleSolutionToPart2() {
        final Rounds rounds = PuzzleInputReader.readPuzzleInputPart2("day02/day02_puzzleinput.txt");

        assertThat(rounds.getTotalPlayerScore()).isEqualTo(11980);
    }
}