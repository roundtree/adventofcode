package nl.roundtree.day02;

public class Round {

    final Action opponentAction;
    final Action playerAction;

    Round(final Action opponentAction, final Action playerAction) {
        this.opponentAction = opponentAction;
        this.playerAction = playerAction;
    }

    int getPlayerScore() {
        return playerAction.getPlayerScoreVs(opponentAction);
    }
}
