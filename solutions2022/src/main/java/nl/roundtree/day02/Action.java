package nl.roundtree.day02;

enum Action {

    ROCK(1),
    PAPER(2),
    SCISSORS(3);

    final int shapePoints;

    Action(int shapePoints) {
        this.shapePoints = shapePoints;
    }


    /**
     * Only applies to part 1 of the puzzle
     */
    static Action fromEncodedValue(final String encodedValue) {
        return switch (encodedValue) {
            case "A", "X" -> ROCK;
            case "B", "Y" -> PAPER;
            case "C", "Z" -> SCISSORS;
            default -> throw new IllegalArgumentException("Cannot decode '" + encodedValue + "' to a valid action");
        };
    }

    /**
     * Only applies to part 2 of the puzzle
     */
    static Action fromEncodedValueWinDrawOrLose(final Action opponentAction, final String winDrawOrLoseEncodedValue) {
        return switch (winDrawOrLoseEncodedValue) {
            case "X" -> getLoseAction(opponentAction);
            case "Y" -> opponentAction;
            case "Z" -> getWinAction(opponentAction);
            default ->
                    throw new IllegalArgumentException("Cannot decode win/draw/lose value '" + winDrawOrLoseEncodedValue + "' to a valid action");
        };
    }

    int getPlayerScoreVs(final Action opponentAction) {
        if (draws(opponentAction)) {
            return shapePoints + 3;
        } else if (beats(opponentAction)) {
            return shapePoints + 6;
        } else {
            return shapePoints;
        }
    }

    private static Action getWinAction(final Action opponentAction) {
        return switch (opponentAction) {
            case ROCK -> PAPER;
            case PAPER -> SCISSORS;
            case SCISSORS -> ROCK;
        };
    }

    private static Action getLoseAction(final Action opponentAction) {
        return switch (opponentAction) {
            case ROCK -> SCISSORS;
            case PAPER -> ROCK;
            case SCISSORS -> PAPER;
        };
    }

    private boolean draws(final Action opponentAction) {
        return this.equals(opponentAction);
    }

    private boolean beats(final Action opponentAction) {
        return (this.equals(ROCK) && opponentAction.equals(SCISSORS)
                || this.equals(PAPER) && opponentAction.equals(ROCK)
                || this.equals(SCISSORS) && opponentAction.equals(PAPER));
    }
}
