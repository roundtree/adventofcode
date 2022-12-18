package nl.roundtree.day03;

import java.util.*;

public class Rucksacks {

    final List<Rucksack> rucksacks;

    public Rucksacks(List<Rucksack> rucksacks) {
        this.rucksacks = rucksacks;
    }

    int getTotalSumOfPrioritiesForItemsInBothCompartments() {
        return rucksacks
                .stream()
                .mapToInt(Rucksack::getSumOfPrioritiesForItemsInBothCompartments)
                .sum();
    }

    Character getBadgeItem() {
        final Map<Character, Set<Rucksack>> charactersOccuringInRucksacks = new HashMap<>();

        rucksacks.forEach(rucksack -> {
            List<Character> allItems = rucksack.getAllItems();
            allItems.forEach(item -> {
                final Set<Rucksack> ruckSacks = charactersOccuringInRucksacks.getOrDefault(item, new HashSet<>());
                ruckSacks.add(rucksack);
                charactersOccuringInRucksacks.put(item, ruckSacks);
            });
        });

        return charactersOccuringInRucksacks.entrySet()
                .stream()
                .filter(e -> e.getValue().containsAll(rucksacks))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }
}
