package nl.roundtree.day04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

class PuzzleInputReader {

    static ElfCleaningPairList readPuzzleInput(final String path) {
        final ElfCleaningPairList cleaningPairs = new ElfCleaningPairList();

        try (final InputStream inputStream = PuzzleInputReader.class.getClassLoader().getResourceAsStream(path);
             final InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             final BufferedReader reader = new BufferedReader(inputStreamReader)) {

            String line = reader.readLine();

            while (line != null) {
                String[] cleaningRanges = line.split(",");
                String[] elf1CleaningRangeStartAndEnd = cleaningRanges[0].split("-");
                final Range elf1CleaningRange = new Range(Integer.parseInt(elf1CleaningRangeStartAndEnd[0]), Integer.parseInt(elf1CleaningRangeStartAndEnd[1]));
                String[] elf2CleaningRangeStartAndEnd = cleaningRanges[1].split("-");
                final Range elf2CleaningRange = new Range(Integer.parseInt(elf2CleaningRangeStartAndEnd[0]), Integer.parseInt(elf2CleaningRangeStartAndEnd[1]));

                cleaningPairs.add(new ElfCleaningPair(elf1CleaningRange, elf2CleaningRange));

                // read next line
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cleaningPairs;
    }
}
