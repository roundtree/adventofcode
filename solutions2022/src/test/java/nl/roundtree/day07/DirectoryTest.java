package nl.roundtree.day07;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DirectoryTest {

    @Test
    void testGetTotalSize() {
        final Directory directory = PuzzleInputReader.readPuzzleInput("day07/day07_test_puzzleinput.txt");

        assertThat(directory.getTotalSizeForSubDirectoriesWithMaximumSize(100000)).isEqualTo(95437);
    }

    @Test
    void testDay07SolutionToPart1() {
        final Directory directory = PuzzleInputReader.readPuzzleInput("day07/day07_puzzleinput.txt");

        assertThat(directory.getTotalSizeForSubDirectoriesWithMaximumSize(100000)).isEqualTo(1306611);
    }

    @Test
    void testGetDirectoryToDelete() {
        final Directory directory = PuzzleInputReader.readPuzzleInput("day07/day07_test_puzzleinput.txt");

        final Directory directoryToDelete = directory.findSmallestDirectoryToFreeUpMinimumSpace(30_000_000);
        assertThat(directoryToDelete.getTotalUniqueFileSize()).isEqualTo(24933642);
    }

    @Test
    void testDay07SolutionToPart2() {
        final Directory directory = PuzzleInputReader.readPuzzleInput("day07/day07_puzzleinput.txt");

        final Directory directoryToDelete = directory.findSmallestDirectoryToFreeUpMinimumSpace(30_000_000);
        assertThat(directoryToDelete.getTotalUniqueFileSize()).isEqualTo(13210366);
    }
}