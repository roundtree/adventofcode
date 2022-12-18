package nl.roundtree.day01;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

record Elves(List<Elf> elves) {

    Elf findElfCarryingMostCalories() {
        return elves
                .stream()
                .max(Comparator.comparing(Elf::getTotalNumberOfCalories))
                .orElse(null);
    }

    int findCalorieSumOfTopThreeElvesCarryingMostCalories() {
        return findTopThreeElvesCarryingMostCalories()
                .stream()
                .mapToInt(Elf::getTotalNumberOfCalories)
                .sum();
    }

    private List<Elf> findTopThreeElvesCarryingMostCalories() {
        return elves
                .stream()
                .sorted(Comparator.comparing(Elf::getTotalNumberOfCalories, Comparator.reverseOrder()))
                .limit(3)
                .collect(Collectors.toList());
    }
}
