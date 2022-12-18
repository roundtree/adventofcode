package nl.roundtree.day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

class PuzzleInputReader {

    static List<Elf> readPuzzleInput(final String path) {
        final List<Elf> elves = new ArrayList<>();

        try (final InputStream inputStream = PuzzleInputReader.class.getClassLoader().getResourceAsStream(path);
             final InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             final BufferedReader reader = new BufferedReader(inputStreamReader)) {

            String line = reader.readLine();

            Elf elf = new Elf();
            elves.add(elf);

            while (line != null) {
                if (!line.isBlank()) {
                    elf.addFoodItemNumberOfCalories(Integer.parseInt(line));
                } else {
                    elf = new Elf();
                    elves.add(elf);
                }

                // read next line
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return elves;
    }
}
