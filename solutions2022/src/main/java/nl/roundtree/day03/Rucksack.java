package nl.roundtree.day03;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

record Rucksack(Compartment compartment1, Compartment compartment2) {

    int getSumOfPrioritiesForItemsInBothCompartments() {
        final List<Character> itemsInCompartment1 = compartment1.items;

        final Set<Character> charactersInBothCompartments = compartment2.items
                .stream()
                .filter(itemsInCompartment1::contains)
                .collect(Collectors.toSet());

        return charactersInBothCompartments
                .stream()
                .mapToInt(Compartment::getItemPriority)
                .sum();
    }

    public List<Character> getAllItems() {
        ArrayList<Character> allItems = new ArrayList<>(compartment1.items);
        allItems.addAll(compartment2.items);
        return allItems;
    }
}
