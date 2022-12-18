package nl.roundtree.day03;

import java.util.List;

public class ElfGroups {

    final List<ElfGroup> elfGroups;

    ElfGroups(final List<ElfGroup> elfGroups) {
        this.elfGroups = elfGroups;
    }

    int getSumOfBadgeItemPriorityForAllGroups() {
        return elfGroups
                .stream()
                .mapToInt(ElfGroup::getSumOfBadgeItemPriority)
                .sum();
    }
}
