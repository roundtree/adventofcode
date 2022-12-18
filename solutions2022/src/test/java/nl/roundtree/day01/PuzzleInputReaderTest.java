package nl.roundtree.day01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PuzzleInputReaderTest {

    @Test
    void testReadInput() {
        List<Elf> elves = PuzzleInputReader.readPuzzleInput("day01/day01_test_puzzleinput.txt");

        assertThat(elves).hasSize(5);
        assertThat(elves.get(0).caloriesPerFoodItem).isEqualTo(Arrays.asList(1000, 2000, 3000));
        assertThat(elves.get(1).caloriesPerFoodItem).isEqualTo(List.of(4000));
        assertThat(elves.get(2).caloriesPerFoodItem).isEqualTo(Arrays.asList(5000, 6000));
        assertThat(elves.get(3).caloriesPerFoodItem).isEqualTo(Arrays.asList(7000, 8000, 9000));
        assertThat(elves.get(4).caloriesPerFoodItem).isEqualTo(List.of(10000));
    }
}