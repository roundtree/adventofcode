package nl.roundtree.day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

class PuzzleInputReader {

    static Rounds readPuzzleInputPart1(final String path) {
        BiConsumer<List<Round>, String[]> biConsumer = (rounds, encodedActionsInput) -> {
            // For part one, both actions are directly encoded to the corresponding ROCK, PAPER or SCISSORS action
            final Action opponentAction = Action.fromEncodedValue(encodedActionsInput[0]);
            final Action playerAction = Action.fromEncodedValue(encodedActionsInput[1]);
            rounds.add(new Round(opponentAction, playerAction));
        };

        return readPuzzleInput(path, biConsumer);
    }

    static Rounds readPuzzleInputPart2(final String path) {
        final BiConsumer<List<Round>, String[]> biConsumer = (rounds, encodedActionsInput) -> {
            // For part two, the player action is based on the opponent action and if we need to win, lose or draw
            final Action opponentAction = Action.fromEncodedValue(encodedActionsInput[0]);
            final Action playerAction = Action.fromEncodedValueWinDrawOrLose(opponentAction, encodedActionsInput[1]);
            rounds.add(new Round(opponentAction, playerAction));
        };

        return readPuzzleInput(path, biConsumer);
    }

    private static Rounds readPuzzleInput(final String path, final BiConsumer<List<Round>, String[]> biConsumer) {
        final List<Round> rounds = new ArrayList<>();

        try (final InputStream inputStream = PuzzleInputReader.class.getClassLoader().getResourceAsStream(path);
             final InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             final BufferedReader reader = new BufferedReader(inputStreamReader)) {

            String line = reader.readLine();

            while (line != null) {
                if (!line.isBlank()) {
                    String[] encodedActions = line.split(" ");
                    biConsumer.accept(rounds, encodedActions);
                }

                // read next line
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Rounds(rounds);
    }
}
