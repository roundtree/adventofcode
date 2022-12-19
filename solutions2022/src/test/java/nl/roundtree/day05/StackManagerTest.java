package nl.roundtree.day05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StackManagerTest {

    private StackManager testStackManager;
    private StackManager solutionStackManager;

    @BeforeEach
    void setUp() {
        final List<Stack> testStacks = Arrays.asList(
                new Stack("Z", "N"),
                new Stack("M", "C", "D"),
                new Stack("P")
        );

        testStackManager = new StackManager(testStacks);

        final List<Stack> solutionStacks = Arrays.asList(
                new Stack("F", "H", "B", "V", "R", "Q", "D", "P"),
                new Stack("L", "D", "Z", "Q", "W", "V"),
                new Stack("H", "L", "Z", "Q", "G", "R", "P", "C"),
                new Stack("R", "D", "H", "F", "J", "V", "B"),
                new Stack("Z", "W", "L", "C"),
                new Stack("J", "R", "P", "N", "T", "G", "V", "M"),
                new Stack("J", "R", "L", "V", "M", "B", "S"),
                new Stack("D", "P", "J"),
                new Stack("D", "C", "N", "W", "V")
        );

        solutionStackManager = new StackManager(solutionStacks);
    }

    @Test
    void testGetTopCratesAsStringMoveCratesOneByOne() {
        final List<MoveCommand> moveCommands = PuzzleInputReader.readMoveCommandsInput("day05/day05_test_move_commands_puzzleinput.txt");

        testStackManager.moveCratesOneByOne(moveCommands);

        assertThat(testStackManager.getTopCratesAsString()).isEqualTo("CMZ");
    }

    @Test
    void testDay05PuzzleSolutionToPart1() {
        final List<MoveCommand> moveCommands = PuzzleInputReader.readMoveCommandsInput("day05/day05_move_commands_puzzleinput.txt");

        solutionStackManager.moveCratesOneByOne(moveCommands);

        assertThat(solutionStackManager.getTopCratesAsString()).isEqualTo("JDTMRWCQJ");
    }

    @Test
    void testGetTopCratesAsStringMoveCratesAsGroup() {
        final List<MoveCommand> moveCommands = PuzzleInputReader.readMoveCommandsInput("day05/day05_test_move_commands_puzzleinput.txt");

        testStackManager.moveCratesAsGroup(moveCommands);

        assertThat(testStackManager.getTopCratesAsString()).isEqualTo("MCD");
    }

    @Test
    void testDay05PuzzleSolutionToPart2() {
        final List<MoveCommand> moveCommands = PuzzleInputReader.readMoveCommandsInput("day05/day05_move_commands_puzzleinput.txt");

        solutionStackManager.moveCratesAsGroup(moveCommands);

        assertThat(solutionStackManager.getTopCratesAsString()).isEqualTo("VHJDDCWRD");
    }
}