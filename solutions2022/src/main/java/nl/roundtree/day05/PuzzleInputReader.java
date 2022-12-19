package nl.roundtree.day05;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

class PuzzleInputReader {

    static List<MoveCommand> readMoveCommandsInput(final String path) {
        final List<MoveCommand> moveCommands = new ArrayList<>();

        try (final InputStream inputStream = PuzzleInputReader.class.getClassLoader().getResourceAsStream(path);
             final InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             final BufferedReader reader = new BufferedReader(inputStreamReader)) {

            String line = reader.readLine();

            while (line != null) {
                line = line.replace(" ", "").replace("move", "");
                String[] splittedLine = line.split("from");

                final int amount = Integer.parseInt(splittedLine[0]);

                final String[] sourceAndTargetIndex = splittedLine[1].split("to");
                final int sourceStackIndex = Integer.parseInt(sourceAndTargetIndex[0]);
                final int targetStackIndex = Integer.parseInt(sourceAndTargetIndex[1]);

                moveCommands.add(new MoveCommand(amount, sourceStackIndex, targetStackIndex));

                // read next line
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return moveCommands;
    }
}
