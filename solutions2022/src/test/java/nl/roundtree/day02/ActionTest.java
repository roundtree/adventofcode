package nl.roundtree.day02;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ActionTest {

    @Test
    void testFromEncodedValue() {
        assertThat(Action.fromEncodedValue("A")).isEqualTo(Action.ROCK);
        assertThat(Action.fromEncodedValue("X")).isEqualTo(Action.ROCK);

        assertThat(Action.fromEncodedValue("B")).isEqualTo(Action.PAPER);
        assertThat(Action.fromEncodedValue("Y")).isEqualTo(Action.PAPER);

        assertThat(Action.fromEncodedValue("C")).isEqualTo(Action.SCISSORS);
        assertThat(Action.fromEncodedValue("Z")).isEqualTo(Action.SCISSORS);
    }

    @Test
    void testFromEncodedValueInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> Action.fromEncodedValue("Lizard"));
    }

    @Test
    void testFromEncodedValueWinDrawOrLose() {
        assertThat(Action.fromEncodedValueWinDrawOrLose(Action.ROCK, "X")).isEqualTo(Action.SCISSORS);
        assertThat(Action.fromEncodedValueWinDrawOrLose(Action.ROCK, "Y")).isEqualTo(Action.ROCK);
        assertThat(Action.fromEncodedValueWinDrawOrLose(Action.ROCK, "Z")).isEqualTo(Action.PAPER);

        assertThat(Action.fromEncodedValueWinDrawOrLose(Action.PAPER, "X")).isEqualTo(Action.ROCK);
        assertThat(Action.fromEncodedValueWinDrawOrLose(Action.PAPER, "Y")).isEqualTo(Action.PAPER);
        assertThat(Action.fromEncodedValueWinDrawOrLose(Action.PAPER, "Z")).isEqualTo(Action.SCISSORS);

        assertThat(Action.fromEncodedValueWinDrawOrLose(Action.SCISSORS, "X")).isEqualTo(Action.PAPER);
        assertThat(Action.fromEncodedValueWinDrawOrLose(Action.SCISSORS, "Y")).isEqualTo(Action.SCISSORS);
        assertThat(Action.fromEncodedValueWinDrawOrLose(Action.SCISSORS, "Z")).isEqualTo(Action.ROCK);
    }

    @Test
    void testGetPlayerScoreVs() {
        assertThat(Action.ROCK.getPlayerScoreVs(Action.SCISSORS)).isEqualTo(7);
        assertThat(Action.ROCK.getPlayerScoreVs(Action.ROCK)).isEqualTo(4);
        assertThat(Action.ROCK.getPlayerScoreVs(Action.PAPER)).isEqualTo(1);

        assertThat(Action.PAPER.getPlayerScoreVs(Action.ROCK)).isEqualTo(8);
        assertThat(Action.PAPER.getPlayerScoreVs(Action.PAPER)).isEqualTo(5);
        assertThat(Action.PAPER.getPlayerScoreVs(Action.SCISSORS)).isEqualTo(2);

        assertThat(Action.SCISSORS.getPlayerScoreVs(Action.PAPER)).isEqualTo(9);
        assertThat(Action.SCISSORS.getPlayerScoreVs(Action.SCISSORS)).isEqualTo(6);
        assertThat(Action.SCISSORS.getPlayerScoreVs(Action.ROCK)).isEqualTo(3);
    }
}