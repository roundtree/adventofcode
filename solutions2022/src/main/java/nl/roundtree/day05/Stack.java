package nl.roundtree.day05;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Stream;

class Stack {

    final Deque<String> crates = new ArrayDeque<>();

    Stack(final String... crates) {
        Stream.of(crates).forEach(this::addCrateToTop);
    }

    void addCrateToTop(final String crate) {
        crates.addFirst(crate);
    }

    String getTopCrate() {
        return crates.getFirst();
    }

    void moveAmountOfCratesOneByOneTo(final int numberOfCrates, final Stack targetStack) {
        for (int i = 0; i < numberOfCrates; i++) {
            if (!crates.isEmpty()) {
                final String crate = crates.pop();
                targetStack.addCrateToTop(crate);
            }
        }
    }

    void moveAmountOfCratesAsGroupTo(final int numberOfCrates, final Stack targetStack) {
        final Deque<String> crateGroup = new ArrayDeque<>();

        for (int i = 0; i < numberOfCrates; i++) {
            if (!crates.isEmpty()) {
                crateGroup.addFirst(crates.pop());
            }
        }

        crateGroup.forEach(targetStack::addCrateToTop);
    }
}
