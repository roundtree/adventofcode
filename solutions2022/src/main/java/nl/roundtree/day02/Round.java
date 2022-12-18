package nl.roundtree.day02;

record Round(Action opponentAction, Action playerAction) {

    int getPlayerScore() {
        return playerAction.getPlayerScoreVs(opponentAction);
    }
}
