package nl.roundtree.day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import static java.util.Objects.nonNull;

class PuzzleInputReader {

    static Directory readPuzzleInput(final String path) {
        final Directory toplevelDirectory = new Directory("/");

        try (final InputStream inputStream = PuzzleInputReader.class.getClassLoader().getResourceAsStream(path);
             final InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             final BufferedReader reader = new BufferedReader(inputStreamReader)) {

            Directory currentDirectory = toplevelDirectory;
            String line = reader.readLine();

            while (nonNull(line)) {
                if (line.startsWith("$")) {
                    //command
                    final String command = line.replace("$ ", "");
                    if (command.startsWith("cd")) {
                        String directoryToNavigateTo = command.replace("cd ", "");
                        if ("/" .equals(directoryToNavigateTo)) {
                            currentDirectory = toplevelDirectory;
                        } else if (".." .equals(directoryToNavigateTo)) {
                            currentDirectory = currentDirectory.parentDirectory;
                        } else {
                            currentDirectory = currentDirectory.getSubDirectory(directoryToNavigateTo);
                        }

                        // read next line
                        line = reader.readLine();
                    } else if (command.startsWith("ls")) {
                        // fill the directory with files
                        line = reader.readLine();
                        while (nonNull(line) && !line.startsWith("$")) {
                            if (line.startsWith("dir")) {
                                final String dirName = line.replace("dir ", "");
                                final Directory directory = currentDirectory.subDirectoriesByName.getOrDefault(dirName, new Directory(dirName));
                                currentDirectory.addSubdirectory(directory);
                            } else {
                                final String[] fileSizeAndName = line.split(" ");
                                final int fileSize = Integer.parseInt(fileSizeAndName[0]);
                                final String fileName = fileSizeAndName[1];
                                currentDirectory.addFile(new File(fileName, fileSize));
                            }

                            line = reader.readLine();
                        }

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return toplevelDirectory;
    }
}
