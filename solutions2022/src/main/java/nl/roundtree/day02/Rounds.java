package nl.roundtree.day02;

import java.util.List;

public class Rounds {

    final List<Round> rounds;

    Rounds(List<Round> rounds) {
        this.rounds = rounds;
    }

    public int getTotalPlayerScore() {
        return rounds
                .stream()
                .mapToInt(Round::getPlayerScore)
                .sum();
    }
}
