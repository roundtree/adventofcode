package nl.roundtree.day05;

import java.util.List;
import java.util.stream.Collectors;

class StackManager {

    private final List<Stack> stacks;

    StackManager(final List<Stack> stacks) {
        this.stacks = stacks;
    }

    void moveCratesOneByOne(final List<MoveCommand> moveCommands) {
        moveCommands.forEach(moveCommand -> {
            final Stack source = stacks.get(moveCommand.sourceIndex() - 1);
            final Stack target = stacks.get(moveCommand.targetIndex() - 1);
            source.moveAmountOfCratesOneByOneTo(moveCommand.amount(), target);
        });
    }

    void moveCratesAsGroup(final List<MoveCommand> moveCommands) {
        moveCommands.forEach(moveCommand -> {
            final Stack source = stacks.get(moveCommand.sourceIndex() - 1);
            final Stack target = stacks.get(moveCommand.targetIndex() - 1);
            source.moveAmountOfCratesAsGroupTo(moveCommand.amount(), target);
        });
    }

    String getTopCratesAsString() {
        return stacks
                .stream()
                .map(Stack::getTopCrate)
                .collect(Collectors.joining());
    }
}
