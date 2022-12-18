package nl.roundtree.day02;

import java.util.List;

record Rounds(List<Round> rounds) {

    public int getTotalPlayerScore() {
        return rounds
                .stream()
                .mapToInt(Round::getPlayerScore)
                .sum();
    }
}
