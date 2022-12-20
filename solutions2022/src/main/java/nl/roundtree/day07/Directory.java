package nl.roundtree.day07;

import java.util.*;

class Directory {

    private static final int FILESYSTEM_SIZE = 70_000_000;

    final String name;

    final Map<String, Directory> subDirectoriesByName = new HashMap<>();
    final List<File> files = new ArrayList<>();

    Directory parentDirectory;

    Directory(final String name) {
        this.name = name;
    }

    void addSubdirectory(final Directory directory) {
        subDirectoriesByName.put(directory.name, directory);
        directory.parentDirectory = this;
    }

    void addFile(final File file) {
        files.add(file);
    }

    int getTotalSizeForSubDirectoriesWithMaximumSize(final int maximumSize) {
        int topLevelDirectoryFileSize = getSizeOfFiles();
        topLevelDirectoryFileSize = topLevelDirectoryFileSize <= maximumSize ? topLevelDirectoryFileSize : 0;

        int subDirectoriesSize = getAllSubDirectories()
                .stream()
                .mapToInt(Directory::getSizeWithAllSubDirectories)
                .filter(s -> s <= maximumSize)
                .sum();

        return topLevelDirectoryFileSize + subDirectoriesSize;
    }

    int getTotalUniqueFileSize() {
        int totalFileSizeOfCurrentDirectory = getSizeOfFiles();

        int totalFileSizeOfAllFileInSubdirectory = getAllSubDirectories()
                .stream()
                .mapToInt(Directory::getSizeOfFiles)
                .sum();

        return totalFileSizeOfCurrentDirectory + totalFileSizeOfAllFileInSubdirectory;
    }

    int getFreeSpace() {
        return FILESYSTEM_SIZE - getTotalUniqueFileSize();
    }

    Directory findSmallestDirectoryToFreeUpMinimumSpace(final int minimumSpace) {
        int freeSpace = getFreeSpace();
        int spaceToFreeUp = Math.abs(minimumSpace - freeSpace);

        return getAllSubDirectories()
                .stream()
                .filter(d -> d.getSizeWithAllSubDirectories() > spaceToFreeUp)
                .min(Comparator.comparing(Directory::getSizeWithAllSubDirectories))
                .orElse(null);
    }

    Directory getSubDirectory(String directoryToNavigateTo) {
        return subDirectoriesByName.values()
                .stream()
                .filter(d -> d.name.equals(directoryToNavigateTo))
                .findFirst()
                .orElse(this);
    }

    private List<Directory> getAllSubDirectories() {
        final List<Directory> allSubDirectories = new ArrayList<>(subDirectoriesByName.values());

        allSubDirectories.addAll(allSubDirectories
                .stream()
                .flatMap(d -> d.getAllSubDirectories().stream())
                .toList());

        return allSubDirectories;
    }

    private int getSizeWithAllSubDirectories() {
        int sizeOfFiles = getSizeOfFiles();

        int sizeOfSubdirectories = subDirectoriesByName.values()
                .stream()
                .mapToInt(Directory::getSizeWithAllSubDirectories)
                .sum();

        return sizeOfFiles + sizeOfSubdirectories;
    }

    private int getSizeOfFiles() {
        return files
                .stream()
                .mapToInt(File::size)
                .sum();
    }
}
