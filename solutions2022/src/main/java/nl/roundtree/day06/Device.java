package nl.roundtree.day06;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Optional;

class Device {

    static Optional<Integer> getPositionAfterFourUniqueCharacters(final String subroutine, final int numberOfUniqueCharacters) {
        final Deque<String> characterSequence = new ArrayDeque<>();

        char[] subRoutineChars = subroutine.toCharArray();
        for (int i = 0; i < subRoutineChars.length; i++) {
            characterSequence.addLast(String.valueOf(subRoutineChars[i]));

            if (characterSequence.size() == numberOfUniqueCharacters) {
                final HashSet<String> currentCharactersSet = new HashSet<>(characterSequence);
                if (currentCharactersSet.size() == numberOfUniqueCharacters) {
                    // all characters are unique, return next index
                    return Optional.of(i + 1);
                } else {
                    characterSequence.removeFirst();
                }
            }
        }

        return Optional.empty();
    }
}
