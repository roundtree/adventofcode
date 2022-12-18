package nl.roundtree.day03;

import java.util.ArrayList;
import java.util.List;

class Compartment {

    static final String itemsSortedByPriority = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    final List<Character> items;

    Compartment(final String itemString) {
        items = new ArrayList<>();

        for (char c : itemString.toCharArray()) {
            items.add(c);
        }
    }

    static int getItemPriority(final char item) {
        return itemsSortedByPriority.indexOf(item) + 1;
    }
}
