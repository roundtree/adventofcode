package nl.roundtree.day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Objects.nonNull;

class PuzzleInputReader {

    static Rucksacks readPuzzleInputPart1(final String path) {
        final List<Rucksack> rucksacks = new ArrayList<>();

        try (final InputStream inputStream = PuzzleInputReader.class.getClassLoader().getResourceAsStream(path);
             final InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             final BufferedReader reader = new BufferedReader(inputStreamReader)) {

            String line = reader.readLine();

            while (line != null) {
                if (!line.isBlank()) {
                    rucksacks.add(createRucksack(line));
                }

                // read next line
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Rucksacks(rucksacks);
    }

    static ElfGroups readPuzzleInputPart2(final String path) {
        final List<ElfGroup> elfGroups = new ArrayList<>();

        try (final InputStream inputStream = PuzzleInputReader.class.getClassLoader().getResourceAsStream(path);
             final InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             final BufferedReader reader = new BufferedReader(inputStreamReader)) {

            ElfGroup elfGroup = readElfGroup(reader);
            while (nonNull(elfGroup)) {
                elfGroups.add(elfGroup);
                elfGroup = readElfGroup(reader);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ElfGroups(elfGroups);
    }

    private static ElfGroup readElfGroup(BufferedReader reader) throws IOException {
        final String elf1RucksackData = reader.readLine();
        if (nonNull(elf1RucksackData)) {
            final String elf2RucksackData = reader.readLine();
            final String elf3RucksackData = reader.readLine();

            final List<Rucksack> rucksacks = Stream.of(elf1RucksackData, elf2RucksackData, elf3RucksackData)
                    .map(PuzzleInputReader::createRucksack)
                    .collect(Collectors.toList());
            return new ElfGroup(new Rucksacks(rucksacks));
        }

        return null;
    }

    private static Rucksack createRucksack(String line) {
        int length = line.length();
        String compartment1Data = line.substring(0, length / 2);
        String compartment2Data = line.substring(length / 2, length);

        return new Rucksack(new Compartment(compartment1Data), new Compartment(compartment2Data));
    }
}
